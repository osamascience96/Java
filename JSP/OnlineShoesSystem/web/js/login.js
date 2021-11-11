/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

async function Login(){
    let alert_type = "";
    let message = "";
    
    var username_email = document.getElementById("username_email").value;
    var password = document.getElementById("password_login").value;
    
    // check if the credentials are not empty
    if(username_email === "" || password === ""){
        alert_type = "danger";
        message = "All fields are required";
        $('#alert_placeholder_login').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        var headers = new Headers();
        headers.append("Content-Type", "application/x-www-form-urlencoded");
    
        var urlencoded = new URLSearchParams();
        urlencoded.append("username_email", username_email);
        urlencoded.append("password_login", password);
        
        fetch("login_servlet", {
            method: 'post',
            headers: headers,
            body: urlencoded,
            redirect: 'follow'
        }).then(response => response.json())
        .then(data => {
            if(data === "admin_user_login_success"){
                alert_type = "primary";
                message = "Welcome, Administrator";
                // redirect link
                window.location.replace("admin_servlet");
            }else if(data === "user_not_exists_with_username_or_email"){
                alert_type = "danger";
                message = "User not found with the given username or email";
            }else if(data === "password_incorrect"){
                alert_type = "danger";
                message = "Incorrect Password";
            }else if(data === "password_correct"){
                alert_type = "success";
                message = "User Logged In Successfully";
                // redirect_link
                window.location.replace("index.jsp");
            }
            $('#alert_placeholder_login').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        });
    }
}