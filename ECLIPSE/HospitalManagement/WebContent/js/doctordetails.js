function setappointment(){
	var patient = document.getElementById("inputgrouppatients");
	var doctor = document.getElementById("inputgroupdoctors");
	var details = document.getElementById("detailsappointment");
	var date = document.getElementById("dateappointment");
	var time = document.getElementById("timeappointment");
	
	// check if the patient and doctor are undefined 
	if(patient === null || doctor === null){
        $('#message_container').html("The patient and doctor must be selected");
        $("#message_modal").modal("show");
	}else{
		// check if all the fields are empty
		if(patient.value === "" || doctor.value === "" || details.value === "" || date.value === "" || time.value === ""){
	        $('#message_container').html("All the form data is required");
	        $("#message_modal").modal("show");
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
	    	        $('#message_container').html("The Appointment is Assignned Successfully");
	    	        $("#message_modal").modal("show");
	        	}
	        });
		}
	}
}