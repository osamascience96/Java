/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function login(){
    let username_email = document.getElementById("username_email").value;
    let password = document.getElementById("login_pass").value;
    
    if(username_email === "" || password === ""){
        alert_type = "danger";
        message = "All fields are required";
        $('#login_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        var headers = new Headers();
        headers.append("Content-Type", "application/x-www-form-urlencoded");
        
        var urlencoded = new URLSearchParams();
        urlencoded.append("username_email", username_email);
        urlencoded.append("password", password);
        
        fetch('login_controller', {
                method: 'post',
                headers: headers,
                body: urlencoded,
                redirect: 'follow'
        }).then(response => response.json())
        .then(result => {
            if(result === "no_user"){
                alert_type = "danger";
                message = "Invalid Credentials or User Not Found";
                $('#login_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }else{
                if(result === "user_found_customer"){
                    alert_type = "success";
                    message = "Welcome Customer";
                    $('#login_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                    window.location.replace("index.jsp");
                }else if(result === "user_found_manager"){
                    alert_type = "info";
                    message = "Welcome Manager";
                    $('#login_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                    window.location.replace("management_controller");
                }else if(result === "user_found_admin"){
                    alert_type = "primary";
                    message = "Welcome Admin";
                    $('#login_alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                    window.location.replace("admin_controller");
                }
            }
        });
    }
}