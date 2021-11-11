/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function login(){
    let dbID = document.getElementById("dbid").value;
    let dbPass = document.getElementById("dbpassword").value;
    
    if(dbID === "" || dbPass === ""){
        alert_type = "danger";
        message = "All fields are required";
        $('#alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        var headers = new Headers();
        headers.append("Content-Type", "application/x-www-form-urlencoded");
        
        var urlencoded = new URLSearchParams();
        urlencoded.append("ID", dbID);
        urlencoded.append("password", dbPass);
        
        fetch('login_controller', {
                method: 'post',
                headers: headers,
                body: urlencoded,
                redirect: 'follow'
        }).then(response => response.json())
        .then(result => {
            if(result === "valid_credentials"){
                alert_type = "success";
                message = "Login Successful";
                $('#alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                // redirect to the main page
                window.location.replace("log_employee_controller");
            }else if(result === "invalid_credentials"){
                alert_type = "danger";
                message = "Invalid Credentials";
                $('#alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }
        });
    }
}