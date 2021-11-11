/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// email address regex searched from W3schoold and other websites and then combined
// before @, the start suffix must be ateast 7 characters, as also mentioned in the regex  on line number 9
var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+")){7,}@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

function register(){
    let fullname = document.getElementById("fullname").value;
    let username = document.getElementById("username").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    
    let is_valid = true;
    
    // check if the values are empty
    if(!(fullname === "" || username === "" || email === "" || password === "")){
        // display none to the empty messages
        document.getElementById("fullname_empty_message").style.display = "none";
        document.getElementById("user_name_empty_message").style.display = "none";
        document.getElementById("email_empty_message").style.display = "none";
        document.getElementById("password_empty_message").style.display = "none";
        
        // if the fullname length is less than 7 characters
        if(fullname.length < 7){
            document.getElementById("fullname_message").style.display = "block";
            is_valid = false;
        }
        
        // if the username length is less than 8 characters
        if(username.length < 8){
            document.getElementById("user_name_message").style.display = "block";
            is_valid = false;
        }
        
        // validate email address
        if(email_regex.test(email) == false){
            document.getElementById("email_message").style.display = "block";
            is_valid = false;
        }
        
        // if the password length is less than 8 characters 
        if(password.length < 8){
            document.getElementById("password_message").style.display = "block";
            is_valid = false;
        }
    }else {
        document.getElementById("fullname_empty_message").style.display = "block";
        document.getElementById("user_name_empty_message").style.display = "block";
        document.getElementById("email_empty_message").style.display = "block";
        document.getElementById("password_empty_message").style.display = "block";
        is_valid = false;
    }
    
    if(is_valid === true){
        document.getElementById("register_form").submit();
    }
}
