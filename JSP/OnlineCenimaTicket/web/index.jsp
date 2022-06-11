<%@page import="services.FilmService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="models.Film"%>
<%@include file="includes/header.jsp" %>
 <!-- Hero Area -section
  =========================-->
  <header class="hero-area th-fullpage" data-parallax="scroll" data-image-src="images/slider/bg-cenima.jpg">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1>Code Cenima <br>
            Enjoy your Movies</h1>
        </div>
      </div>
    </div>
  </header>

 <!-- Case Study Sections
  =========================-->

  <section class="case-study">
    <div class="text-center">
      <h2 class="title">Case Study</h2>
    </div>
    <!-- Case Study Description
      top section -->
    <div class="case-study-content">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <!-- inner sub-title -->
            <div class="content">
              <h4 class="inner-title">Inclusive Screening Case Study</h4>
              <p class="case-description">Independent cinemas, film clubs and societies, and multi-arts venues have produced some of the most exciting cinema events, engaging with audiences across the broadest spectrum of the UK public. From R&D projects, piloting screenings for children with multi-sensory needs, to symposiums on LGBTQ+ film, to festivals raising awareness about living well with dementia, to film clubs led by Black, Asian and minority ethnic d/Deaf audiences, much of the Film Audience Network's membership - large and small - have been bringing valuable film experiences and a slice of normal life to all people, whatever their protected characteristics.</p>
            </div>
          </div>
          <div class="col-md-6">
            <div class="img-content">
                <img class="img-responsive" src="images/case-study/case_study_img_3.jpg" style="height: 400px;">
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  

<!-- CEO Message
=========================-->
<section class="clients" data-parallax="scroll" data-image-src="images/slider/bg-3.jpg">
  <div class="section">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-12">
          <div class="title text-center">
            <h2>Code Creator</h2>
          </div>
          <div class="col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2 padding-0 slider-main">
            <div class="testimonial-slider">
              <div class="item">
                <!-- Slider item -->
                <!-- <div class="col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2 padding-0"> -->
                <div class="testimonials-area">
                  <!-- <div class="round-shape"></div> -->
                  <p class="testimonials-description">
                      We have build the Code Cenima to provide best experience to the people, who are looking to enjoy their upcoming movies. 
                      We believe that good ecosystem of the cenima produces more power to the movie excitement and brings more joy to the people. 
                      It is a place where, people get together with their friends and family and gets to enjoy a time of their life. Welcome, to <strong>Code Cenima</strong>.
                  </p>
                  <div class="author">
                    <img src="images/clients-img1.png" alt="Clients">
                    <h3 class="author-name">Paul Lapkin</h3>
                    <span class="designation">CEO at Code Cenima</span>
                  </div>
                </div>
                <!-- </div> -->
                <!-- End Slider item -->
              </div>
              <div class="item">
                <!-- Slider item -->
                <!-- <div class="col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2 padding-0"> -->
                <div class="testimonials-area">
                  <!-- <div class="round-shape"></div> -->
                  <p class="testimonials-description">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed
                    diam nonummy nibh euismod tincidunt ut laoreet dolore magna. ipsum dolor sit amet, consectetuer
                    adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
                    volutpat. Ut wisi enim ad minim veniam. Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                    Nemo vitae natus odio quasi recusandae, esse! Libero ipsum cum aliquid, nisi, maiores animi iste
                    vel consectetur error facilis quae ducimus .
                  </p>
                  <div class="author">
                    <img src="images/clients-img1.png" alt="Clients">
                    <h3 class="author-name">Paul Lapkin</h3>
                    <span class="designation">CEO at DeviserWeb</span>
                  </div>
                </div>
                <!-- </div> -->
                <!-- End Slider item -->
              </div>
            </div>
          </div>
        </div>
      </div><!-- /.End row -->
    </div>
  </div>
</section>


<!-- top 4 shows today
=========================-->
<section class="team">
    <div class="container-fluid padding-0">
        <!-- movies -->
        <div class="title text-center">
          <h2>Upcoming Movies</h2>
        </div>
        <!-- upcoming movies iteration -->
        <%
            ArrayList<Film> films = (ArrayList<Film>) new FilmService().GetComingMovies();
        %>
        <div class="row g-3">
            <% for(Film film : films){ %>
                <div class="col-md-4 col-lg-3 padding-0">
                  <div class="team-member">
                    <div class="th-mouse-effect">
                      <div class="team-img">
                          <img src="images/movies/<%=film.getImage()%>" style="height: 500px;" alt="Team img">
                      </div>
                      <div class="overlay text-center">
                        <div class="content">
                          <h4><%=film.getName()%></h4>
                          <span>A <strong><%=film.getDirectorName()%></strong> movie.</span>
                          <p><%=film.getDescription()%></p>
                          <a href="#" class="btn btn-primary btn-small">Book Now</a>
                        </div>
                        <div class="social-media">
                          <li><a href="<%=film.getTrailer()%>" target="_blank"><i class="tf-ion-social-youtube" aria-hidden="true"></i></a></li>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
            <% } %>
        </div>
    </div>
</section>

<!-- Footer Section -->
<%@include file="includes/footer.jsp" %>