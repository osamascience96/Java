/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function update_user(){
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var username = document.getElementById("username").value;
    
    // check if the fields are not updated
    if(id === "" || name === "" || email === "" || password === "" || username === ""){
        alert_type = "danger";
        message = "All the fields are required";
        $('#editor_user_alert').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else {
        var header = new Headers();
        header.append("Content-Type", "application/x-www-form-urlencoded");

        var urlencoded = new URLSearchParams();
        urlencoded.append("id", id);
        urlencoded.append("name", name);
        urlencoded.append("email", email);
        urlencoded.append("password", password);
        urlencoded.append("username", username);
        
        fetch("update_user", {
            headers: header,
            method: 'post',
            body: urlencoded,
            redirect: 'follow',
        }).then(response => response.json())
        .then(data => {
            if(data === "not_valid"){
                alert_type = "danger";
                message = "Not Valid";
                $('#editor_user_alert').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }else if(data === "update_success"){
                alert_type = "success";
                message = "User Updated Successfully";
                $('#editor_user_alert').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }else if(data === "update_failed"){
                alert_type = "danger";
                message = "User couldn't be updated due to some technical Problem.";
                $('#editor_user_alert').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }
        });
    }
}