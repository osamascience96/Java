/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function register(){
    var username = document.getElementById("reg_username").value;
    var email = document.getElementById("reg_email").value;
    var password = document.getElementById("reg_password").value;
    
    var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+")){7,}@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    
    if(username === "" || email === "" || password === ""){
        alert_type = "danger";
        message = "All fields are required";
        $('#reg_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        // validate username, email and password
        if(username.length <=5){
            alert_type = "danger";
            message = "Username must be greater than 5 characters";
            $('#reg_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else if(email_regex.test(email) === false){
            alert_type = "danger";
            message = "Invalid Email Address";
            $('#reg_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else if(password.length <= 7){
            alert_type = "danger";
            message = "Password must be greater than 7 characters";
            $('#reg_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else{
            var headers = new Headers();
            headers.append("Content-Type", "application/x-www-form-urlencoded");
    
            var urlencoded = new URLSearchParams();
            urlencoded.append("username", username);
            urlencoded.append("email", email);
            urlencoded.append("password", password);
            
            fetch('register_controller', {
                method: 'post',
                headers: headers,
                body: urlencoded,
                redirect: 'follow'
            }).then(response => response.json())
            .then(result => {
                if(result === "user_inserted"){
                    alert_type = "success";
                    message = "User Inserted Successfully";
                    $('#reg_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                }else if(result === "user_exists"){
                    alert_type = "danger";
                    message = "User Already Exists";
                    $('#reg_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                }
            });
        }
    }
}