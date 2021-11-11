<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/EnterpriseApplication">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="job_servlet">Jobs <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="employee_servlet">Employee</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="task_servlet">Tasks</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="team_servlet">Teams</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="client_servlet">Clients</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
        <h5 class="form-control mr-sm-2">Advance Technology Systems</h5>
        <%
            if(session.getAttribute("login") != null){
        %>
            <a class="btn btn-outline-danger my-2 my-sm-0" href="logout_servlet">Logout</a>
        <% }%>
    </form>
  </div>
</nav>