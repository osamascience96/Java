<%@include file="includes/header.jsp" %>

<style>
    #password-error, #email-error{
        color: red;
    }
</style>

<!-- Hero Area -section
=========================-->
<header class="hero-area th-fullpage" data-parallax="scroll" data-image-src="images/slider/bg-4.jpg">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1>Login <br>
          to Code Cenima</h1>
      </div>
    </div>
  </div>
</header>

<section class="contact-form">
   <div class="container">
       <% if(request.getParameter("respReg") != null && request.getParameter("respReg").compareTo("Success") == 0){%>
        <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Success!</strong> Registration Successful, Please Login to your Account.
        </div>
    <% }else if(request.getParameter("respLogin") != null && request.getParameter("respLogin").compareTo("Failed") == 0){%>
        <div class="alert alert-danger alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Error!</strong> Sign In Failed due to wrong credentials.
        </div>
    <% }%>
     <div class="row">
       <div class="title text-center">
         <h2>Sign In</h2>
       </div>
       <form id="loginform" action="LoginServlet" method="post" style="margin-left: 400px;">
         <div class="col-md-6 col-xs-12 col-sm-12">
           <div class="form-group">
               <input type="email" name="email" class="form-control" placeholder="Email">
           </div>
           <div class="form-group margin-0">
             <input type="password" name="password" class="form-control" placeholder="Password">
           </div>
           <div class="contact-btn text-center" style="margin-top: 50px;">
             <input class="btn btn-default btn-main" type="submit" value="SignIn">
           </div>
         </div>
       </form>
     </div>
   </div>
</section>
    
<script>
    document.addEventListener("DOMContentLoaded", function(){
        // rules for the form
        $("#loginform").validate({
            rules: {
                email: {
                    required: true,
                    email: true,
                },
                password: {
                    required: true,
                },
            },
            message: {
                email: 'Email is Required and it should be valid',
            }
        });
    });
</script>
<%@include file="includes/footer.jsp" %>