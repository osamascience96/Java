/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function adduser(){
    var username = document.getElementById("add_user_username").value;
    var email = document.getElementById("add_user_email").value;
    var role = document.getElementById("add_user_role").value;
    var password = document.getElementById("add_user_password").value;
    
    var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+")){7,}@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    
    if(username === "" || email === "" || password === ""){
        alert_type = "danger";
        message = "All fields are required";
        $('#adduser_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        // validate username, email and password
        if(username.length <=5){
            alert_type = "danger";
            message = "Username must be greater than 5 characters";
            $('#adduser_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else if(email_regex.test(email) === false){
            alert_type = "danger";
            message = "Invalid Email Address";
            $('#adduser_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else if(password.length <= 7){
            alert_type = "danger";
            message = "Password must be greater than 7 characters";
            $('#adduser_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else{
            var headers = new Headers();
            headers.append("Content-Type", "application/x-www-form-urlencoded");
    
            var urlencoded = new URLSearchParams();
            urlencoded.append("actionType", "insert");
            urlencoded.append("username", username);
            urlencoded.append("email", email);
            urlencoded.append("role", role);
            urlencoded.append("password", password);
            
            fetch('admin_controller', {
                method: 'post',
                headers: headers,
                body: urlencoded,
                redirect: 'follow'
            }).then(response => response.json())
            .then(result => {
                if(result === "user_exists"){
                    alert_type = "danger";
                    message = "User Already Exists";
                    $('#adduser_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                }else if(result === "user_inserted"){
                    alert_type = "success";
                    message = "User Added Successfully";
                    $('#adduser_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                    window.location.replace("admin_controller");
                }
            });
        }
    }
}

async function edituser(){
    var id = document.getElementById("edit_user_id").value;
    var username = document.getElementById("edit_user_username").value;
    var email = document.getElementById("edit_user_email").value;
    var role = document.getElementById("edit_user_role").value;
    var password = document.getElementById("edit_user_password").value;
    
    var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+")){7,}@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    
    if(username === "" || email === "" || password === ""){
        alert_type = "danger";
        message = "All fields are required";
        $('#edituser_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        // validate username, email and password
        if(username.length <=5){
            alert_type = "danger";
            message = "Username must be greater than 5 characters";
            $('#edituser_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else if(email_regex.test(email) === false){
            alert_type = "danger";
            message = "Invalid Email Address";
            $('#edituser_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else if(password.length <= 7){
            alert_type = "danger";
            message = "Password must be greater than 7 characters";
            $('#edituser_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else{
            var headers = new Headers();
            headers.append("Content-Type", "application/x-www-form-urlencoded");
    
            var urlencoded = new URLSearchParams();
            urlencoded.append("actionType", "update");
            urlencoded.append("id", id);
            urlencoded.append("username", username);
            urlencoded.append("email", email);
            urlencoded.append("role", role);
            urlencoded.append("password", password);
            
            fetch('admin_controller', {
                method: 'post',
                headers: headers,
                body: urlencoded,
                redirect: 'follow'
            }).then(response => response.json())
            .then(result => {
                if(result === "user_updated"){
                    alert_type = "success";
                    message = "User Updated Successfully";
                    $('#edituser_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                    window.location.replace("admin_controller");
                }
            });
        }
    }
}


function open_user_modal(id, username, email, password){
    $("#edit_user_id").val(id);
    $("#edit_user_username").val(username);
    $("#edit_user_email").val(email);
    $("#edit_user_password").val(password);
    
    $("#edit_user_modal").modal("show");
}