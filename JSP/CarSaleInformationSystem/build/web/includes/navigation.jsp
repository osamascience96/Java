<nav class="topnav" id="topnav">
  <a href="index.jsp" class="logo"><img src="<%=request.getContextPath()%>/img/cartabicon.png" alt="Logo"></a>
  <a href="index.jsp">Home</a>
  <%
      if(session.getAttribute("is_login") != null){
  %>
    <%
        boolean login = (Boolean) session.getAttribute("is_login");
        if(login){
    %>
        <a href="addsale.jsp">Add Sale</a>
        <strong><a href="logout_servlet" style="float: right; background-color: #FF416C; color: white;">Logout</a></strong>
    <% }%>
  <% }%>
  <button class="icon" onclick="toggle()"><i class="fa fa-bars"></i></button>
</nav>