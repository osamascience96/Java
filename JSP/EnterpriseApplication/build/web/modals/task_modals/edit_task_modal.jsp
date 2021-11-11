<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!-- Modal -->
<div class="modal fade" id="edit_task_modal" tabindex="-1" role="dialog" aria-labelledby="edit_task_modal_title" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
          <h5 class="modal-title">Task No. <span id="edit_task_modal_title"></span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
            <div id="edit_task_modal_alert" class="alert alert-danger" role="alert" style="display: none;">
                  <strong>Fill in All the fields to Add the task!</strong>
                  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
              </div>
            <form id="edit_task_form" action="task_servlet" method="POST">
                <input id="edit_task_id" type="hidden" name="task_id">
                <div class="form-group">
                    <label for="task_name">Enter Task Name:</label>
                    <input id="edit_task_name" type="text" name="taskname" class="form-control" placeholder="Task Name">
                </div>
                <div class="form-group">
                    <label for="edit_task_description">Enter Task Description</label>
                    <textarea id="edit_task_description" name="taskdescription" class="form-control" rows="10" cols="10" placeholder="Task Description"></textarea>
                </div>
                <div class="form-group">
                    <label for="edit_task_duration">Enter Task Duration:</label>
                    <div class="row">
                        <div class="col">
                            <button type="button" class="btn btn-outline-primary btn-block" onclick="edit_task_increment()">+</button>
                        </div>
                        <div class="col">
                            <input id="edit_task_duration" type="number" name="duration" class="form-control btn-block text-center" placeholder="Minutes" readonly>
                        </div>
                        <div class="col">
                            <button type="button" class="btn btn-outline-danger btn-block" onclick="edit_task_decrement()">-</button>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label>Created Date Time:</label>
                    <div class="row">
                        <div class="col">
                            <input id="created_at_date" type="date" class="form-control" name="created_at_date" placeholder="Created Date">
                        </div>
                        <div class="col">
                            <input id="created_at_time" type="time" class="form-control" name="created_at_time" placeholder="Created Time">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label>Updated Date Time:</label>
                    <div class="row">
                        <div class="col">
                            <input id="updated_at_date" type="date" class="form-control" name="updated_at_date" placeholder="Updated Date">
                        </div>
                        <div class="col">
                            <input id="updated_at_time" type="time" class="form-control" name="updated_at_time" placeholder="Updated Time">
                        </div>
                    </div>
                </div>
                <input type="hidden" name="request_type" value="update">
            </form>
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="edit_task_modal_submit();">Update Task</button>
      </div>
    </div>
  </div>
</div>