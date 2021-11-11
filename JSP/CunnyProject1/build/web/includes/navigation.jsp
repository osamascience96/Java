<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <%
      String link = "";
      if(session.getAttribute("is_login") != null){
          link = "log_employee_controller";
      }else{
          link = "index.jsp";
      }
  %>
  <a class="navbar-brand" href="<%=link%>">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    </ul>
    <div class="form-inline my-2 my-lg-0">
        <%
            if(session.getAttribute("is_login") != null){
        %>
            <a class="btn btn-outline-danger my-2 my-sm-0" href="Logout">Logout</a>
        <%
            }
        %>
    </div>
  </div>
</nav>