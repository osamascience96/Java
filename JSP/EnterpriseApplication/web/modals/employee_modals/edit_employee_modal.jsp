<%@page import="com.pojo.Task"%>
<%@page import="java.util.ArrayList"%>
<!-- Modal -->
<div class="modal fade" id="edit_employee_modal" tabindex="-1" role="dialog" aria-labelledby="edit_employee_modal" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="title">Edit Modal</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div id="edit_modal_alert_error" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
            <strong>Error!</strong> <span id="edit_modal_alert_error_message"></span>.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <form id="edit_employee_form" action="employee_servlet" method="POST">
          <div class="form-group">
              <input id="edit_first_name" class="form-control" type="text" name="first_name" placeholder="First Name" required>
          </div>
          <div class="form-group">
              <input id="edit_last_name" class="form-control" type="text" name="last_name" placeholder="Last Name" required>
          </div>
          <div class="form-group">
              <label for="edit_sin">Social Insurance Number</label>
              <input id="edit_sin" class="form-control" type="text" pattern="[0-9]{3}-[0-9]{3}-[0-9]{3}" placeholder="xxx-xxx-xxx" readonly>
          </div>
          <div class="input-group mb-3">
            <div class="input-group-prepend">
                  <span class="input-group-text" id="basic_dollar_symbol">$</span>
            </div>
            <input id="edit_hourly_rate" class="form-control" type="number" name="hourly_rate" placeholder="Hourly Rate" aria-describedby="basic_dollar_symbol" required>
          </div>
            <%
                ArrayList<Task> arrayListTasks_edit = (ArrayList<Task>) session.getAttribute("tasksList");
                if(arrayListTasks_edit != null){
            %>
                <% if(arrayListTasks_edit.size() != 0){%>
                    <div class="form-group">
                        <label for="employee_task_select">Select Tasks</label>
                            <select id="employee_task_select" class="form-control custom-select" name="edit_task_select_multiple" multiple>
                            <% for(int i=0; i < arrayListTasks_edit.size(); i++){%>
                                <option value="<%=arrayListTasks_edit.get(i).GetId()%>"><%=arrayListTasks_edit.get(i).GetName()%></option>
                            <% }%>
                        </select>
                    </div>
                <% }else{%>
                    <div class="alert alert-info text-center" role="alert">
                        <h6>No Tasks Added yet.</h6>
                    </div>
                    <a href="task_servlet" type="button" class="btn btn-primary btn-block">Add Tasks</a>
                <% }%>
            <% }%>
          <input type="hidden" name="post_action" value="edit">
          <input id="employee_id" type="hidden" name="employee_id">
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="edit_insert_employee_form()">Edit Employee</button>
      </div>
    </div>
  </div>
</div>