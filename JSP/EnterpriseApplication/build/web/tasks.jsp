<%@page import="com.pojo.Task"%>
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
    
    <link rel="stylesheet" type="text/css" href="css/tasks.css">
    <link rel="stylesheet" type="text/css" href="css/navigation.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    
    <title>Tasks</title>
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
                
                if(operationalResponse.compareTo("insert_success") == 0){
                    alertType = "success";
                    alertTitle = "Task Added!";
                    alertMessage = "Your Task Added Successfully";
                }else if(operationalResponse.compareTo("task_exists") == 0){
                    alertType = "danger";
                    alertTitle = "Task Exists!";
                    alertMessage = "Task Already exists in the System";
                }else if(operationalResponse.compareTo("update_success") == 0){
                    alertType = "success";
                    alertTitle = "Task Updated!";
                    alertMessage = "Task updated successfully";
                }else if(operationalResponse.compareTo("delete_success") == 0){
                    alertType = "success";
                    alertTitle = "Task Deleted!";
                    alertMessage = "Task Deleted successfully";
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
            <% if(session.getAttribute("tasklist") != null){%>
                <%
                    ArrayList<Task> arrayListTasks = (ArrayList<Task>) session.getAttribute("tasklist");
                    if(arrayListTasks.size() != 0){
                %>
                <div class="table table-bordered table-light table-responsive">
                    <table class="table">
                        <caption>List of Tasks</caption>
                        <thead>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Description</th>
                            <th scope="col">Duration</th>
                            <th scope="col">Created_at</th>
                            <th scope="col">Updated_at</th>
                            <th scope="col">Actions</th>
                        </thead>
                        <tbody>
                            <% for(int i=0; i < arrayListTasks.size(); i++){%>
                                <tr>
                                    <th scope="row"><%=arrayListTasks.get(i).GetId()%></th>
                                    <td><%=arrayListTasks.get(i).GetName()%></td>
                                    <td><button class="btn btn-outline-info btn-block" type="button" onclick="open_description('<%=arrayListTasks.get(i).GetDescription()%>');">Description</button></td>
                                    <td><%=arrayListTasks.get(i).GetDuration()%> Mins.</td>
                                    <td><%=arrayListTasks.get(i).GetCreatedAt()%></td>
                                    <td><%=arrayListTasks.get(i).GetUpdated()%></td>
                                    <script>
                                        var task_obj_<%=arrayListTasks.get(i).GetId()%> = {
                                            id: <%=arrayListTasks.get(i).GetId()%>,
                                            name: '<%=arrayListTasks.get(i).GetName()%>',
                                            description: '<%=arrayListTasks.get(i).GetDescription()%>',
                                            duration: <%=arrayListTasks.get(i).GetDuration()%>,
                                            created_at: '<%=arrayListTasks.get(i).GetCreatedAt()%>',
                                            updated_at: '<%=arrayListTasks.get(i).GetUpdated()%>',
                                        };
                                    </script>
                                    <td class="text-center align-middle">
                                        <div class="btn-group align-top">
                                            <button class="btn btn-sm btn-outline-primary badge" type="button" onclick="load_edit_task_modal(task_obj_<%=arrayListTasks.get(i).GetId()%>);">Edit</button>
                                            <button class="btn btn-sm btn-outline-danger badge" onclick="open_task_delete_modal('task_servlet?request_type=delete&task_id=<%=arrayListTasks.get(i).GetId()%>')"><i class="fa fa-trash"></i></button>
                                        </div>
                                    </td>
                                </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
                <% }else{%>
                    <div class="alert alert-info alert-dismissible fade show" role="alert">
                        <strong>Report!</strong> No Tasks Added yet.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                <% }%>
            <% }%>
            <button type="button" class="btn btn-primary btn-block add_task_btn" data-toggle="modal" data-target="#insert_task_modal">Add Task</button>
        </div>
    </div>
    <%@include file="includes/footer.html" %>
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <%@include file="modals/task_modals/insert_task_modal.jsp" %>
    <%@include file="modals/task_modals/edit_task_modal.jsp" %>
    <%@include file="modals/task_modals/task_description_modal.jsp" %>
    <%@include file="modals/task_modals/delete_confirm_modal.jsp" %>
    
    <!-- scripts -->
    <script type="text/javascript" src="javascript/tasks.js"></script>
  </body>
</html>