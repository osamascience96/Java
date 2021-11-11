<%@include file="includes/header.jsp" %>
<link rel="stylesheet" href="css/clock.css">
<link rel="shortcut icon" type="image/png" href="img/favicon.png"/>
</head>
<%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("username") == null){
            response.sendRedirect("index.jsp");
        }
    %>
  <body>
      <%@include file="includes/navigation.jsp" %>
      <div class="container">
          <div class="clock">

        <div class="hour">
            <div class="hr" id="hr">
                
            </div>
        </div>

        <div class="min">
            <div class="mn" id="mn">

            </div>
        </div>

        <div class="sec">
            <div class="sc" id="sc">

            </div>
        </div>

    </div>
    <div class="toggleClass" onclick="toggleClass()"></div>
    <script src="JS/main.js"></script>
      </div>
<%@include file="modals/login.jsp" %>
<%@include file="includes/footer.jsp" %>