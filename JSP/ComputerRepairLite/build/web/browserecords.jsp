<%@page import="POJO.Request"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/navigation.css">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <title>Home</title>
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
        %>
        <%
            ArrayList<Request> RequestArrayList = (ArrayList<Request>) session.getAttribute("session_request_list");
        %>
        <% if(RequestArrayList != null){ %>
            <div class="caption">Records</div>	
                <div id="table">
                    <div class="header-row row">
                        <span class="cell primary">Id</span>
                        <span class="cell primary">Owner</span>
                        <span class="cell primary">Serial Number</span>
                        <span class="cell primary">Type</span>
                        <span class="cell primary">Model</span>
                        <span class="cell primary">Memory</span>
                        <span class="cell primary">Hard</span>
                        <span class="cell primary">Problems</span>
                        <span class="cell primary">Cost</span>
                        <span class="cell primary">Status</span>
                        <span class="cell primary">Finish</span>
                        <span class="cell primary">Delievery</span>
                    </div>
                    <% for(int i = 0; i < RequestArrayList.size(); i++){%>
                    <div class="row">
                      <span class="cell primary"><%=RequestArrayList.get(i).GetId()%></span>
                      <span class="cell primary"><%=RequestArrayList.get(i).GetComputerOwner()%></span>
                      <span class="cell primary"><%=RequestArrayList.get(i).GetSerialNumber()%></span>
                      <span class="cell primary"><%=RequestArrayList.get(i).GetType()%></span>
                      <span class="cell primary"><%=RequestArrayList.get(i).GetModel()%></span>
                      <span class="cell primary"><%=RequestArrayList.get(i).GetMemoryGB()%></span>
                      <span class="cell primary"><%=RequestArrayList.get(i).GetHardGB()%></span>
                      <span class="cell primary"><%=RequestArrayList.get(i).GetProblem()%></span>
                      <span class="cell primary"><%=RequestArrayList.get(i).GetRepairCost()%></span>
                      <span class="cell primary"><%=RequestArrayList.get(i).GetRepairStatus()%></span>
                      <span class="cell primary"><%=RequestArrayList.get(i).GetRepairFinishDateTime()%></span>
                      <span class="cell primary"><%=RequestArrayList.get(i).GetRepairDelieveryDateTIme()%></span>
                    </div>
                    <% }%>
                </div>
        <% }%>
    </body>
</html>
