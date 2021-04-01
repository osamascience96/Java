<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">My Chat</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">   
    </ul>
      <form action="login" method="POST" class="form-inline my-2 my-lg-0">
      <%
          String username = (String) session.getAttribute("username");
      %>
      <%
          if(username != null){
              boolean isLogin = (Boolean) session.getAttribute("isLogin");
      %>
        <%
            if(isLogin){
        %>
        <input class="form-control mr-sm-2" type="text" placeholder="Username" value="<%=username%>"  aria-label="Search" readonly>
        <a class="btn btn-outline-danger my-2 my-sm-0" href="logout">Logout</a>
        <%
            }
        %>
      <% }else{%>
        <input class="form-control mr-sm-2" type="text" placeholder="Username" name="username" aria-label="Search" required>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
      <% }%>
    </form>
  </div>
</nav>