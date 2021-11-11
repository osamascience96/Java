<%@include file="includes/header.jsp" %>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body onload="$('form').submit(false);">
    <%@include file="includes/navigation.jsp" %>
    <%
        if(request.getParameter("response") != null){
    %>
        <%
            String responseAlert = request.getParameter("response");
        %>
        <%
            if(responseAlert.compareTo("resquest_add_success") == 0){
        %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Request Send!</strong> Your Repair Request has been send, successfully.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }else if(responseAlert.compareTo("feedback_add_success") == 0){%>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Feedback Send!</strong> Your Feedback has been send, successfully.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }else if(responseAlert.compareTo("username_error") == 0){%>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Error!</strong> Incorrect Username.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }else if(responseAlert.compareTo("password_error") == 0){%>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Error!</strong> Incorrect Password.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }else if(responseAlert.compareTo("illegal_access") == 0){%>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Error!</strong> Illegal Access.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
    <%
        }
    %>
    <div class="container">
        <div class="row">
            <nav>
                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                  <a class="nav-item nav-link active" id="nav-overview-tab" data-toggle="tab" href="#nav-overview" role="tab" aria-controls="nav-overview" aria-selected="true">Overview</a>
                  <a class="nav-item nav-link" id="repair-expert-tab" data-toggle="tab" href="#repair-expert" role="tab" aria-controls="repair-expert" aria-selected="false">Repair Expert</a>
                  <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Contact</a>
                </div>
            </nav>
        </div>
        <div class="row">
            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active" id="nav-overview" role="tabpanel" aria-labelledby="nav-overview-tab">
                    <strong>What is Online Computer Repair System?</strong>
                    <div class="w-100"></div>
                    <h6>It is an online system where you can generate your request to fix your computer. You can add all the details to your system and then our experts will fix it for you. We promise our customers the best of services and we have the most entrusted professionals with us in the state of Madinah. We can operate in almost all kinds of accessories of the computer system, and will fix your problems for you in most efficient and productive way, utilizing most balanced cost for our work. We are certified from IEEM(Institute of Electronics and Engineering Madinah). We wnsure to have a great communication and healthy dealings with our clients.</h6>
                    <!-- Include some of the Images -->
                    <div class="row text-center">
                        <div class="col">
                            <img src="img/computer_repair1.jpg" width="450px" height="450px" alt="comp_repair_1"/>
                        </div>
                        <div class="col">
                            <img src="img/computer_repair2.jpg" width="450px" height="450px" alt="comp_repair_1"/>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="repair-expert" role="tabpanel" aria-labelledby="repair-expert-tab">
                    <strong>Online Computer Repair Form</strong>
                    <div class="w-100"></div>
                    <h6>We provide the most easy and reliable form to our customers to fill in the detail and then we will contact you as soon as your repair order finishes. You can click from the top of the navigation to generate your request.</h6>
                    <div class="w-100"></div>
                    <div class="repair-imgs row text-center">
                        <div class="col">
                            <img src="img/repair_request1.jpg" width="450px" height="450px" alt="comp_repair_1"/>
                        </div>
                        <div class="col">
                            <img src="img/repair_request2.jpg" width="450px" height="450px" alt="comp_repair_1"/>
                        </div>
                    </div>
                    <a type="button" class="btn btn-primary btn-block" href="#" onclick="$('#repair_request_modal').modal('show');">Generate Your Request</a>
                </div>
                <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                    <h5>Our Contact Information</h5>
                    <div class="w-100"></div>
                    <div id="google_maps_location">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d14526.07509212816!2d39.60281073069043!3d24.467475947850833!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x15bdbfaa17677a65%3A0x703128c9aa6eb266!2sAl%20Baqia%20Gate%2C%20Al%20Haram%2C%20Medina%2042311%2C%20Saudi%20Arabia!5e0!3m2!1sen!2s!4v1616751274288!5m2!1sen!2s" width="800" height="500" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                    </div>
                    <div class="w-100"></div>
                    <h6>Contact Information: +482374824289234</h6>
                    <h6>You can visit our location and can contact us anytime you want!</h6>
                </div>
            </div>
        </div>
    </div>
<%@include file="modal/login.jsp" %>
<%@include file="modal/feedback_modal.jsp" %>
<%@include file="modal/repair_request_form.jsp" %>
<script src="js/formhandling.js" type="text/javascript"></script>
<%@include file="includes/footer.html" %>    