<%@include file="includes/header_unauth.jsp" %>

<style>
    #password-error, #email-error{
        color: red;
        margin-top: 38px;
    }
</style>

<!-- Sign In Start -->
<div class="container-fluid">
    <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
        <%
            String error = request.getParameter("error");
            if(error != null){
        %>
            <div class="alert alert-danger" style="width:90%;" role="alert">
                <strong>Error!</strong> Invalid Login Credentials.
            </div>
        <% }%>
        <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
            <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
                <div class="d-flex align-items-center justify-content-between mb-3">
                    <a href="admin" class="">
                        <h3 class="text-primary">Admin</h3>
                    </a>
                    <h3>Sign In</h3>
                </div>
                <form id="loginform" action="<%=request.getContextPath()%>/admin" method="post">
                    <div class="form-floating mb-3">
                        <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
                        <label for="email">Email address</label>
                    </div>
                    <div class="form-floating mb-4">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                        <label for="password">Password</label>
                    </div>
                    <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Sign In</button>
                </form>
            </div>
        </div>
    </div>
</div>

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

<!-- Sign In End -->
<%@include file="includes/footer_unauth.jsp" %>