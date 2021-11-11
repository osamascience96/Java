/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function register(){
    var member_name = document.getElementById("name").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var confirmpassword = document.getElementById("confirm_password").value;
    
    var message = "</br></br>\n\
                    <ul style='color: red; font-weight: bold;'>";
    
    if(member_name === ""){
        message = message + "<li>Please enter your name.</li>";
    }
    
    if(username === ""){
        message = message + "<li>Please enter your username.</li>";
    }
    
    if(password === ""){
        message = message + "<li>Please enter your password.</li>";
    }
    
    if(confirmpassword === ""){
        message = message + "<li>Please confirm your password.</li>";
    }
    
    if(member_name === "" || username === "" || password === "" || confirmpassword === ""){
        message = message + "</ul>";
        $("#error_div").html(message);
    }else if(password !== confirmpassword){
        message = message + "<li>Your confirm password do not match your password.</li>";
        message = message + "</ul>";
        $("#error_div").html(message);
    }else{
        document.getElementById("register_form").submit();
    }
}