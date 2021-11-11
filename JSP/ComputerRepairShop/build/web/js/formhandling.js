/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function repair_request_handler(form){
    var computer_owner = document.getElementById('computer_owner').value;
    var serial_number = document.getElementById('serial_number').value;
    var type = document.getElementById('type_options').value;
    var computer_model = document.getElementById('computer_model').value;
    var memory_gb = document.getElementById('memory_db').value;
    var harddisk_gb = document.getElementById('harddisk_gb').value;
    var problem_box = document.getElementById('problem_box').value;
    
    // check if all the values shows empty
    if(computer_owner === "" || serial_number === "" || type === "" || computer_model === "" || memory_gb === "" || harddisk_gb === "" || problem_box === ""){
        document.getElementById("alert_title").innerHTML = "Error Message";
        document.getElementById("alert_message").innerHTML = "KindlY fill out all the fields";
        $("#alert_message").addClass("show");
    }else{
        form.submit();
    }
}

function feedback_handler(form){
    var name = document.getElementById('name').value;
    var country = document.getElementById('country').value;
    var phone = document.getElementById('phone').value;
    var email = document.getElementById('email').value;
    var type = document.getElementById('type_options').value;
    var subject = document.getElementById('subject').value;
    var message = document.getElementById('messages').value;
    
    // check if all the values shows empty
    if(name === "" || country === "" || phone === "" || email === "" || type === "" || subject === "" || message === ""){
        document.getElementById("feedback_alert_title").innerHTML = "Error Message";
        document.getElementById("feedback_alert_message").innerHTML = "KindlY fill out all the fields";
        $("#feedback_alert_message").addClass("show");
    }else{
        form.submit();
    }
}

function login_handler(form){
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    
    if(username === "" || password === ""){
        // not login
    }else{
        form.submit();
    }
}