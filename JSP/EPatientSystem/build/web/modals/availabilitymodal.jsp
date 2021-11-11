<!-- Modal -->
<div class="modal fade" id="available_modal" tabindex="-1" aria-labelledby="availablity_modal_header" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="availablity_modal_header">Set Available Status</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="alert_available_modal_alert"></div>
              <div class="mb-3">
                  <label for="available_date" class="form-label">Select your Date of Availability</label>
                  <input type="date" class="form-control" id="available_date">
                  <div id="available_date_help" class="form-text">Add your date of availability.</div>
              </div>
              <div class="row">
                  <div class="col">
                    <div class="mb-3">
                        <label for="start_time" class="form-label">Start Time</label>
                        <input type="time" class="form-control" id="start_time">
                        <div id="available_date_help" class="form-text">Select the start of your time of the day.</div>
                    </div>
                    <div class="mb-3">
                        <label for="start_time" class="form-label">End Time</label>
                        <input type="time" class="form-control" id="end_time">
                        <div id="available_date_help" class="form-text">Select the end of your time of the day.</div>
                    </div>
                  </div>
              </div>
              <div class="mb-3">
                  <label class="form-label" for="select_available_hours">How many Appointments, will you take this day?</label>
                  <select id="select_available_hours" class="form-select">
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                    <option value="4">Four</option>
                    <option value="5">Five</option>
                    <option value="6">Six</option>
                    <option value="7">Seven</option>
                    <option value="8">Eight</option>
                    <option value="9">Nine</option>
                    <option value="10">Ten</option>
                    <option value="11">Eleven</option>
                    <option value="12">Twelve</option>
                    <option value="13">Thirteen</option>
                    <option value="14">Fourteen</option>
                    <option value="15">Fifteen</option>
                  </select>
              </div>
              <div class="d-grid gap-2">  
                  <button id="submit_avail" type="button" onclick="submitplan()" class="btn btn-success">Add Availability</button>
              </div>
            </div>
      </div>
      <div class="modal-footer">
        <div class="d-grid gap-2">  
            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>
<script>
    function submitplan(){
        var date = document.getElementById("available_date").value;
        var fromtime = document.getElementById("start_time").value;
        var totime = document.getElementById("end_time").value;
        var select_available_hours = document.getElementById("select_available_hours").value;
        
        if(date === "" || fromtime === "" || totime === "" || select_available_hours === ""){
            var message = "All Input is Required";
            $("#alert_available_modal_alert").html('<div class="alert alert-danger alert-dismissible fade show" role="alert">'+message+'<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>');
        }else{    
            // compare the time 
            if(Date.parse(date + " " + fromtime) > Date.parse(date + " " + totime)){
                var message = "The start time must be before the end time.";
                $("#alert_available_modal_alert").html('<div class="alert alert-warning alert-dismissible fade show" role="alert">'+message+'<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>');
            }else{
                var headers = new Headers();
                headers.append("Content-Type", "application/x-www-form-urlencoded");

                var urlencoded = new URLSearchParams();
                urlencoded.append("available_date", date);
                urlencoded.append("fromtime", fromtime);
                urlencoded.append("totime", totime);
                urlencoded.append("timecount", select_available_hours);

                fetch("plan_servlet", {
                    method:'post',
                    headers: headers,
                    body: urlencoded, 
                    redirect:'follow',
                }).then(response => response.json())
                .then(data => {
                    var message = "";
                    if(data === "plan_exists"){
                        message = "Plan Already Exists";
                        $("#alert_available_modal_alert").html('<div class="alert alert-danger alert-dismissible fade show" role="alert">'+message+'<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>');
                    }else if(data === "plan_inserted_failed"){
                        message = "Plan Insertion Failed";
                        $("#alert_available_modal_alert").html('<div class="alert alert-danger alert-dismissible fade show" role="alert">'+message+'<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>');
                    }else if(data === "plan_inserted"){
                        message = "Plan Inserted Successfully";
                        $("#alert_available_modal_alert").html('<div class="alert alert-success alert-dismissible fade show" role="alert">'+message+'<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>');
                    }
                });
            }
        }
    }
</script>