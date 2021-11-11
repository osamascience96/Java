<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!-- Modal -->
<div class="modal fade" id="insert_task_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalCenterTitle">Insert Task</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="insert_task_modal_alert" class="alert alert-danger" role="alert" style="display: none;">
                  <strong>Fill in All the fields to Add the task!</strong>
                  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
              </div>
            <form id="insert_task_form" action="task_servlet" method="POST">
                <div class="form-group">
                    <label for="task_name">Enter Task Name:</label>
                    <input id="insert_task_name" type="text" name="taskname" class="form-control" placeholder="Task Name">
                </div>
                <div class="form-group">
                    <label for="task_description">Enter Task Description</label>
                    <textarea id="insert_task_description" name="taskdescription" class="form-control" rows="10" cols="10" placeholder="Task Description"></textarea>
                </div>
                <div class="form-group">
                    <label for="task_duration">Enter Task Duration:</label>
                    <div class="row">
                        <div class="col">
                            <button type="button" class="btn btn-outline-primary btn-block" onclick="insert_task_increament()">+</button>
                        </div>
                        <div class="col">
                            <input id="insert_task_duration" type="number" name="duration" class="form-control btn-block text-center" placeholder="Minutes" value="30" readonly>
                        </div>
                        <div class="col">
                            <button type="button" class="btn btn-outline-danger btn-block" onclick="insert_task_decrement()">-</button>
                        </div>
                    </div>
                </div>
                <%
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String datetime[] = dtf.format(now).split(" ");
                %>
                <div class="form-group">
                    <label for="task_duration">Created Date Time:</label>
                    <div class="row">
                        <div class="col">
                            <input type="hidden" name="date" value="<%=datetime[0]%>">
                            <input id="task_duration" type="date" name="date" class="form-control" placeholder="Date" value="<%=datetime[0]%>">
                        </div>
                        <div class="col">
                            <input type="hidden" name="time" value="<%=datetime[1]%>">
                            <input id="task_duration" type="time" name="time" class="form-control" placeholder="Time" value="<%=datetime[1]%>">
                        </div>
                    </div>
                </div>
                <input type="hidden" name="request_type" value="insert">
            </form>
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="insert_task_modal_submit();">Add Task</button>
      </div>
    </div>
  </div>
</div>