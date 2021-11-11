<%@page import="com.pojo.JobTask"%>
<%@page import="com.pojo.Job"%>
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
    
    <link rel="stylesheet" type="text/css" href="css/jobs.css">
    <link rel="stylesheet" type="text/css" href="css/navigation.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    
    <title>Jobs</title>
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
            String respond = request.getParameter("response");
            if(respond != null){
        %>
            <%
                if(respond.compareTo("teams_length_exceeds") == 0){
            %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Error!</strong> You can enter only 1 team.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% }else if(respond.compareTo("no_request_type") == 0){%>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Error!</strong> No Request Type defined.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% }else if(respond.compareTo("invalid_request_type") == 0){%>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Error!</strong> Invalid Request Type.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% }else if(respond.compareTo("client_length_exceeds") == 0){%>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Error!</strong> You can enter only 1 client.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% }else if(respond.compareTo("insert_record_success") == 0){%>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Success!</strong> The Jobs has been created.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% }else if(respond.compareTo("comment_added_success") == 0){%>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Success!</strong> The Comment is Added.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% }else if(respond.compareTo("delete_success") == 0){%>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Success!</strong> Job Deleted Successfully.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% }else if(respond.compareTo("finish_job_success") == 0){%>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Success!</strong> Job Finish Successfully.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% }else if(respond.compareTo("deleted_failed") == 0){%>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Failed!</strong> You cannot delete the job due to job not finished.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% }%>
        <% }%>
        <div class="table-container container">
            <%
                ArrayList<Job> arrayListJobs = (ArrayList<Job>) session.getAttribute("job_list");
            %>
            <% if(arrayListJobs != null){%>
                <%
                    if(arrayListJobs.size() > 0){
                %>
                <div class="table table-bordered table-light table-responsive-lg">
                    <table class="table">
                        <caption>List of Jobs</caption>
                        <thead>
                            <th scope="col">ID</th>
                            <th scope="col">Team</th>
                            <th scope="col">Client</th>
                            <th scope="col">Task</th>
                            <th scope="col">Cost</th>
                            <th scope="col">Revenue</th>
                            <th scope="col">Description</th>
                            <th scope="col">Comments</th>
                            <th scope="col">Start Date</th>
                            <th scope="col">End Date</th>
                            <th scope="col">Action</th>
                        </thead>
                        <tbody>
                            <% for(int i=0; i < arrayListJobs.size(); i++){%>
                                <tr>
                                    <th scope="row"><%=arrayListJobs.get(i).GetId()%></th>
                                    <td><%=arrayListJobs.get(i).GetTeamObj().GetTeamName()%></td>
                                    <td><%=arrayListJobs.get(i).GetClientObj().GetName()%></td>
                                    <%
                                        ArrayList<JobTask> arrayListJobTasks = arrayListJobs.get(i).GetJobTaskArrayList();
                                    %>
                                    <script>
                                        var jobtasklist_<%=arrayListJobs.get(i).GetId()%> = [];
                                        <% for(int a=0; a < arrayListJobTasks.size(); a++){%>
                                            <%
                                                Task task = arrayListJobTasks.get(a).GetTaskObj();
                                            %>
                                            jobtasklist_<%=arrayListJobs.get(i).GetId()%>.push({
                                                taskid: <%=task.GetId()%>,
                                                taskname: '<%=task.GetName()%>',
                                                duration: '<%=task.GetDuration()%>'
                                            });
                                        <% }%>
                                    </script>
                                    <td><button type="button" class="btn btn-outline-info btn-block" onclick="open_task_list_modal(jobtasklist_<%=arrayListJobs.get(i).GetId()%>)">Tasks</button></td>
                                    <%
                                        double cost = 0;
                                        double revenue = 0;
                                        for(int j=0; j < arrayListJobTasks.size(); j++){
                                            cost += arrayListJobTasks.get(j).GetOperatingCost();
                                            revenue += arrayListJobTasks.get(j).GetOperatingRevenue();
                                        }
                                    %>
                                    <td class="text-center">$<%=cost%></td>
                                    <td class="text-center">$<%=revenue%></td>
                                    <script>
                                        var description_<%=arrayListJobs.get(i).GetId()%> = '<%=arrayListJobs.get(i).GetDescription()%>';
                                    </script>
                                    <td><button type="button" class="btn btn-outline-info btn-block" onclick="open_description_modal(description_<%=arrayListJobs.get(i).GetId()%>)">Description</button></td>
                                    <script>
                                        var job_comments_<%=arrayListJobs.get(i).GetId()%> = '<%=arrayListJobs.get(i).GetJobCommentObj().GetComment()%>';
                                    </script>
                                    <% if(arrayListJobs.get(i).GetJobCommentObj().GetComment() != null){ %>
                                    <td><button type="button" class="btn btn-outline-info btn-block" onclick="open_comments_modal(job_comments_<%=arrayListJobs.get(i).GetId()%>)">View Comments</button></td>
                                    <% }else{ %>
                                    <td><button type="button" class="btn btn-outline-primary btn-block" onclick="open_add_comment_form_modal(<%=arrayListJobs.get(i).GetId()%>)">Add Comments</button></td>
                                    <% }%>
                                    <%
                                        String start_date = arrayListJobs.get(i).GetStartDate();
                                        String end_date = arrayListJobs.get(i).GetEndDate();
                                    %>
                                    <td>
                                        <input type="date" class="form-control" value="<%=start_date.split(" ")[0]%>"/>
                                        <div class="w-100"></div>
                                        <input type="time" class="form-control" value="<%=start_date.split(" ")[1]%>"/>
                                    </td>
                                    <td>
                                        <input type="date" class="form-control" value="<%=end_date.split(" ")[0]%>"/>
                                        <div class="w-100"></div>
                                        <input type="time" class="form-control" value="<%=end_date.split(" ")[1]%>"/>
                                    </td>
                                    <td class="text-center align-middle">
                                        <div class="btn-group align-top">
                                            <button class="btn btn-sm btn-outline-primary badge" type="button" onclick="open_finish_modal('job_servlet?finish_record=<%=arrayListJobs.get(i).GetTeamId()%>')">Finish</button>
                                            <button class="btn btn-sm btn-outline-danger badge" onclick="open_delete_modal('job_servlet?delete_record=<%=arrayListJobs.get(i).GetId()%>')"><i class="fa fa-trash"></i></button>
                                        </div>
                                    </td>
                                </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
                <% }else{%>
                    <div class="alert alert-info alert-dismissible fade show" role="alert">
                        <strong>Report!</strong> No Jobs Added yet.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                <% }%>
            <% }%>
        </div>
        
        <button id="add_job_btn" type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#insert_job_modal">Add Job</button>
    </div>
    <%@include file="includes/footer.html" %>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <!-- Modals -->
    <%@include file="modals/job_modals/insert_job_modal.jsp" %>
    <%@include file="modals/job_modals/tasks.jsp" %>
    <%@include file="modals/job_modals/description.jsp" %>
    <%@include file="modals/job_modals/viewcomments.jsp" %>
    <%@include file="modals/job_modals/addcomments.jsp" %>
    <%@include file="modals/job_modals/delete_confirm_modal.jsp" %>
    <%@include file="modals/job_modals/finish_job_modal.jsp" %>
    
    <!-- scripts -->
    <script type="text/javascript" src="javascript/jobs.js"></script>
  </body>
</html>