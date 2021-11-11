<%@page import="com.pojo.Employee"%>
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
    
    <link rel="stylesheet" type="text/css" href="css/employee.css">
    <link rel="stylesheet" type="text/css" href="css/navigation.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    
    <title>Employees</title>
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
        <% if(request.getParameter("response") != null){%>
            <%
                String operationResponse = request.getParameter("response");
                String alertType = "";
                String mainTitle = "";
                String alertMessage = "";
                
                if(operationResponse.compareTo("insert_success") == 0){
                    alertType = "success";
                    mainTitle = "Insert Successful!";
                    alertMessage = "Employee Data inserted Successfully.";
                }else if(operationResponse.compareTo("edit_success") == 0){
                    alertType = "primary";
                    mainTitle = "Edit Successful!";
                    alertMessage = "Employee Data edited Successfully.";
                }else if(operationResponse.compareTo("sin_exists") == 0){
                    alertType = "danger";
                    mainTitle = "S-I-N Exists!";
                    alertMessage = "Social Insurance Number Already Exists";
                }else if(operationResponse.compareTo("delete_success") == 0){
                    alertType = "success";
                    mainTitle = "Delete Successful!";
                    alertMessage = "Employee Deleted Successfully!";
                }else if(operationResponse.compareTo("team_employee_exists") == 0){
                    alertType = "danger";
                    mainTitle = "Deletion Failed!";
                    alertMessage = "Employee cannot be deleted, due to existance in a team!";
                }else if(operationResponse.compareTo("delete_employee_task_success") == 0){
                    alertType = "success";
                    mainTitle = "Success";
                    alertMessage = "Employee Task Deleted Successfully";
                }
            %>
            <div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
                <strong><%=mainTitle%>!</strong> <%=alertMessage%>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
        <div class="table-container container">
            <% if(session.getAttribute("employeelist") != null){%>
                <%
                    ArrayList<Employee> arrayListEmployee = (ArrayList<Employee>) session.getAttribute("employeelist");
                    if(arrayListEmployee.size() != 0){
                %>
                    <div class="table table-bordered table-light table-responsive table-hover">
                        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                            <h6 class="text-white">Search Employees</h6>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#search_employees_content" aria-controls="search_employees_content" aria-expanded="false" aria-label="Toggle navigation">
                              <span class="navbar-toggler-icon"></span>
                            </button>

                            <div class="collapse navbar-collapse" id="search_employees_content">
                              <ul class="navbar-nav mr-auto">
                              </ul>
                              <div class="form-inline my-2 my-lg-0">
                                  <input id="search_employee_input" onkeyup="search_employees()" class="form-control mr-sm-2" type="search" placeholder="Search by First Name" aria-label="Search">
                              </div>
                            </div>
                        </nav>
                        <table id="employee_table" class="table">
                            <caption>List of Employees</caption>
                            <thead>
                                <th scope="col">ID.</th>
                                <th scope="col">First Name</th>
                                <th scope="col">Last Name</th>
                                <th scope="col">Team Name</th>
                                <th scope="col">S-I-N</th>
                                <th scope="col">Hourly Pay Rate</th>
                                <th scope="col">Date</th>
                                <th scope="col">Time</th>
                                <th scope="col">Actions</th>
                            </thead>
                            <tbody>
                                <% for(int i=0; i < arrayListEmployee.size(); i++){%>
                                    <%
                                        ArrayList<Task> arrayListTask = arrayListEmployee.get(i).GetEmployeeTaskList();
                                    %>
                                    <%
                                        if(arrayListTask != null){
                                    %>
                                        <script>
                                            let taskObjArray_<%=arrayListEmployee.get(i).GetID()%> = [];
                                        </script>
                                        <% if(arrayListTask.size() > 0){%>
                                            <%
                                                for(int j=0; j < arrayListTask.size(); j++){
                                            %>
                                                <script>
                                                    taskObjArray_<%=arrayListEmployee.get(i).GetID()%>.push({
                                                        id: <%=arrayListTask.get(j).GetId()%>,
                                                        name: '<%=arrayListTask.get(j).GetName()%>',
                                                        duration: <%=arrayListTask.get(j).GetDuration()%>,
                                                        employee_id: <%=arrayListEmployee.get(i).GetID()%>,
                                                    });
                                                </script>
                                            <% }%>
                                        <% }%>
                                    <% }%>
                                    <tr onclick="open_employee_data_modal(taskObjArray_<%=arrayListEmployee.get(i).GetID()%>);">
                                        <th scope="row"><%=arrayListEmployee.get(i).GetID()%></th>
                                        <td><%=arrayListEmployee.get(i).GetFirstName()%></td>
                                        <td><%=arrayListEmployee.get(i).GetLastName()%></td>
                                        <td><%=arrayListEmployee.get(i).GetTeamName() == null ? "No Team Assigned" : arrayListEmployee.get(i).GetTeamName()%></td>
                                        <td><%=arrayListEmployee.get(i).GetSocialInsuranceNumber()%></td>
                                        <td><%="$".concat(arrayListEmployee.get(i).GetHourlyPayRate())%></td>
                                        <%
                                            String date_time_array[] = arrayListEmployee.get(i).GetDateTime().split(" ", 2);
                                        %>
                                        <td><input class="w-100" type="date" value="<%=date_time_array[0]%>"></td>
                                        <td><input class="w-100" type="time" value="<%=date_time_array[1]%>"></td>
                                        <td class="text-center align-middle">
                                            <div class="btn-group align-top">
                                                <button class="btn btn-sm btn-outline-primary badge" type="button" onclick="open_edit_modal(<%=arrayListEmployee.get(i).GetID()%>, '<%=arrayListEmployee.get(i).GetFirstName()%>', '<%=arrayListEmployee.get(i).GetLastName()%>', '<%=arrayListEmployee.get(i).GetSocialInsuranceNumber()%>', '<%=arrayListEmployee.get(i).GetHourlyPayRate()%>');">Edit</button>
                                                <button class="btn btn-sm btn-outline-danger badge" onclick="open_delete_confirm_modal('<%="employee_servlet?delete_employee_id=".concat(String.valueOf(arrayListEmployee.get(i).GetID()))%>')"><i class="fa fa-trash"></i></button>
                                            </div>
                                        </td>
                                    </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                <% } else{%>
                    <div class="alert alert-info alert-dismissible fade show" role="alert">
                        <strong>Report!</strong> No Employees Added yet.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                <% }%>
            <% } %>
        </div>
        <div class="row">
            <button class="btn btn-primary btn-block" type="button" data-toggle="modal" data-target="#insert_employee_modal">Create an Employee</button>
        </div>
    </div>
    <%@include file="includes/footer.html" %>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <!--bootstrap modals-->
    <%@include file="modals/employee_modals/insert_employee_modal.jsp" %>
    <%@include file="modals/employee_modals/edit_employee_modal.jsp" %>
    <%@include file="modals/employee_modals/employee_data_modal.jsp" %>
    <%@include file="modals/employee_modals/delete_confirm_modal.jsp" %>
    
    <script type="text/javascript" src="javascript/employee.js"></script>
  </body>
</html>