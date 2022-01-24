<%@include file="includes/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/contactus.css">
<title>Contact Us - Therapion</title>
</head>
  <body>
      <div id="contact_main" class="container">
          <h3>Contact Us</h3>
          <p>Please Provide some information to get started.</p>
          <div class="row">
              <div class="col-xs-12 col-sm-12 col-md-8">
                  <form action="#" method="post">
                      <div class="form-group">
                          <input type="text" class="form-control" placeholder="First name" required/>
                      </div>
                      <br>
                      <div class="form-group">
                          <input type="text" class="form-control" placeholder="Last name" />
                      </div>
                      <br>
                      <div class="form-group">
                          <input type="email" class="form-control" placeholder="Email Address" required/>
                      </div>
                      <br>
                      <div class="form-group">
                          <textarea class="form-control" placeholder="Message" rows="3" required></textarea>
                      </div>
                      <br>
                      <input id="contact_submit_btn" type="submit" class="btn btn-light" value="Submit">
                  </form>
              </div>
              <div class="col-xs-12 col-sm-12 col-md-4">
                  <p>Do you have a question, concern, idea, feedback, or problem? Take a look at our frequently asked questions for some quick answers. If you still need assistance, please fill out the form below and we'd be happy to help!</p>
                  <div class="row">
                      <label class="form-label">Phone:</label>
                      <p style="color:#5B61AA; font-weight:bold;">+1 (877) 747-9986</p>
                  </div>
                  <div class="row">
                      <label class="form-label">Hours:</label>
                      <p>Monday - Sunday: <span style="font-weight:bold;">7am - 11pm EST</span></p>
                  </div>
              </div>
          </div>
      </div>
<%@include file="includes/footer.jsp" %>