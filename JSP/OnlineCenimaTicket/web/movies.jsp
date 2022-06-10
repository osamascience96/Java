<!doctype html>
<html class="no-js" lang="zxx">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Fiction Multipage Bootstrap Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <!-- Place favicon.ico in the root directory -->

    <link rel="stylesheet" href="plugins/bootstrap/bootstrap.min.css">
    <!-- ThemeFisher Icon -->
    <link rel="stylesheet" href="plugins/themefisher-fonts/themefisher-fonts.css">
    <!-- Light Box -->
    <link rel="stylesheet" href="plugins/magnific-popup/magnific-popup.css">
    <!-- animation css -->
    <link rel="stylesheet" href="plugins/animate/animate.css">
    <!-- slick slider -->
    <link rel="stylesheet" href="plugins/slick/slick.css">

    <!-- Revolution Slider -->
    <link rel="stylesheet" href="css/style.css">

    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map_canvas {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
    </style>
    <script src="plugins/modernizr.min.js"></script>
  </head>
  <body>
    <!--[if lt IE 8]>
      <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

  <!-- Loader to display before content Load-->
  <div class="loading">

    <!-- <img src="img/loader.gif" alt=""> -->

    <div class="windows8 loading-position">
      <div class="wBall" id="wBall_1">
        <div class="wInnerBall"></div>
      </div>
      <div class="wBall" id="wBall_2">
        <div class="wInnerBall"></div>
      </div>
      <div class="wBall" id="wBall_3">
        <div class="wInnerBall"></div>
      </div>
      <div class="wBall" id="wBall_4">
        <div class="wInnerBall"></div>
      </div>
      <div class="wBall" id="wBall_5">
        <div class="wInnerBall"></div>
      </div>
    </div>
  </div> 


 <!-- Navigation -section
  =========================-->
<nav class="navbar navbar-fixed-top navigation" >
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand logo" href="index.jsp.html">
        <img src="images/logo-yellow.png" alt="">
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
      <ul class="nav navbar-nav navbar-right menu">
        <li><a href="index.jsp.html">Home</a></li>
        <li><a href="services.html">Service</a></li>
        <li><a href="portfolio.html">Portfolio</a></li>
        <li><a href="blog.html">Blog</a></li>
        <li><a href="contact.html">Contact</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div>
</nav>

  <!-- Portfolio header-section 
  =========================-->
<section class="page-header services-header" data-parallax="scroll" data-image-src="images/header/portfolio-folding-img.jpg">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1 class="text-center">Our Portfolio.<br> We Ensure Quality Design.</h1>
      </div>
    </div>
  </div>
</section>

 <!-- Portfolio Sections 
 =========================-->
 <section class="portfolio">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="title text-center">
          <h2>Our Portfolio</h2>
        </div>
        <div class="protfolio-mixitup-btn text-center">
          <button class="filter btn btn-default btn-main active" data-filter="all">all</button>
          <button class="filter btn btn-default btn-main" data-filter="category-1">branding</button>
          <button class="filter btn btn-default btn-main" data-filter="category-2">User interface</button>
          <button class="filter btn btn-default btn-main" data-filter="category-3">print design</button>
        </div>
        <div id="Container" class="filtr-container row">
          <div class="filtr-item col-md-4 col-sm-6 col-xs-12" data-category="category-1">
            <div class="portfolio-list">
              <a href="movie.jsp">
                <div class="th-mouse-portfolio-card">
                  <div class="thumbnail portfolio-thumbnail">
                    <img src="images/portfolio/portfolio-img1.jpg" alt="Portfolio">
                    <div class="caption portfolio-caption">
                      <p class="date">16.03.2015</p>
                      <h3 class="portfolio-title">Merit wogmonk</h3>
                      <p class="portfolio-subtitle">Branding</p>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>
          <div class="filtr-item col-md-4 col-sm-6 col-xs-12" data-category="category-2">
            <div class="portfolio-list">
              <a href="movie.jsp">
                <div class="th-mouse-portfolio-card">
                  <div class="thumbnail portfolio-thumbnail">
                    <img src="images/portfolio/portfolio-img2.jpg" alt="Portfolio">
                    <div class="caption portfolio-caption">
                      <p class="date">16.03.2015</p>
                      <h3 class="portfolio-title">Merit wogmonk</h3>
                      <p class="portfolio-subtitle">Branding</p>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>
          <div class="filtr-item col-md-4 col-sm-6 col-xs-12" data-category="category-3">
            <div class="portfolio-list">
              <a href="movie.jsp">
                <div class="th-mouse-portfolio-card">
                  <div class="thumbnail portfolio-thumbnail">
                    <img src="images/portfolio/portfolio-img3.jpg" alt="Portfolio">
                    <div class="caption portfolio-caption">
                      <p class="date">16.03.2015</p>
                      <h3 class="portfolio-title">Merit wogmonk</h3>
                      <p class="portfolio-subtitle">Branding</p>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>
          <div class="filtr-item col-md-4 col-sm-6 col-xs-12" data-category="category-1">
            <div class="portfolio-list">
              <a href="movie.jsp">
                <div class="th-mouse-portfolio-card">
                  <div class="thumbnail portfolio-thumbnail">
                    <img src="images/portfolio/portfolio-img4.jpg" alt="Portfolio">
                    <div class="caption portfolio-caption">
                      <p class="date">16.03.2015</p>
                      <h3 class="portfolio-title">Merit wogmonk</h3>
                      <p class="portfolio-subtitle">Branding</p>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>
          <div class="filtr-item col-md-4 col-sm-6 col-xs-12" data-category="category-2">
            <div class="portfolio-list">
              <a href="movie.jsp">
                <div class="th-mouse-portfolio-card">
                  <div class="thumbnail portfolio-thumbnail">
                    <img src="images/portfolio/portfolio-img5.jpg" alt="Portfolio">
                    <div class="caption portfolio-caption">
                      <p class="date">16.03.2015</p>
                      <h3 class="portfolio-title">Merit wogmonk</h3>
                      <p class="portfolio-subtitle">Branding</p>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>
          <div class="filtr-item col-md-4 col-sm-6 col-xs-12" data-category="category-3">
            <div class="portfolio-list">
              <a href="movie.jsp">
                <div class="th-mouse-portfolio-card">
                  <div class="thumbnail portfolio-thumbnail">
                    <img src="images/portfolio/portfolio-img6.jpg" alt="Portfolio">
                    <div class="caption portfolio-caption">
                      <p class="date">16.03.2015</p>
                      <h3 class="portfolio-title">Merit wogmonk</h3>
                      <p class="portfolio-subtitle">Branding</p>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

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
                                <li><a href="index.jsp.html">Home</a></li>
                                <li><a href="services.html">Services</a></li>
                                <li><a href="portfolio.html">Portfolio</a></li>
                                <li><a href="#">Our Team</a></li>
                                <li><a href="contact.html">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="text-center">
                        <div class="col-md-12">
                            <div class="copyright">
                                <p>&copy; 2013-2017 All rights reserved. <br>
                                    Design and Developed By <a href="https://themefisher.com">Themefisher.com</a></p>
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
    <!-- google map -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu5nZKbeK-WHQ70oqOWo-_4VmwOwKP9YQ"></script>
    <script src="plugins/google-map/gmap.js"></script>

    <script src="js/script.js"></script>
    </body>

    </html>
