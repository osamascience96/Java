<%@ page import="org.dspace.eperson.EPerson" %>
<%
   // Is anyone logged in?
    EPerson user = (EPerson) request.getAttribute("dspace.current.user");

    // Is the logged in user an admin
    Boolean admin = (Boolean)request.getAttribute("is.admin");
    boolean isAdmin = (admin == null ? false : admin.booleanValue());

    Boolean communityAdmin = (Boolean)request.getAttribute("is.communityAdmin");
    boolean isCommunityAdmin = (communityAdmin == null ? false : communityAdmin.booleanValue());
    
    Boolean collectionAdmin = (Boolean)request.getAttribute("is.collectionAdmin");
    boolean isCollectionAdmin = (collectionAdmin == null ? false : collectionAdmin.booleanValue());
%>
<div class="row">
  <div class="col-sm-12 col-md-3">
    <img src="<%= request.getContextPath() %>/image/logo.gif" width="200px" height="60px" style="margin-top: 15px; margin-left: 15px;"/>
  </div>
  <div class="col-sm-12 col-md-6" style="text-align:center; margin-top:15px;">
    <h2 class="text-danger" style="font-weight: bold; font-family: sans-serif; color:#8B1615;">
      Ashoka Archives of Contemporary India
    </h2>
  </div>
  <div class="col-sm-12 col-md-3">
    <img src="<%= request.getContextPath() %>/image/side_navlogo.PNG" style="margin-left: 100px;" width="210px" height="100px"/>
  </div>
</div>

<nav class="navbar navbar-default" style="background:#8B1615!important;">
  <div class="container-fluid">
    <%-- nav header --%>
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbardefault" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="<%=request.getContextPath()%>">
        <img src="<%=request.getContextPath()%>/image/defnavicon.PNG" width="40" height="40" alt="home"/>
      </a>
    </div>

    <%-- navigation links --%>
    <div class="collapse navbar-collapse" id="navbardefault">
      <ul class="nav navbar-nav" style="margin-top:10px;">
        <%-- About us --%>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
            About Us <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a href="aboutus_aaci.jsp">AACI</a></li>
            <li><a href="aboutus_arch_access_policy.jsp" target="_blank">Archives Access Policy <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
            <li><a href="aboutus_vision.jsp">Vision</a></li>
            <li><a href="aboutus_mission.jsp">Mission</a></li>
          </ul>
        </li>
        <%-- Admission --%>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
            Admission <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a href="scholars_guidelines.jsp" target="_blank">Guidelines for Scholars <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
            <li><a href="access_archival_collect.jsp" target="_blank">Access to archival collections <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
            <li><a href="finding_aids.jsp" target="_blank">Finding Aids <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
            <li><a href="copyrights.jsp" target="_blank">Copyright <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
            <li><a href="reading_room.jsp" target="_blank">Visit to Reading Room <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
          </ul>
        </li>
        <%-- explore archives --%>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
            Explore Archives <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a href="advance_search.jsp" target="_blank">Advanced Search <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
            <li><a href="collections_overview.jsp" target="_blank">Overview of Collections <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
            <li><a href="index_collections_catalogues.jsp" target="_blank">Index of Collections/Catalogues A-Z <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
            <li><a href="digital_archives.jsp" target="_blank">Digital Archives <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
            <li><a href="recent_acquisitions.jsp" target="_blank">Recent Acquisitions <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
            <li><a href="glimpse_archives.jsp" target="_blank">Glimpses of Archives <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
            <li><a href="raise_query.jsp" target="_blank">Raise Query <span><img src="<%=request.getContextPath()%>/image/open_link.png" width="10px" height="10px"/></span></a></li>
          </ul>
        </li>
        <%-- Outreach --%>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
            Outreach <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a href="academic_activities.jsp">Academic Activities</a></li>
            <li><a href="collaboration.jsp">Collaboration</a></li>
          </ul>
        </li>
        <%-- Contact Us --%>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
            Contact Us <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a href="contact_information.jsp">Contact Information</a></li>
          </ul>
        </li>
      </ul>

      <%-- serach icon --%>
      <form class="navbar-form navbar-right" style="margin-top:20px;">
        <div class="form-group">
          <input type="text" />
          <button style="background:none; border:none;">
            <img src="<%=request.getContextPath()%>/image/magnifysearch.PNG" width="10" height="10"/>
          </button>
        </div>
        <% if(user != null){%>
          <a href="<%=request.getContextPath()%>/logout" class="btn btn-danger logout_btn">Logout</a>
        <% }else{%>
          <%-- Login/signup button --%>
          <a href="<%=request.getContextPath()%>/mydspace" class="btn btn-primary login_btn">LOGIN/SIGN UP</a>
        <% }%>
      </form>
    </div>
  </div>
</nav>