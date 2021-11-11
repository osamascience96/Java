/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function register(){
    
    var alert_type = "";
    var message = "";
    
    var name = document.getElementById("registration_name").value;
    var username = document.getElementById("registration_username").value;
    var email = document.getElementById("registration_email").value;
    var password = document.getElementById("registration_password").value;
    
    var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+")){7,}@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    
    // check if the values are empty 
    if(name === "" || username === "" || email === "" || password === ""){
        alert_type = "danger";
        message = "All fields are required";
        $('#alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        if(name.length <= 4){
            alert_type = "danger";
            message = "Name length must be greater than 4 chars";
        }else if(username.length <= 7){
            alert_type = "danger";
            message = "Username must be greater than 7 chars";
        }else if(email_regex.test(email) === false){
            alert_type = "danger";
            message = "Please Enter Valid Email Address";
        }else if(password.length <= 6){
            alert_type = "danger";
            message = "Password length must be greater than 6 chars";
        }
        
        if(alert_type === "" && message === ""){
            document.getElementById("register_form").submit();
        }else{
            $('#alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }
    }
}