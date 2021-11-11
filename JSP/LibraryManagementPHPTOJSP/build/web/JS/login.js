/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function login(){
    var login_cred = document.getElementById("name_input").value;
    var password = document.getElementById("password_input").value;
    
    var captcha = document.getElementById("inputCaptcha").value;
    var captchatocompare = document.getElementById("captcha_holder").value;
    
    if(login_cred === "" || password === ""){
        alert_type = "danger";
        message = "All fields are required";
        $("#error_div").html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else if(captcha !== captchatocompare){
        alert_type = "danger";
        message = "Captcha Not Matched";
        $("#error_div").html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        // reload the page again
        window.location.replace("index.jsp");
    }else{
        var headers = new Headers();
        headers.append("Content-Type", "application/x-www-form-urlencoded");
    
        var urlencoded = new URLSearchParams();
        urlencoded.append("username", login_cred);
        urlencoded.append("password", password);
        
        fetch("login_servlet_library", {
            method: 'post',
            headers: headers,
            body: urlencoded,
            redirect: 'follow' 
        }).then(response => response.json())
        .then(data => {
            if(data === "admin_login_success"){
                alert_type = "primary";
                message = "Admin Login Successfull";
                $("#error_div").html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                // redirect to admin portal
                window.location.replace("admin_servlet");
            }else if(data === "invalid_credentials"){
                alert_type = "danger";
                message = "Invalid Credentials Provided";
                $("#error_div").html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                // redirect again to the index page
                window.location.replace("index.jsp");
            }else if(data === "membership_inactive"){
                alert_type = "warning";
                message = "Your membership is inactive!Please contact Admin for reactivation.";
                $("#error_div").html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }else if(data === "member_login_success"){
                alert_type = "success";
                message = "Member Login Successfull";
                $("#error_div").html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                // redirect to member interface
                window.location.replace("member_servlet");
            }
        });
    }
}