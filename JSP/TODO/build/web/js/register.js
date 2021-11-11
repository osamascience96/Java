/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function register(){
    var fullname = document.getElementById("fullname").value;
    var email = document.getElementById("email").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var confirmpassword = document.getElementById("confirmpassword").value;
    
    // check if all the fields are filled
    if(fullname === "" || email === "" || username === "" || password === "" || confirmpassword === ""){
        alert_type = "danger";
        message = "All firlds are required";
        $('#alert_register_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else {
        // check if the passwords and confirm passwords are equal 
        if(password !== confirmpassword){
            alert_type = "warning";
            message = "Both Passwords should match each other";
            $('#alert_register_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else{
            var header = new Headers();
            header.append("Content-Type", "application/x-www-form-urlencoded");
            
            var urlencoded = new URLSearchParams();
            urlencoded.append("fullname", fullname);
            urlencoded.append("email", email);
            urlencoded.append("username", username);
            urlencoded.append("password", password);
            
            fetch("register_servlet", {
                method: 'POST',
                headers: header,
                body: urlencoded,
                redirect: 'follow',
            }).then(response => response.json())
            .then(data => {
                if(data === "user_not_inserted"){
                    alert_type = "danger";
                    message = "User couldn't be registered due to some error";
                    $('#alert_register_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                }else if(data === "user_inserted_success"){
                    alert_type = "success";
                    message = "User Registered Successfully";
                    $('#alert_register_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                }else if(data === "user_already_exists"){
                    alert_type = "danger";
                    message = "User already exists";
                    $('#alert_register_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                }
            });
        }
    }
}