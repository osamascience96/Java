/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function login(){
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    
    if(email === "" || password == ""){
        alert_type = "danger";
        message = "All fields required";
        $('#login_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        var header = new Headers();
        header.append("Content-Type", "application/x-www-form-urlencoded");
        
        var urlencoded = new URLSearchParams();
        urlencoded.append("email", email);
        urlencoded.append("password", password);
        
        fetch("CheckLogin", {
            method: 'POST',
            headers: header,
            body: urlencoded,
            redirect: 'follow',
        }).then(response => response.json())
        .then(data => {
            if(data === "user_not_exists"){
                alert_type = "danger";
                message = "User does not exists";
                $('#login_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }else if(data === "invalid_login"){
                alert_type = "danger";
                message = "Invalid Login Credentials";
                $('#login_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }else if(data === "login_success"){
                alert_type = "success";
                message = "User Validated! Login Successful.";
                $('#login_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                window.location.replace("home.jsp");
            }
        });
    }
}