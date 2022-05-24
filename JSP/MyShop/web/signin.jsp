<%@include file="includes/header.jsp" %>
<div class="container-fluid">
    <form action="#" class="mt-4" method="post">
        <div class="row g-3 bg-secondary p-2">
            <!-- input email group -->
            <div class="col-xs-12 col-sm-12 col-md-6">
                <div class="form-group">
                    <label class="form-label text-white">Email</label>
                    <input class="form-control" type="email" id="email" name="email" placeholder="Enter Email Address" required >
                </div>
            </div>
            <div class="offset-md-6"></div>
            <!-- input password group -->
            <div class="col-xs-12 col-sm-12 col-md-6">
                <div class="form-group">
                    <label class="form-label text-white">Password</label>
                    <input class="form-control" type="password" id="password" name="password" placeholder="Enter Password" required >
                </div>
            </div>
            <div class="offset-md-6"></div>
            <!-- remember me check -->
            <div class="col-xs-12 col-sm-12 col-md-4 mb-2">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="remember_me" name="remember_me">
                    <label class="custom-control-label text-white" for="remember_me">Remember Me</label>
                </div>
            </div>
            <div class="offset-md-8"></div>
            <div class="col-xs-12 col-sm-12 col-md-3">
                <!-- submit btn -->
                <div class="form-group">
                    <input class="btn btn-success btn-block" type="submit" value="Sign In" required >
                </div>
            </div>
        </div>
    </form>
</div>
<%@include file="includes/footer.jsp" %>