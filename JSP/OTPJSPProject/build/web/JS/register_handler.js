/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function register_handler(){
    let holdingNumber = document.getElementById("holding_no").value;
    let zone = document.getElementById("zone").value;
    let zone_owner = document.getElementById("zone_owner").value;
    var mobile_num = document.getElementById("mobile_num").value;
    var alter_mobile_num = document.getElementById("alter_mobile_num").value;
    var email = document.getElementById("email").value;
    var confirm_email = document.getElementById("confirm_email").value;
    
    if(holdingNumber === "" || zone === "" || zone_owner === "" || mobile_num === "" || alter_mobile_num === "" || email === "" || confirm_email === ""){
        alert_type = "danger";
        message = "All fields are required";
        $('#alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        if(email !== confirm_email){
            alert_type = "danger";
            message = "Your email does not match the confirm email";
            $('#alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else{
//            solve this problem later on 
//          send the request to the link by fetch
            var sampleResponse = {"status":"OK","data":[{"id":"155966324-1","mobile":"918884369686","status":"SUBMITTED"}],"msgid":"2564155966324112","message":"message Submitted successfully"};
            
            if(sampleResponse['data'][0]['status'] === "SUBMITTED"){        
                var header = new Headers();
                header.append("Content-Type", "application/x-www-form-urlencoded");
            
                var urlencoded = new URLSearchParams();
                urlencoded.append("holdingnum", holdingNumber);
                urlencoded.append("zone", zone);
                urlencoded.append("zone_owner", zone_owner);
                urlencoded.append("mobile_num", mobile_num);
                urlencoded.append("alter_mobile_num", alter_mobile_num);
                urlencoded.append("email", email);

                fetch("RegisterServlet", {
                    method: 'post',
                    headers: header,
                    body: urlencoded,
                    redirect: 'follow',
                }).then(response => response.json())
                .then(data => {
                    if(data !== "user_not_registered"){
                        // update the otp in db
                        let registerKey = data;
                        urlencoded = new URLSearchParams();
                        urlencoded.append("register_id", registerKey);
                        // input the random otp generated here
                        // we'll have the random otp here
                        urlencoded.append("otp_input", 1234);
                        document.getElementById("otp_reg_key").value = registerKey;
                        
                        fetch("UpdateRegistration", {
                            method: 'post',
                            headers: header,
                            body: urlencoded,
                            redirect: 'follow',
                        }).then(resp => resp.json())
                        .then(result => {
                            // open the modal to validate the otp
                            if(result === "updated_success"){
                                $("#otpModal").modal("show");
                            }else if(result === "updated_failed"){
                                alert_type = "danger";
                                message = "OTP not updated in database due to some technical error";
                                $('#alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                            }
                        });
                
                    }else{
                        alert_type = "danger";
                        message = "Registration could not be made due to some error";
                        $('#alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                    }
                });
            }else{
                alert_type = "danger";
                message = "OTP cannot be generated due to some reason";
                $('#alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }
        }
    }
}