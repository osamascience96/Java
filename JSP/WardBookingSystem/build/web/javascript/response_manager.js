/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var response = window.location.search.substr(1).split('=')[1];
var error_title = document.getElementById('title');
var error_message = document.getElementById('message');

if(!(typeof response === 'undefined')){
    // if password error
    if(response === 'password_error'){
        error_title.innerHTML = "Password Error";
        error_message.innerHTML = "Password must be greater than 8 characters.";
    }else if(response === 'name_error_4'){
        error_title.innerHTML = "Name Error";
        error_message.innerHTML = "Name must be greater than 4 characters.";
    }else if(response === 'email-error'){
        error_title.innerHTML = "Email Error";
        error_message.innerHTML = "Email must be in Correct Format.";
    }else if(response === 'user-exists'){
        error_title.innerHTML = "User Exists";
        error_message.innerHTML = "User Already Exists in database.";
    }else if(response === 'user-not-exists'){
        error_title.innerHTML = "User not Exists";
        error_message.innerHTML = "User does not exists in our databsase.";
    }else if(response === 'wrong-login'){
        error_title.innerHTML = "Login Failed";
        error_message.innerHTML = "Your username or Password is Incorrect.";
    }else if(response === 'account-created'){
        error_title.innerHTML = "Account Created";
        error_message.innerHTML = "Your Account is created. Login to our System.";
    }else if(response === 'account-not-created'){
        error_title.innerHTML = "Account not Created";
        error_message.innerHTML = "Your Account could not be created due to some problem.";
    }
    
    
    
    // show the modal
    $('#error_message').modal('show');
}
