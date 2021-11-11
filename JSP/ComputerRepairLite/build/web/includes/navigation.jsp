<ul>
  <li><a href="/ComputerRepairLite">Home</a></li>
  <li><a href="feedback.jsp">Add Feedback</a></li>
  <li><a href="Location.jsp">Location</a></li>
  <%
      if(session.getAttribute("is_login") != null){
  %>
    <%
        boolean is_login = (Boolean) session.getAttribute("is_login");
    %>
    <%
        if(is_login){
    %>
        <li><a href="RepairExpert.jsp">Repair Request</a></li>
        <li><a href="RequestRepair">Browse Records</a></li>
        <li style="float:right"><a style="color: white; background-color: red;" href="logout_servlet">Logout</a></li>
    <% }%>
  <% }else{%>
    <li style="float:right"><a class="active" href="login.jsp">Login</a></li>
  <% }%>
</ul>