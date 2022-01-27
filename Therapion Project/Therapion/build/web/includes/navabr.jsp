<%@page import="pojo.User"%>
<%
    String page_name = (String)request.getAttribute("page_name");
    HttpSession httpSession = request.getSession();
    User userObj = (User)httpSession.getAttribute("userObj");
%>
<nav class="navbar navbar-expand-lg navbar-light bg-white">
  <div class="container-fluid">
      <a class="navbar-brand" href="<%=request.getContextPath()%>">
          <img src="<%=request.getContextPath()%>/img/main_icon.png" alt="" width="100" height="24">
      </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      </ul>
      <form class="d-flex">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link <%=page_name == null ? "active fw-bold" : ""%>" aria-current="page" href="<%=request.getContextPath()%>">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <%=page_name != null ? (page_name == "advice" ? "active fw-bold": "") : ""%>" href="advice_controller">Advice</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <%=page_name != null ? (page_name == "faq" ? "active fw-bold": "") : ""%>" href="#">FAQ</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <%=page_name != null ? (page_name == "testimonials" ? "active fw-bold": "") : ""%>" href="#">Testimonials</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <%=page_name != null ? (page_name == "contactus" ? "active fw-bold": "") : ""%>" href="ContactController">Contact</a>
            </li>
            <li class="nav-item">
              <a class="nav-link <%=page_name != null ? (page_name == "aboutus" ? "active fw-bold": "") : ""%>" href="#">About Us</a>
            </li>
        </ul>
      </form>
    </div>
  </div>
</nav>