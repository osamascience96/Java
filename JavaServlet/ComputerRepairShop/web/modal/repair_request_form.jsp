<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<div id="repair_request_modal" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Add Repair Request</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="alert_message" class="alert alert-danger alert-dismissible fade" role="alert">
                <strong><span id="alert_title"></span>!</strong> <span id="alert_message"></span>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <form id="repair_request_form" action="RequestRepair" method="POST" >
                  <div class="form-group">
                      <label for="computer_owner">Enter Computer Owner</label>
                      <input id="computer_owner" class="form-control" type="text" name="computer_owner" placeholder="Computer Owner" required/>
                  </div>
                  <div class="form-group">
                      <label for="serial_number">Enter Serial Number</label>
                      <input id="serial_number" class="form-control" type="text" name="serial_number" placeholder="Serial Number" required/>
                  </div>
                  <div class="input-group mb-3">
                      <div class="input-group-prepend">
                        <label class="input-group-text" for="type_options">Types</label>
                      </div>
                      <select class="custom-select" id="type_options" name="type_options">
                        <option value="desktop">Desktop</option>
                        <option value="laptop">Laptop</option>
                        <option value="tablet">Tablet</option>
                      </select>
                  </div>
                  <div class="form-group">
                      <label for="computer_model">Enter Computer Model</label>
                      <input id="computer_model" class="form-control" type="text" name="computer_model" placeholder="Computer Model" required/>
                  </div>
                  <div class="form-group">
                      <label for="memory_db">Enter Computer Memory</label>
                      <input id="memory_db" class="form-control" type="number" name="memory_db" placeholder="Memory in GB" required/>
                  </div>
                  <div class="form-group">
                      <label for="harddisk_gb">Enter Hard Space:</label>
                      <input id="harddisk_gb" class="form-control" type="number" name="harddisk_gb" placeholder="Hard in GB" required/>
                  </div>
                  <div class="form-group">
                      <label for="problem_box">Enter the Problems Regarding your Device:</label>
                      <textarea id="problem_box" class="form-control" type="text" name="problem_box" placeholder="Enter the Problems" rows="20" cols="20" required></textarea>
                  </div>
                  <%
                      // init the current date and time 
                      DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                      Date dateObj = new Date();
                      String[] datetime = dateFormat.format(dateObj).split(" ");
                  %>
                  <input type="hidden" name="datetime" value="<%=dateFormat.format(dateObj)%>"/>
                  <div class="row">
                    <div class="col form-group">
                        <label for="current_date">Current Date:</label>
                        <input id="current_date" class="form-control" type="date" name="current_date" value="<%=datetime[0]%>" required>
                    </div>
                    <div class="col form-group">
                        <label for="current_time">Current Time:</label>
                        <input id="current_time" class="form-control" type="time" name="current_time" value="<%=datetime[1]%>" required>
                    </div>
                  </div>
              </form>
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-primary" onclick="repair_request_handler(document.getElementById('repair_request_form'))">Submit</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>