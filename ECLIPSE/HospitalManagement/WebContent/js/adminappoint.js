/**
 * 
 */

function saveappointment(){
	var patient = document.getElementById("inputgrouppatients");
	var doctor = document.getElementById("inputgroupdoctors");
	var details = document.getElementById("detailsappointment");
	var date = document.getElementById("dateappointment");
	var time = document.getElementById("timeappointment");
	
	// check if the patient and doctor are undefined 
	if(patient === null || doctor === null){
		var message = "The patient and doctor must be selected";
        $('#alert_placeholder_appointment').html('<div class="alert alert-danger"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
	}else{
		// check if all the fields are empty
		if(patient.value === "" || doctor.value === "" || details.value === "" || date.value === "" || time.value === ""){
			var message = "All the form data is required";
	        $('#alert_placeholder_appointment').html('<div class="alert alert-danger"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
		}else{
			// send the data
			var headers = new Headers();
	        headers.append("Content-Type", "application/x-www-form-urlencoded");
	        
	        var urlencoded = new URLSearchParams();
	        urlencoded.append("patientid", patient.value);
	        urlencoded.append("doctorId", doctor.value);
	        urlencoded.append("detailappointment", details.value);
	        urlencoded.append("date", date.value);
	        urlencoded.append("time", time.value);
	        
	        fetch('AdminAppointment', {
	            method: 'post',
	            headers: headers,
	            body: urlencoded,
	            redirect: 'follow'
	        }).then(response => response.json())
	        .then(result => {
	        	if(result === "appointed_success"){
	        		var message = "The Appointment is Assignned Successfully";
	    	        $('#alert_placeholder_appointment').html('<div class="alert alert-success"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
	    	        window.location.replace("AdminAppointment");
	        	}
	        });
		}
	}
}