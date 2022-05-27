<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="bean.Doctor"%>
<%@page import="bean.Patient"%>
<%@page import="java.util.ArrayList"%>
<div id="appointmentmodal" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Add Appointment</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="container">
        	<div id="alert_placeholder_appointment"></div>
        	<form id="admin_appointment" action="AdminAppointment" method="post">
	        	<% ArrayList<Patient> patientArrayList = (ArrayList<Patient>)session.getAttribute("patientlists"); %>
	        	<% if(patientArrayList != null){ %>
	        		<% if(patientArrayList.size() > 0){ %>
			        	<div class="input-group mb-3">
						  <div class="input-group-prepend">
						    <label class="input-group-text" for="inputgrouppatients">Patients</label>
						  </div>
						  <select class="custom-select" id="inputgrouppatients" name="patientid" required>
						  	<% for(int i=0; i < patientArrayList.size(); i++){ %>
						    	<option value="<%=patientArrayList.get(i).getId()%>"><%=patientArrayList.get(i).getName() %></option>
						    <% } %>
						  </select>
						</div>
					<% }else{ %>
						<h5 class="text-info text-center">No Patients in System</h5>
					<% } %>
				<% } %>
				<% ArrayList<Doctor> doctorArrayList = (ArrayList<Doctor>) session.getAttribute("doctorlists"); %>
				<% if(doctorArrayList != null){ %>
					<% int count = 0; %>
					<% if(doctorArrayList.size() > 0){ %>
						<div class="input-group mb-3">
						  <div class="input-group-prepend">
						    <label class="input-group-text" for="inputgroupdoctors">Doctors</label>
						  </div>
						  <select class="custom-select" id="inputgroupdoctors" name="doctorId" required>
						  	<% for(int i=0; i < doctorArrayList.size(); i++){ %>
						  		<% if(doctorArrayList.get(i).getApproved() == 1 && doctorArrayList.get(i).getAvailability() == 1){ %>
						  			<% count += 1; %>
						    		<option value="<%=doctorArrayList.get(i).getId()%>"><%=doctorArrayList.get(i).getName() %></option>
						    	<% } %>
						    <% } %>
						  </select>
						</div>
					<% }else{ %>
						<h5 class="text-primary text-center">No Doctors in System</h5>
					<% } %>
					<% if(count == 0){ %>
				    	<h5 class="text-danger text-center">No Doctor Available or either not approved.</h5>
				    <% } %>
				<% }%>
				<div class="form-group">
					<label for="detailsappointment">Enter the Details</label>
					<textarea rows="10" cols="10" class="form-control" id="detailsappointment" name="detailappointment" placeholder="Enter Details of the Appointment" required></textarea>
				</div>
				<%
					DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					LocalDateTime localDateTime = LocalDateTime.now();
					String datetime[] = dateTimeFormatter.format(localDateTime).split(" ");
				%>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="dateappointment">Enter Date</label>
							<input type="date" id="dateappointment" name="date" class="form-control" value="<%=datetime[0]%>">
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="timeappointment">Enter Time</label>
							<input type="time" id="timeappointment" name="time" class="form-control" value="<%=datetime[1]%>">
						</div>
					</div>
				</div>
			</form>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-outline-success btn-block" onclick="saveappointment()">Save Appointment</button>
      </div>
    </div>
  </div>
</div>