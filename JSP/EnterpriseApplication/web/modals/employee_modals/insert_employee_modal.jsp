<%@page import="com.pojo.Task"%>
<%@page import="java.util.ArrayList"%>
<!-- Modal -->
<div class="modal fade" id="insert_employee_modal" tabindex="-1" role="dialog" aria-labelledby="insert_employee_modal" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="title">Insert Employee</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div id="insert_modal_alert_error" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
            <strong>Error!</strong> <span id="insert_modal_alert_error_message"></span>.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <form id="insert_employee_form" action="employee_servlet" method="POST">
            <div class="form-group">
                <input id="insert_first_name" class="form-control" type="text" name="first_name" placeholder="First Name" required>
            </div>
            <div class="form-group">
                <input id="insert_last_name" class="form-control" type="text" name="last_name" placeholder="Last Name" required>
            </div>
            <div class="form-group">
                <label for="sin">Social Insurance Number</label>
                <div class="row">
                    <div class="col">
                        <input id="sin1" class="form-control text-center" type="text" oninput="ondetect_1()" maxlength="3" name="sin_box_1" placeholder="xxx" required>
                    </div>
                    <div class="col">
                        <input id="sin2" class="form-control text-center" type="text" oninput="ondetect_2()" maxlength="3" name="sin_box_2" placeholder="xxx" required>
                    </div>
                    <div class="col">
                        <input id="sin3" class="form-control text-center" type="text" oninput="ondetect_3()" maxlength="3" name="sin_box_3"  placeholder="xxx" required>
                    </div>
                </div>
            </div>
            <script>
                function ondetect_1(){
                    var sin_input = document.getElementById("sin1");
                    if(!Number.isInteger(+sin_input.value)){
                        $("#sin1").val("");
                    }
                }
                function ondetect_2(){
                    var sin_input = document.getElementById("sin2");
                    if(!Number.isInteger(+sin_input.value)){
                        $("#sin2").val("");
                    }
                }
                function ondetect_3(){
                    var sin_input = document.getElementById("sin3");
                    if(!Number.isInteger(+sin_input.value)){
                        $("#sin3").val("");
                    }
                }
            </script>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic_dollar_symbol">$</span>
                </div>
                <input id="insert_hourly_rate" class="form-control" type="number" name="hourly_rate" placeholder="Hourly Rate" aria-describedby="basic_dollar_symbol" required>
            </div>
            <%
                ArrayList<Task> arrayListTasks = (ArrayList<Task>) session.getAttribute("tasksList");
                if(arrayListTasks != null){
            %>
                <% if(arrayListTasks.size() != 0){%>
                    <div class="form-group">
                        <label for="employee_task_select">Select Tasks</label>
                            <select id="employee_task_select" class="form-control custom-select" name="task_select_multiple" multiple>
                            <% for(int i=0; i < arrayListTasks.size(); i++){%>
                                <option value="<%=arrayListTasks.get(i).GetId()%>"><%=arrayListTasks.get(i).GetName()%></option>
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
            <input type="hidden" name="post_action" value="insert">
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="submit_insert_employee_form();">Add Employee</button>
      </div>
    </div>
  </div>
</div>