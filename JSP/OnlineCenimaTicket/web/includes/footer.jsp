<%@page import="java.time.LocalDate"%>
<!-- Footer Started -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="container">
                    <div class="footer-top">
                        <div class="col-md-4">
                            <!-- footer About section
                            ========================== -->
                            <div class="footer-about">
                                <h3 class="footer-title">About</h3>
                                <p>Nemo enim ipsam voluptatem quia voluptas <br>
                                    sit aspernatur aut odit aut fugit, sed quia <br>
                                    magni dolores eos qui ratione. ed quia <br>
                                    magni dolores</p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <!-- footer Address section
                            ========================== -->
                            <div class="footer-address">
                                <h3 class="footer-title">Address</h3>
                                <p>DeviserWeb 24/A,Jalalabad amborkhana amagnina, Sylhet.</p>
                                <p class="contact-address">
                                    Contact us : <a href="tel:+610383666274">+61 (0) 3 8366 6274 </a> <br>
                                    Write us : <a href="mailto:info@info.com">mail@itsnuman.com</a>
                                </p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <!-- footer Media link section
                            ========================== -->
                            <div class="footer-social-media">
                                <h3 class="footer-title">Keep in touch</h3>
                                <ul class="footer-media-link">
                                    <li><a href="#"><i class="tf-ion-social-facebook" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="tf-ion-social-twitter" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="tf-ion-social-linkedin-outline"
                                                aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="tf-ion-social-google-outline" aria-hidden="true"></i></a>
                                    </li>
                                    <li><a href="#"><i class="tf-ion-social-instagram-outline"
                                                aria-hidden="true"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="footer-nav text-center">
                        <div class="col-md-12">
                            <ul>
                                <li><a href="index.JSP">Home</a></li>
                                <li><a href="rooms.jsp">Rooms</a></li>
                                <li><a href="movies.jsp">Movies</a></li>
                                <li><a href="blog.jsp">Blog</a></li>
                                <li><a href="contact.jsp">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="text-center">
                        <div class="col-md-12">
                            <div class="copyright">
                                <%
                                    LocalDate currentDate = LocalDate.now();
                                %>
                                <p>&copy; 2013-<%=currentDate.getYear()%> All rights reserved. <br>
                                    Design and Developed By <a href="<%=request.getContextPath()%>">Code Cenima Team.</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>


    <script src="plugins/jquery.min.js"></script>

    <script src="plugins/bootstrap/bootstrap.min.js"></script>
    <!-- slick slider -->
    <script src="plugins/slick/slick.min.js"></script>
    <!-- filter -->
    <script src="plugins/filterizr/jquery.filterizr.min.js"></script>
    <!-- Lightbox -->
    <script src="plugins/magnific-popup/jquery.magnific-popup.min.js"></script>
    <!-- Parallax -->
    <script src="plugins/parallax.min.js"></script>
    <!-- Video -->
    <script src="plugins/jquery.vide.js"></script>
    <!-- jquery validation -->
    <script src="plugins/jquery.validate.js"></script>
    <script src="plugins/additional-methods.js"></script>
    <!-- google map -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC-yG6sTvv8MY_6v1h0iisWEd08ybqm_C4"></script>
    <script src="plugins/google-map/gmap.js"></script>

    <script src="js/script.js"></script>
    </body>

    </html>

<!-- Footer Finished -->