<%@include file="includes/header.jsp" %>

<style>
    #firstname-error, #username-error, #password-error, #email-error, #confirmpassword-error{
        color: red;
    }
</style>

<!-- Hero Area -section
=========================-->
<header class="hero-area th-fullpage" data-parallax="scroll" data-image-src="images/slider/bg-2.jpg">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1>Join <br>
           Code Cenima</h1>
      </div>
    </div>
  </div>
</header>


<section class="contact-form">
   <div class="container">
       <% if(request.getParameter("respReg") != null && request.getParameter("respReg").compareTo("Failed") == 0){%>
        <div class="alert alert-danger alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Error!</strong> Registration Failed
        </div>
    <% }%>
     <div class="row">
       <div class="title text-center">
         <h2>Sign Up</h2>
       </div>
        <form id="signupform" action="RegisterServlet" method="post">
         <div class="col-md-6">
           <div class="form-group">
               <input type="text" class="form-control" name="firstname" placeholder="First Name *">
           </div>
           <div class="form-group">
               <input type="text" class="form-control" name="username" placeholder="Username *">
           </div>
           <div class="form-group margin-0">
               <input type="password" class="form-control" id="password" name="password" placeholder="Password *">
           </div>
         </div>
         <div class="col-md-6 margin-0">
           <div class="form-group">
               <input type="text" class="form-control" name="lastname" placeholder="Last Name">
           </div>
           <div class="form-group margin-0">
               <input type="email" class="form-control" name="email" placeholder="Email *">
           </div>
           <div class="form-group" style="margin-top: 15px;">
               <input type="password" class="form-control" name="confirmpassword" placeholder="Confirm Password *">
           </div>
         </div>
         <div class="col-md-12">
             <div class="contact-btn text-center" style="margin-top: 15px;">
             <input class="btn btn-default btn-main" type="submit" value="SignUp">
           </div>
         </div>
       </form>
     </div>
   </div>
</section>

<script>
    document.addEventListener("DOMContentLoaded", function(){
        // rules for the form
        $("#signupform").validate({
            rules: {
                firstname: {
                    required: true,
                },
                username: {
                    required: true,
                    minlength: 8
                },
                email: {
                    required: true,
                    email: true,
                },
                password: {
                    required: true,
                },
                confirmpassword: {
                    required: true,
                    equalTo: "#password"
                }
            },
            message: {
                firstname: 'First Name is Required',
                username: 'Username is Required and minimum length should be 8 chars.',
                email: 'Email is Required and it should be valid',
            }
        });
    });
</script>

<%@include file="includes/footer.jsp" %>