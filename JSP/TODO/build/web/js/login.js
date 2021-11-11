/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function login(){
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    
    if(email === "" || password === ""){
        alert_type = "danger";
        message = "All the fields are required";
        $('#login_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        var header = new Headers();
        header.append("Content-Type", "application/x-www-form-urlencoded");

        var urlencoded = new URLSearchParams();
        urlencoded.append("email", email);
        urlencoded.append("password", password);
        
        fetch("login", {
            method: 'POST',
            headers: header,
            body: urlencoded,
            redirect: 'follow',
        }).then(response => response.json())
        .then(data => {
            if(data === "invalid_credentials"){
                alert_type = "danger";
                message = "Invalid Credentials";
                $('#login_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }else if(data === "user_login_not_allowed"){
                alert_type = "primary";
                message = "You are not approved by the user to login. Contact the user to login";
                $('#login_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }else if(data === "user_login_success"){
                alert_type = "success";
                message = "User Login Successfull";
                $('#login_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                window.location.replace("admin");
            }else if(data === "admin_login_success"){
                alert_type = "info";
                message = "Admin Login Successfull";
                $('#login_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                window.location.replace("admin");
            }
        });
    }
    
}