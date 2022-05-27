<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="index.jsp">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="registration.jsp">Registration</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Book">Catalog</a>
      </li>
    </ul>
    <div class="form-inline my-2 my-lg-0">
   	  <% if(session.getAttribute("is_login") != null){ %>
   	  		<button class="btn btn-outline-primary my-2 my-sm-0" data-toggle="modal" data-target="#profile_modal">Profile</button>
   	  <% }else{ %>
      		<button class="btn btn-outline-success my-2 my-sm-0" data-toggle="modal" data-target="#login_modal">Login</button>
      <% } %>
    </div>
  </div>
</nav>