/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function login(){
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    
    // check if the email and password are not empty
    if(email === "" || password === ""){
        alert_type = "danger";
        message = "All the fields are required";
        $('#login_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        var header = new Headers();
        header.append("Content-Type", "application/x-www-form-urlencoded");

        var urlencoded = new URLSearchParams();
        urlencoded.append("email", email);
        urlencoded.append("password", password);
        
        fetch("login_servlet", {
            method: 'POST',
            headers: header,
            body: urlencoded,
            redirect: 'follow',
        }).then(response => response.json())
        .then(data => {
            if(data === "user_not_exists"){
                alert_type = "primary";
                message = "No user exists with the provided credentials";
                $('#login_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }else if(data === "invalid_password"){
                alert_type = "danger";
                message = "Your Password is Invalid";
                $('#login_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }else if(data === "login_success_admin"){
                alert_type = "info";
                message = "Admin Logged Insuccessfully";
                $('#login_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                window.location.replace("dashboard.jsp");
            }else if(data === "login_success_user"){
                alert_type = "success";
                message = "User Logged In Successfully";
                $('#login_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }
        });
    }
}