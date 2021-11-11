<%@include file="includes/header.jsp" %>
<main>
    <div class="inner-bg login-signup-form">
        <div class="container">
            <%
                // if response is set
                if(request.getParameter("response") != null){
            %>
                <%
                    // wenn der Benutzer existiert
                    if(request.getParameter("response").compareToIgnoreCase("user_exists") == 0){
                %>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Registration Failed!</strong> User Already Exists
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                <% }else if(request.getParameter("response").compareToIgnoreCase("wish_list_login") == 0){%>
                    <div class="alert alert-warning alert-dismissible fade show" role="alert">
                        <strong>Login Request!</strong> Kindly Login before Adding any Product to wishlist
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                <% }else if(request.getParameter("response").compareToIgnoreCase("cart_login") == 0){%>
                    <div class="alert alert-warning alert-dismissible fade show" role="alert">
                        <strong>Login Request!</strong> Kindly Login before Adding any Product to cart
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                <% }%>
            <%}%>
            <div class="row">
                <div class="col-sm-12">
                    <h2>Willkommen bei luxury lipstiks!</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-5">

                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Ich habe schon einen Account</h3>
                                <p>Geben Sie den Benutzernamen und das Passwort ein, um sich anzumelden:</p>
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-key"></i>
                            </div>
                        </div>
                        <div class="form-bottom">
                            <form method="post" accept-charset="utf-8" id="login_from" action="login_servlet">

                            <div class="form-group">                           
                                <input type="email" name="email" placeholder="Email eingeben *" class="form-username form-control input" id="login_email" required>
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" placeholder="Passwort eingeben *" class="form-password form-control input" id="login_password" required>
                            </div>
                            <!--  <a href="javascript:void(0);" data-toggle="modal" class="foget-link text-info" data-target="#forgotPass">Forgot password</a> -->
                            <div class=" check-g">
                                <span>*</span> Pflichtfelder  
                            </div>
                            <button type="submit" class="btn mt-2">Einloggen</button>
                            </form>                  
                        </div>
                    </div>               

                </div>
                <div class="col-sm-1 middle-border"></div>
                <div class="col-sm-1"></div>
                <div class="col-sm-5">
                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Ich bin neu in Luxus Lippenstift</h3>
                                <p>Füllen Sie das folgende Formular aus, um sofortigen Zugriff zu erhalten:</p>
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-sign-in" aria-hidden="true"></i>
                            </div>
                        </div>
                        <div class="form-bottom">
                            <form method="post" id="sigup_form" action="registration">  
                            <div class="form-group">
                                <label class="login-redio-g">
                                    <input type="radio" name="gender" value="female"> weiblich
                                    <span class="checkmark"></span>
                                </label>
                                <label class="login-redio-g">
                                    <input type="radio" name="gender" value="male" checked> männlich
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                            <div class="form-group">
                                <input type="text" name="first_name" placeholder="Bitte Vornamen eingeben*" class="form-first-name form-control input" id="form-first-name" required>
                            </div>
                            <div class="form-group">
                                <input type="text" name="last_name" placeholder="Nachnamen eingeben*" class="form-last-name form-control input" id="form-last-name"required>
                            </div>
                            <div class="form-group">
                                <input type="text" name="email" placeholder="Email eingeben*" class="form-email form-control input" id="signup_email" required>
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" placeholder="Passwort eingeben*" class="form-password form-control input" id="password" required>
                            </div>
                            <div class="form-group">
                                <input type="password" name="confirm_password" placeholder="Passwort wiederholen*" class="form-password form-control input" id="confirm_password" required>
                            </div>
                            <div class="form-group">
                                <input type="text" name="address" placeholder="Adresse eingeben*" class="form-password form-control input" id="address" required>
                            </div>
                            <div class=" check-g">
                                <span>*</span> Pflichtfelder                           
                            </div>
                            <button type="submit" class="btn">Neue Registrierung</button>

                            </form>                  
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
        
<%@include file="includes/footer.jsp" %>