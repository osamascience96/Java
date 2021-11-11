<%@page import="com.pojo.Employee"%>
<%@page import="java.util.ArrayList"%>
<!-- Edit Team Modal -->
<div class="modal fade" id="edit_team_modal" tabindex="-1" role="dialog" aria-labelledby="edit_team_modal" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
          <h5 class="modal-title">Team ID: <span id="edit_team_modal_title"></span></h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="reset_edit_modal();">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div id="edit_team_error_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> Fill in All the Fields to insert team!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
          </div>
          <form id="edit_team_modal_form" action="team_servlet" method="POST">
              <input id="team_member_id" type="hidden" name="team_member_id">
              <!-- Team Name -->
              <div class="form-group">
                  <label for="team_name">Team Name</label>
                  <input id="edit_team_name" class="form-control" type="text" name="team_name" placeholder="Team Name">
              </div>
              <!--On Call Options-->
              <label style="font-weight: bold;">On Call Options</label>
              <div class="row">
                    <div class="col input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <input id="on_call_active" type="radio" aria-label="Radio Button for On Call" name="on_call" value="1">
                            </div>
                        </div>
                        <input type="text" class="form-control" aria-label="on-call-text" value="On Call" readonly>
                    </div>
                    <div class="col input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <input id="on_call_deactive" type="radio" aria-label="Radio Button for Off Call" name="on_call" value="0">
                            </div>
                        </div>
                        <input type="text" class="form-control" aria-label="off-call-text" value="Off Call" readonly>
                    </div>
              </div>
              <br>
              <!-- List pre added options-->
              <h5>Team Members</h5>
              <ul id="team_members_edit_modal" class="list-group list-group-flush">
              </ul>
              <!-- select team member -->
                <%
                  ArrayList<Employee> freeEmployeesList = null;
                  if(session.getAttribute("freeEmployeeList") != null){
                %>
                <%
                    freeEmployeesList = (ArrayList<Employee>) session.getAttribute("freeEmployeeList");
                %>
                <div id="team_members_edit_select_options" class="row" style="margin:5px;">
                    <h5><label for="employees_array">Select Employee:</label></h5>
                    <div class="w-100"></div>
                    <select class="col custom-select" name="employees_array" multiple>
                        <% for(int i=0; i < freeEmployeesList.size(); i++){%>
                            <%
                                int id = freeEmployeesList.get(i).GetID();
                                String name = freeEmployeesList.get(i).GetFirstName().concat(" ").concat(freeEmployeesList.get(i).GetLastName());
                            %>
                            <option value="<%=id%>"><%=name%></option>
                        <%}%>
                    </select>
                    <%}%>
                </div>
              <input id="free_emps" type="hidden" value="<%=freeEmployeesList != null ? freeEmployeesList.size() : 0%>">
              <input id="final_team_scale" type="hidden" name="final_team_scale">
              <input type="hidden" name="post_action" value="edit">
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="reset_edit_modal();">Close</button>
        <button type="button" class="btn btn-primary" onclick="edit_team_member_form()">Edit Team</button>
      </div>
    </div>
  </div>
</div>