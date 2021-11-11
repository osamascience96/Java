<%@page import="POJO.Request"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>All Records</title>
  </head>
  <body>
    <%@include file="includes/navigation.jsp" %>
    <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("is_login") == null){
            response.sendRedirect("index.jsp");
        }
        
        ArrayList<Request> RequestArrayList = (ArrayList<Request>) session.getAttribute("session_request_list");
    %>
    <%
        if(RequestArrayList != null){
    %>
        <div class="table-responsive-xl">
            <table class="table table-hover">
                <thead class="thead-dark">
                    <tr>
                      <th scope="col">ID.</th>
                      <th scope="col">Owner</th>
                      <th scope="col">Serial Number</th>
                      <th scope="col">Type</th>
                      <th scope="col">Model</th>
                      <th scope="col">Memory</th>
                      <th scope="col">Hard</th>
                      <th scope="col">Problems</th>
                      <th scope="col">Cost</th>
                      <th scope="col">Status</th>
                      <th scope="col">Finish</th>
                      <th scope="col">Delievery</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(int i = 0; i < RequestArrayList.size(); i++){%>
                        <tr>
                          <th scope="row"><%=RequestArrayList.get(i).GetId()%></th>
                          <td><%=RequestArrayList.get(i).GetComputerOwner()%></td>
                          <td><%=RequestArrayList.get(i).GetSerialNumber()%></td>
                          <td><%=RequestArrayList.get(i).GetType()%></td>
                          <td><%=RequestArrayList.get(i).GetModel()%></td>
                          <td><%=RequestArrayList.get(i).GetMemoryGB()%></td>
                          <td><%=RequestArrayList.get(i).GetHardGB()%></td>
                          <td><%=RequestArrayList.get(i).GetProblem()%></td>
                          <td><%=RequestArrayList.get(i).GetRepairCost()%></td>
                          <td><%=RequestArrayList.get(i).GetRepairStatus()%></td>
                          <td><%=RequestArrayList.get(i).GetRepairFinishDateTime()%></td>
                          <td><%=RequestArrayList.get(i).GetRepairDelieveryDateTIme()%></td>
                        </tr>
                    <% }%>
              </tbody>
            </table>
        </div>
    <% }%>

<%@include file="modal/login.jsp" %>
<%@include file="modal/feedback_modal.jsp" %>
<%@include file="modal/repair_request_form.jsp" %>
<script src="js/formhandling.js" type="text/javascript"></script>
<%@include file="includes/footer.html" %>    