function login_credentials(){
    var username_email_credentials = document.getElementById("credential_username_email").value;
    var password = document.getElementById("login_password").value;
    
    if(username_email_credentials === "" || password === ""){
        var message = "All Fields are required";
        $('#alert_placeholder_login_modal').html('<div class="alert alert-danger"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
    	var headers = new Headers();
        headers.append("Content-Type", "application/x-www-form-urlencoded");
        
        var urlencoded = new URLSearchParams();
        urlencoded.append("username_email", username_email_credentials);
        urlencoded.append("login_password", password);
        
        fetch('Login', {
            method: 'post',
            headers: headers,
            body: urlencoded,
            redirect: 'follow'
        }).then(response => response.json())
                .then(result => {
                    var message = "";
                    var alert_type = "";
                    
                    if(result === "login_success"){
                    	alert_type = "success";
                    	message = "Login Successfully";
                    	window.location.replace("Book");
                    }else if(result === "failed_success"){
                    	alert_type = "danger";
                    	message = "Username or Password Incorrect";
                    }
                    
                    $('#alert_placeholder_login_modal').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
                });
    }
}