/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateOTPCode(){
    let regkey = document.getElementById("otp_reg_key").value;
    let otp_input = document.getElementById("otp_input").value;
    
    var header = new Headers();
    header.append("Content-Type", "application/x-www-form-urlencoded");
    
    var urlencoded = new URLSearchParams();
    urlencoded.append("registration_key", regkey);
    urlencoded.append("otpcode", otp_input);
    
    fetch("validateotp", {
        method: 'POST',
        headers: header, 
        body: urlencoded,
        redirect: 'follow',
    }).then(response => response.json())
        .then(data => {
            if(data === "otpvalidated"){
                alert_type = "primary";
                message = "OTP Validated! Redirecting to login page";
                $('#alert_otp_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                // direct to login servlet
                header = new Headers();
                header.append("Content-Type", "application/x-www-form-urlencoded");
                
                urlencoded = new URLSearchParams();
                urlencoded.append("userID", regkey);
                urlencoded.append("proceedsignature", "login_allow");
                
                fetch("loginServlet", {
                    method: 'POST',
                    headers: header,
                    body: urlencoded,
                    redirect: 'follow',
                }).then(response => response.json())
                .then(data => {
                    if(data === "login_not_allowed"){
                        alert_type = "danger";
                        message = "Login Not Allowed";
                        $('#alert_otp_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                    }else if(data === "login_access_allowed"){
                        alert_type = "success";
                        message = "Login Allowed Successfully!";
                        $('#alert_otp_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                        // redirect to the login page
                        window.location.replace("index.jsp");
                    }else if(data === "login_access_error"){
                        alert_type = "danger";
                        message = "Login failed due to some error!";
                        $('#alert_otp_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                    }else{
                        alert_type = "success";
                        message = "Login Allowed Successfully";
                        $('#alert_otp_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                        // redirect to the login page
                        window.location.replace("index.jsp");
                    }
                });
            }else if(data === "otpinvalidinput"){
                alert_type = "danger";
                message = "Invalid OTP";
                $('#alert_otp_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }
        });
}