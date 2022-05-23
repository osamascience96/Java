<%@page import="java.util.Calendar"%>
<!-- footer -->
    <footer>
        <div id="contact" class="footer">
            <div class="container">
                <div class="row pdn-top-30">
                    <div class="col-md-12 ">
                        <div class="footer-box">
                            <div class="headinga">
                                <h3>Address</h3>
                                <span>House No.43, Street No.102, Farooq Street, Krishanagar, Islampura, Lahore</span>
                                <p>(+1)555666333
                                    <br>osamahu96@gmail.com</p>
                            </div>
                            <ul class="location_icon">
                                <li> <a href="#"><i class="fa fa-facebook-f"></i></a></li>
                                <li> <a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li> <a href="#"><i class="fa fa-instagram"></i></a></li>

                            </ul>
                            <div class="menu-bottom">
                                <ul class="link">
                                    <li> <a href="<%=request.getContextPath()%>">Home</a></li>
                                    <li> <a href="<%=request.getContextPath()%>/about.jsp">About</a></li>
                                    
                                    <li> <a href="<%=request.getContextPath()%>/brand.jsp">Brand </a></li>
                                    <li> <a href="<%=request.getContextPath()%>/special.jsp">Specials  </a></li>
                                    <li> <a href="<%=request.getContextPath()%>/contact.jsp"> Contact us</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyright">
                <div class="container">
                    <%
                        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
                    %>
                    <p>© <%=currentyear%> Project Developed By<a href="https://www.github.com/osamascience96"> Osama Ahmad</a></p>
                </div>
            </div>
        </div>
    </footer>
    <!-- end footer -->
    <!-- Javascript files-->
    <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery-3.0.0.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/plugin.js"></script>
    <!-- sidebar -->
    <script src="<%=request.getContextPath()%>/js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/custom.js"></script>
    <!-- javascript -->
    <script src="<%=request.getContextPath()%>/js/owl.carousel.js"></script>
    <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
    <script>
        $(document).ready(function() {
            $(".fancybox").fancybox({
                openEffect: "none",
                closeEffect: "none"
            });

            $(".zoom").hover(function() {

                $(this).addClass('transition');
            }, function() {

                $(this).removeClass('transition');
            });
        });
    </script>
</body>

</html>