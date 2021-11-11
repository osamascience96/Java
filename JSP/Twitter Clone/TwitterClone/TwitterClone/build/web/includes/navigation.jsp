<%@page import="Bean.User"%>
<nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="<%=getServletContext().getContextPath()%>">
      <img src="<%=getServletContext().getContextPath()%>/img/twitter.svg" width="30" height="30" class="d-inline-block align-top" alt="">
      Home
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="register.jsp">Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="tweet_controller">Tweets</a>
      </li>
      <%
          if(session.getAttribute("is_login") != null){
      %>
        <li class="nav-item">
            <a class="nav-link" href="" data-toggle="modal" data-target="#follow_users_modal">Follow Users</a>
        </li>
      <%
          }
      %>
    </ul>
    <div class="form-inline my-2 my-lg-0">
      <%
          if(session.getAttribute("is_login") != null){
      %>
        <%
            boolean is_login = (Boolean) session.getAttribute("is_login");
            if(is_login){
                User userObj = (User)session.getAttribute("userObj");
        %>
            <%
                if(userObj != null){
            %>
                <h5 class="form-control mr-sm-2"><%=userObj.getUsername() != null ? userObj.getUsername() : ""%></h5>
                <a href="logout_servlet" class="btn btn-danger my-2 my-sm-0 text-white">Logout</a>
            <% }%>
        <% }%>
      <% }%>
    </div>
  </div>
</nav>