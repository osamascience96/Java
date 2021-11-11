<%@page import="com.pojo.Task"%>
<%@page import="com.pojo.Client"%>
<%@page import="com.pojo.Team"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!-- Modal -->
<div id="insert_job_modal" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add New Job</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <%
            ArrayList<Task> arrayListTasks = (ArrayList<Task>) session.getAttribute("task_list");
            ArrayList<Team> arrayListTeams = (ArrayList<Team>) session.getAttribute("team_list");
            ArrayList<Client> arrayListClients = (ArrayList<Client>) session.getAttribute("clients_list");
          %>
          <div class="container">
              <div id="insert_job_modal_alert" class="alert alert-danger" role="alert" style="display: none;">
                <strong>Fill in All the fields to Add the task!</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true" >&times;</span>
                </button>
              </div>
              <div id="insert_client_error_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> All the fields must be filled to insert the client.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div id="insert_client_datetime_error_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> Start date and time must be before the end date and time.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <form id="job_form" action="job_servlet" method="POST">
                  <%
                      if(arrayListClients != null){
                  %>
                    <%
                        if(arrayListClients.size() > 0){
                    %>
                        <label>Select only 1 Client*</label>
                        <select id="client_array" class="custom-select" name="client_array" multiple>
                            <% for(int i=0; i < arrayListClients.size(); i++){%>
                                <option value="<%=arrayListClients.get(i).GetId()%>"><%=arrayListClients.get(i).GetName()%></option>
                            <% }%>
                        </select>
                    <% }else{%>
                        <div class="alert alert-warning" role="alert">
                            <strong>Warning!</strong> Clients data not available!
                        </div>
                    <% }%>
                  <% }%>
                  
                  <%
                      if(arrayListTeams != null){
                  %>
                    <%
                        if(arrayListTeams.size() > 0){
                    %>
                        <label>Select only 1 Team*</label>
                        <select id="teams_array" class="custom-select" name="teams_array" multiple>
                            <% for(int i=0; i < arrayListTeams.size(); i++){%>
                                <option value="<%=arrayListTeams.get(i).GetId()%>"><%=arrayListTeams.get(i).GetTeamName()%></option>
                            <% }%>
                        </select>
                    <% }else{%>
                        <div class="alert alert-warning" role="alert">
                            <strong>Warning!</strong> Teams data not available!
                        </div>
                    <% }%>
                  <% }%>
                  
                  <%
                      if(arrayListTasks != null){
                  %>
                    <%
                        if(arrayListTasks.size() > 0){
                    %>
                        <label>Select Tasks*</label>
                        <select id="tasks_array" class="custom-select" name="tasks_array" multiple>
                            <% for(int i=0; i < arrayListTasks.size(); i++){%>
                                <option value="<%=arrayListTasks.get(i).GetId()%>"><%=arrayListTasks.get(i).GetName()%></option>
                            <% }%>
                        </select>
                    <% }else{%>
                        <div class="alert alert-warning" role="alert">
                            <strong>Warning!</strong> Teams data not available!
                        </div>
                    <% }%>
                  <% }%>
                  <div class="form-group">
                      <label for="description">Enter Description*</label>
                      <textarea id="description" class="form-control" rows="10" cols="10" name="description" placeholder="Description" required></textarea>
                  </div>
                  <div class="form-group">
                      <label for="comment">Enter Comment:</label>
                      <textarea id="comment" class="form-control" rows="10" cols="10" name="comment" placeholder="Comments" required></textarea>
                  </div>
                  <label>Start*</label>
                  <div class="row">
                      <div class="col">
                        <div class="form-group">
                            <input id="start_date" class="form-control" type="date" name="start_date" required>
                        </div>
                      </div>
                      <div class="col">
                        <div class="form-group">
                            <input id="start_time" class="form-control" type="time" name="start_time" required>
                        </div>
                      </div>
                  </div>
                  <label>End*</label>
                  <div class="row">
                      <div class="col">
                        <div class="form-group">
                            <input id="end_date" class="form-control" type="date" name="end_date" required>
                        </div>
                      </div>
                      <div class="col">
                        <div class="form-group">
                            <input id="end_time" class="form-control" type="time" name="end_time" required>
                        </div>
                      </div>
                  </div>
                  <input type="hidden" name="request_type" value="insert" >
              </form>
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-outline-primary" onclick="insert_job_form_modal(document.getElementById('job_form'))">Add Job</button>
      </div>
    </div>
  </div>
</div>