/**
 * 
 */

function login(){
	var username_email = document.getElementById("username_email").value;
	var password = document.getElementById("login_password").value;
	
	if(username_email === "" || password === ""){
		var message = "All Fields are required";
        $('#alert_placeholder').html('<div class="alert alert-danger"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
	}else{
		var headers = new Headers();
        headers.append("Content-Type", "application/x-www-form-urlencoded");
        
        var urlencoded = new URLSearchParams();
        urlencoded.append("username_email", username_email);
        urlencoded.append("password", password);
        
        fetch('Login', {
            method: 'post',
            headers: headers,
            body: urlencoded,
            redirect: 'follow'
        }).then(response => response.json())
        .then(result => {
            var message = "";
            var alert_type = "";
            
            if(result === "invalid_credentials"){
            	alert_type = "danger";
            	message = "Invalid Credentials entered";
            }else if(result === "patient_login_success"){
            	alert_type = "success";
            	message = "Patient Login Successfull"
            	// redirect
        		window.location.replace("DoctorCotroller");
            }else if(result === "doctor_login_success_approved"){
            	alert_type = "info";
            	message = "Doctor Login Successfull";
            	// redirect
            	window.location.replace("AppointmentDoctor");
            }else if(result === "doctor_login_success_not_approved"){
            	alert_type = "warning";
            	message = "Doctor not approved yet";
            }else if(result === "admin_login_success"){
            	alert_type = "primary";
            	message = "Welcome Admin!";
            	//redirect to admin
            	window.location.replace("admin.jsp");
            }
            
            $('#alert_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        });
	}
}