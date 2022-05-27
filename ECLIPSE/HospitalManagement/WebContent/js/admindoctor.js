/**
 * 
 */

function approve(doctorid){
	var headers = new Headers();
    headers.append("Content-Type", "application/x-www-form-urlencoded");
    
    var urlencoded = new URLSearchParams();
    urlencoded.append("actiontype", "active");
    urlencoded.append("docid", doctorid);
    
    fetch('AdminDoctor', {
        method: 'post',
        headers: headers,
        body: urlencoded,
        redirect: 'follow'
    }).then(response => response.json())
    .then(result => {
    	if(result === "doctor_activated"){
    		$("#message_container").html("Doctor Approved");
    		$("#message_modal").modal("show");
    		window.location.replace("AdminDoctor");
    	}
    });
}

function disapprove(doctorid){
	var headers = new Headers();
    headers.append("Content-Type", "application/x-www-form-urlencoded");
    
    var urlencoded = new URLSearchParams();
    urlencoded.append("actiontype", "deactive");
    urlencoded.append("docid", doctorid);
    
    fetch('AdminDoctor', {
        method: 'post',
        headers: headers,
        body: urlencoded,
        redirect: 'follow'
    }).then(response => response.json())
    .then(result => {
    	if(result === "doctor_deactivated"){
    		$("#message_container").html("Doctor Disapproved");
    		$("#message_modal").modal("show");
    		window.location.replace("AdminDoctor");
    	}
    });
}

function openqualification(data){
	if(data === ""){
		$("#qualification_data").html("No Data Available");
	}else{
		$("#qualification_data").html(data);
	}
	$("#qual_modal").modal("show");
}

function opencures(data){
	if(data === ""){
		$("#cures_container").html("No Data Available");
	}else{
		$("#cures_container").html(data);
	}
	$("#cures_modal").modal("show");
}


function opennid(data){
	$("#nid_container").html(data);
	$("#nid_modal").modal("show");
}

function openemail(data){
	$("#email_container").html(data);
	$("#email_modal").modal("show");
}