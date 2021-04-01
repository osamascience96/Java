<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">
      <img src="<%=request.getContextPath()%>/img/navicon.svg" width="30" height="30" class="d-inline-block align-top" alt="nav_icon">
    Home
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
          <a class="nav-link" href="#" onclick="$('#repair_request_modal').modal('show');">Add Repair Request</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          More
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="RequestRepair">Browse Records</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#" onclick="$('#feedback_modal').modal('show')">Add Feedback</a>
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
        <%
            HttpSession httpSession = request.getSession();
            if(httpSession.getAttribute("is_login") != null){
        %>
            <%
                boolean is_login = (Boolean) httpSession.getAttribute("is_login");
                if(is_login){
            %>
                <a class="btn btn-outline-danger my-2 my-sm-0" type="submit" href="logout">Logout</a>
            <% }%>
        <% }else{%>
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" onclick="$('#login_modal').modal('show')">Login</button>
        <% }%>
    </form>
  </div>
</nav>