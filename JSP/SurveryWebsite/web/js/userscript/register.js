/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function register(){
    var firstName = document.getElementById("first_name").value;
    var lastName = document.getElementById("last_name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm_password").value;
    // check all the credentials are empty
    if(firstName === "" || lastName === "" || email === "" || password === ""){
        alert_type = "danger";
        message = "All the fields are required";
        $('#register_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        if(password !== confirm_password){
            alert_type = "warning";
            message = "Passwords do not match";
            $('#register_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else{
            var header = new Headers();
            header.append("Content-Type", "application/x-www-form-urlencoded");

            var urlencoded = new URLSearchParams();
            urlencoded.append("firstName", firstName);
            urlencoded.append("lastName", lastName);
            urlencoded.append("email", email);
            urlencoded.append("password", password);
        
            fetch("register_servlet", {
                method: 'POST',
                headers: header,
                body: urlencoded,
                redirect: 'follow',
            }).then(response => response.json())
            .then(data => {
                if(data === "user_already_exists"){
                    alert_type = "danger";
                    message = "Sorry! User already exists in the database";
                    $('#register_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                }else if(data === "user_insert_success"){
                    alert_type = "success";
                    message = "Congratulations! You are registered Successfully.";
                    $('#register_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                }else if(data === "user_insert_failed"){
                    alert_type = "danger";
                    message = "Failed! User Insertion Failed.";
                    $('#register_alert_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                }
            });
        }
    }
}