<%@include file="includes/header.jsp" %>

<style>
    #email-error, #name-error, #message-error, #subject-error{
        color: red;
    }
</style>

<!-- Contact header-section 
  =========================-->
<section class="page-header services-header" data-parallax="scroll" data-image-src="images/header/contact-folding-img.jpg">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1 class="text-center">Contact Us. <br> We Ensure Quality Design.</h1>
      </div>
    </div>
  </div>
</section>

  <!-- Google map Study Sections 
  =========================-->
<section class="contact-map">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12 padding-0">
        <!-- map -->
        <%@include file="includes/MapEmbedded.jsp" %>
        <!-- Contact Information -->
        <div class="contact-info">
          <div class="contact-img">
            <img src="images/contact/contact-img1.png" alt="">
          </div>
          <div class="contact-content">
            <div class="content-title-section">
              <h3 class="content-title">redcodder solution</h3>
            </div>
            <div class="home-address">
              <div class="flex">
                <div class="contact-icon">
                  <i class="tf-ion-ios-home-outline"></i>
                </div>
                <p class="ct-info">24 Golden Tower (2nd Floor),  Sylhet.</p>
              </div>
            </div>
            <div class="web-address">
              <div class="flex">
                <div class="contact-icon">
                  <i class="tf-global"></i>
                </div>
                <a href="#" class="ct-info">deviserweb.com</a>
              </div>
            </div>
            <div class="phone-address">
              <div class="flex">
                <div class="contact-icon">
                  <i class="fa fa-phone" aria-hidden="true"></i>
                </div>
                <p class="ct-info">01771-299299 (Mobile)</p>
              </div>
            </div>
            <div class="contact-protfolio">
              <img src="images/contact/contact-img2.png" alt="">
              <img src="images/contact/contact-img3.png" alt="">
              <img src="images/contact/contact-img4.png" alt="">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Contact From Study Sections 
=========================-->
<section class="contact-form">
   <div class="container">
    <% if(request.getParameter("respSub") != null){%>
    <% if(request.getParameter("respSub").compareTo("Success") == 0){%>
            <div class="alert alert-success alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <strong>Success!</strong> Message Send Successfully.
            </div> 
    <% }else if(request.getParameter("respSub").compareTo("Failed") == 0){%>
            <div class="alert alert-danger alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <strong>Failed!</strong> Message could not be Send due to some problem.
            </div> 
        <% }%>
    <% }%>
    
    <%
        User userObj = (User) session.getAttribute("user_session_login");
        String name = "";
        String email = "";
        if(userObj != null){
            name = userObj.getFirstname().concat(userObj.getLastname() != null ? userObj.getLastname() : "");
            email = userObj.getEmail();
        }
    %>
    
    <div class="row">
      <div class="title text-center">
        <h2>Contact Us</h2>
      </div>
       <form id="contactform" action="ContactServlet" method="post">
           <div class="col-md-6">
               <div class="form-group">
                   <input type="text" class="form-control" name="subject" placeholder="Subject">
               </div>
               <div class="form-group">
                   <input type="email" class="form-control" name="email" value="<%=email%>" placeholder="Email">
               </div>
               <div class="form-group margin-0">
                   <input type="text" class="form-control" name="name" value="<%=name%>" placeholder="Name">
               </div>
           </div>
           <div class="col-md-6 margin-0">
             <div class="form-group">
                 <textarea class="form-control " rows="3" name="message" placeholder="Message"></textarea>
             </div>
           </div>
           <div class="col-md-12">
             <div class="contact-btn text-center">
               <input class="btn btn-default btn-main" type="submit" value="Sent Message">
             </div>
           </div>
       </form>
    </div>
   </div>
</section>

<script>
    document.addEventListener("DOMContentLoaded", function(){
        // rules for the form
        $("#contactform").validate({
            rules: {
                subject: {
                    minlength: 10,
                },
                name: {
                    required: true,
                },
                email: {
                    required: true,
                    email: true,
                },
                message: {
                    required: true,
                    minlength: 100,
                }
            }
        });
    });
</script>

<%@include file="includes/footer.jsp" %>