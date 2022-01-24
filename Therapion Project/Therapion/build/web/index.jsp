<%@include file="includes/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">
<title>Home - Therapion</title>
</head>
  <body>
      <div class="row">
          <div class="col-xs-12 col-sm-12 col-md-6 text-center">
              <br/><br/><br/><br/><br/><br/><br/>
              <div class="row">
                  <h3>Professional therapy anytime, anywhere.</h3>
              </div>
              <div class="row">
                  <p>Therapion provides access to a qualified 
                    therapist that is accessible, discrete, and 
                    affordable online for everyone</p>
              </div>
              <div class="row">
                  <a class="consult_btn text-light" href="survey.jsp">Consult Today</a>
              </div>
          </div>
          <div class="col-xs-12 col-sm-12 col-md-6">
              <img class="img-fluid" src="<%=request.getContextPath()%>/img/landing_page.png">
          </div>
      </div>
<%@include file="includes/footer.jsp" %>