<%@page import="com.pojo.Team"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    
    
    <link rel="stylesheet" type="text/css" href="css/teams.css">
    <link rel="stylesheet" type="text/css" href="css/navigation.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    
    <title>Teams</title>
  </head>
  <body>
    <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("login") == null){
            response.sendRedirect("/EnterpriseApplication/");
        }
    %>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <%
            if(request.getParameter("response") != null){
        %>
            <%
                String operationalResponse = request.getParameter("response");
                String alertType = "";
                String alertTitle = "";
                String alertMessage = "";
                
                if(operationalResponse.compareTo("update_team_scale_update_success") == 0){
                    alertType = "success";
                    alertTitle = "Update Team Scale!";
                    alertMessage = "Your Team Scale Updated Successfully";
                }else if(operationalResponse.compareTo("team_already_exists") == 0){
                    alertType = "danger";
                    alertTitle = "Team Exists!";
                    alertMessage = "Team already exists in our System";
                }else if(operationalResponse.compareTo("team_inserted_successfully") == 0){
                    alertType = "success";
                    alertTitle = "Success!";
                    alertMessage = "Team added to the System Successfully";
                }else if(operationalResponse.compareTo("edited_success") == 0){
                    alertType = "success";
                    alertTitle = "Success!";
                    alertMessage = "Team updated Successfully";
                }else if(operationalResponse.compareTo("delete_success") == 0){
                    alertType = "success";
                    alertTitle = "Success!";
                    alertMessage = "Team deleted from the system Successfully";
                }else if(operationalResponse.compareTo("delete_not_possible") == 0){
                    alertType = "danger";
                    alertTitle = "Error!";
                    alertMessage = "On Call Team cannot be deleted";
                }
            %>
            <div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
                <strong><%=alertTitle%></strong> <%=alertMessage%>.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
        <div class="table-container container">
            <% if(session.getAttribute("teamlist") != null){%>
                <%
                    ArrayList<Team> teamsArrayList = (ArrayList<Team>) session.getAttribute("teamlist");
                    if(teamsArrayList.size() != 0){
                        ArrayList<Employee> OnTeamEmployeeList = (ArrayList<Employee>) session.getAttribute("onTeamEmployeeList");
                %>
                <!--table-->
                <div class="table table-bordered table-light table-responsive">
                        <table class="table table-hover">
                            <caption>List of Employees</caption>
                            <thead>
                                <th scope="col">ID</th>
                                <th scope="col">Team Name</th>
                                <th scope="col">On Call</th>
                                <th scope="col">Members Capacity</th>
                                <th scope="col">Date</th>
                                <th scope="col">Time</th>
                                <th scope="col">Actions</th>
                            </thead>
                            <tbody>
                                <% for(int i=0; i < teamsArrayList.size(); i++){%>
                                <script>
                                    var teamNameEmployeeList_<%=teamsArrayList.get(i).GetId()%> = [];
                                    <%
                                        // data to be added on O(n)^2
                                        for(int k=0; k < OnTeamEmployeeList.size(); k++){
                                    %>
                                        <%
                                            if(teamsArrayList.get(i).GetId() == OnTeamEmployeeList.get(k).GetTeamId()){
                                        %>
                                            teamNameEmployeeList_<%=teamsArrayList.get(i).GetId()%>.push('<%=OnTeamEmployeeList.get(k).GetFirstName()%> <%=OnTeamEmployeeList.get(k).GetLastName()%>');
                                        <%}%>
                                    <% }%>
                                </script>
                                <tr onclick="open_team_members_modal(teamNameEmployeeList_<%=teamsArrayList.get(i).GetId()%>)">
                                        <th scope="row"><%=teamsArrayList.get(i).GetId()%></th>
                                        <td><%=teamsArrayList.get(i).GetTeamName()%></td>
                                        <td><%=teamsArrayList.get(i).GetIsOnCall() == 1 ? "Yes" : "No"%></td>
                                        <td><button class="btn btn-block btn-outline-primary badge" onclick="open_team_member_scale_modal(<%=teamsArrayList.get(i).GetTeamMembers()%>, <%=teamsArrayList.get(i).GetId()%>)"><%=teamsArrayList.get(i).GetTeamMembers()%></button></td>
                                        <%
                                            String date_time_array[] = teamsArrayList.get(i).GetDateTime().split(" ", 2);
                                        %>
                                        <td><input class="w-100" type="date" value="<%=date_time_array[0]%>"></td>
                                        <td><input class="w-100" type="time" value="<%=date_time_array[1]%>"></td>
                                        <script>
                                            var team_object_<%=teamsArrayList.get(i).GetId()%> = {
                                                id : <%=teamsArrayList.get(i).GetId()%>,
                                                team_name: '<%=teamsArrayList.get(i).GetTeamName()%>',
                                                is_on_call: <%=teamsArrayList.get(i).GetIsOnCall()%>,
                                                team_members: <%=teamsArrayList.get(i).GetTeamMembers()%>,
                                                pre_employee_list: teamNameEmployeeList_<%=teamsArrayList.get(i).GetId()%>,
                                                date: '<%=date_time_array[0]%>',
                                                time: '<%=date_time_array[1]%>',
                                            };
                                        </script>
                                        <td class="text-center align-middle">
                                            <div class="btn-group align-top">
                                                <button class="btn btn-sm btn-outline-primary badge" type="button" onclick="open_edit_team_modal(team_object_<%=teamsArrayList.get(i).GetId()%>);">Edit</button>
                                                <button class="btn btn-sm btn-outline-danger badge" onclick="open_team_delete_modal('team_servlet?delete_team_id=<%=teamsArrayList.get(i).GetId()%>')"><i class="fa fa-trash"></i></button>
                                            </div>
                                        </td>
                                    </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                <% }else{%>
                    <div class="alert alert-info alert-dismissible fade show" role="alert">
                        <strong>Report!</strong> No Teams Added yet.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                <% }%>
            <% }%>
            <div class="row">
                <button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#insert_team_modal">Create a Team</button>
            </div>
        </div>
    </div>
    <%@include file="includes/footer.html" %>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <!-- include modals -->
    <%@include file="modals/team_modals/insert_team_modal.jsp" %>
    <%@include file="modals/team_modals/team_members_scale_modal.jsp" %>
    <%@include file="modals/team_modals/edit_team_member_modal.jsp" %>
    <%@include file="modals/team_modals/delete_confirm_modal.jsp" %>
    <%@include file="modals/team_modals/showteammembersmodal.jsp" %>
    
    <!-- scripts -->
    <script type="text/javascript" src="javascript/team.js"></script>
  </body>
</html>