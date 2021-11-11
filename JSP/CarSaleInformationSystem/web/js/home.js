/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+")){7,}@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

function register(){
    var is_field_validated = true;
    
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    
    document.getElementById("username_register_span").style.display = "none";
    document.getElementById("email_register_span").style.display = "none";
    document.getElementById("password_register_span").style.display = "none";
    
    if(username === "" || email === "" || password === ""){
        if(username === ""){
            document.getElementById("username_register_span").innerHTML = "Username must not be empty";
            document.getElementById("username_register_span").style.display = "block";
        }
        
        if(email === ""){
            document.getElementById("email_register_span").innerHTML = "Email must not be empty";
            document.getElementById("email_register_span").style.display = "block";
        }
        
        if(password === ""){
            document.getElementById("password_register_span").innerHTML = "Password must not be empty";
            document.getElementById("password_register_span").style.display = "block";
        }
        
        is_field_validated = false;
    }else{
        if(username.length < 7){
            document.getElementById("username_register_span").innerHTML = "Username must be atleast 7 characters";
            document.getElementById("username_register_span").style.display = "block";
            is_field_validated = false;
        }
        
        if(email_regex.test(email) === false){
            document.getElementById("email_register_span").innerHTML = "Please Enter valid Email Address";
            document.getElementById("email_register_span").style.display = "block";
            is_field_validated = false;
        }
        
        if(password.length < 5){
            document.getElementById("password_register_span").innerHTML = "Password must be atleast 5 characters";
            document.getElementById("password_register_span").style.display = "block";
            is_field_validated = false;
        }
    }
    
    if(is_field_validated === true){
        document.getElementById("register_form").submit();
    }
}
