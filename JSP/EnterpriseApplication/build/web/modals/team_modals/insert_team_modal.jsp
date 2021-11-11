<%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("login") != null){
%>
    <%@page import="com.pojo.Employee"%>
    <%@page import="java.util.ArrayList"%>
    <!-- Modal -->
    <div class="modal fade" id="insert_team_modal" tabindex="-1" role="dialog" aria-labelledby="insert_team_modal" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="title">Insert Team</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div id="insert_team_error_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> Fill in All the Fields to insert team!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div id="insert_team_select_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> Select the employees!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div id="insert_team_select_available_alert" class="alert alert-warning alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> No Employee Available to continue!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="insert_team_form" action="team_servlet" method="POST">
                <div class="form-group">
                    <input id="insert_team_name_input" class="form-control" type="text" name="team_name" placeholder="Team Name" required>
                </div>
                <label style="font-weight: bold;">On Call Options</label>
                <div class="row">
                    <div class="col input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <input id="insert_input_on_call" type="radio" aria-label="Radio Button for On Call" name="on_call" value="1">
                            </div>
                        </div>
                        <input type="text" class="form-control" aria-label="on-call-text" value="On Call" readonly>
                    </div>
                    <div class="col input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <input id="insert_input_off_call" type="radio" aria-label="Radio Button for Off Call" name="on_call" value="0">
                            </div>
                        </div>
                        <input type="text" class="form-control" aria-label="off-call-text" value="Off Call" readonly>
                    </div>
                </div>
                <br>
                <div id="employee_set" class="container">
                    <%
                        if(session.getAttribute("freeEmployeeList") != null){
                    %>
                        <%
                            ArrayList<Employee> freeEmployeesList = (ArrayList<Employee>) session.getAttribute("freeEmployeeList");
                            if(freeEmployeesList.size() != 0){
                        %>
                            <label class="col" for="employees_array">Select any 2 Employees for team</label>
                            <div class="w-100"></div>
                            <select id="employee_array" name="employees_array" class="col custom-select" multiple>
                                <% for(int i=0; i < freeEmployeesList.size(); i++){%>
                                    <%
                                        int id = freeEmployeesList.get(i).GetID();
                                        String name = freeEmployeesList.get(i).GetFirstName().concat(" ").concat(freeEmployeesList.get(i).GetLastName());
                                    %>
                                    <option value="<%=id%>"><%=name%></option>
                                <% }%>
                            </select>
                        <% }else{%>
                            <div class="alert alert-info text-center" role="alert">
                                <Strong>All Employees Occupied!</strong>
                            </div>
                        <% }%>
                    <% }%>
                </div>
                <input type="hidden" name="post_action" value="insert">
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" onclick="insert_team_member_form();">Add Team</button>
          </div>
        </div>
      </div>
    </div>
<% }%>