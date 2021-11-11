/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function login(){
    var username_email = document.getElementById("username_email").value;
    var password = document.getElementById("login_password").value;
    
    // check if the fields are not empty
    if(username_email === "" || password === ""){
        var message = "All Fields are required";
        $('#alert_placeholder_login_modal').html('<div class="alert alert-danger"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        check_login(username_email, password);
    }
}

async function check_login(username_email, password){
    var headers = new Headers();
    headers.append("Content-Type", "application/x-www-form-urlencoded");
    
    var urlencoded = new URLSearchParams();
    urlencoded.append("username_email", username_email);
    urlencoded.append("password", password);
    
    fetch('login_servlet', {
        method: 'post',
        headers: headers,
        body: urlencoded,
        redirect: 'follow'
    }).then(response => response.json())
            .then(result => {
                var message = "";
                var alert_type = "";
        
                if(result === "login_success"){
                    message = "Login Successful!";
                    alert_type = "success";
                    window.location.replace("products.jsp");
                }else if(result === "admin_login_success"){
                    message = "Admin Login Successfull!";
                    alert_type = "primary";
                    window.location.replace("admin.jsp");
                }else{
                    message = "Login Failed! Check your credentials for login";
                    alert_type = "danger";
                }
                
                $('#alert_placeholder_login_modal').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            });
}
