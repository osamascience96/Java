<%@page import="services.FilmService"%>
<%@page import="models.Film"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<div class="hero-slider">
  <div class="slider-item th-fullpage hero-area" style="background-image: url(images/slider/standard_cenima.jpg);">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">Book Movies <br> Enjoy best cenimatic Ecosystem.</h1>
        </div>
      </div>
    </div>
  </div>
  <div class="slider-item th-fullpage hero-area" style="background-image: url(images/slider/gold_cenima.jpg);">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">An IMAX Experience</h1>
          <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">Everyone wants to watch their awaited movies in best experience <br> so
            Book it now.</p>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Movies
=========================-->
<section class="team">
  <div class="container-fluid padding-0">
    <!-- Team title -->
    <div class="title text-center">
      <h2>Movies</h2>
    </div>
    <%
        ArrayList<Film> films = (ArrayList<Film>) new FilmService().GetAllMovies();
    %>
    <% for(Film film : films){%>
        <div class="col-md-4 col-lg-3 padding-0">
          <div class="team-member">
            <div class="th-mouse-effect">
              <div class="team-img">
                  <img src="images/movies/<%=film.getImage()%>" style="height: 450px;" alt="movie">
              </div>
              <div class="overlay text-center">
                <div class="content">
                  <h4><%=film.getName()%></h4>
                  <span>A <strong><%=film.getDirectorName()%></strong> movie.</span>
                  <p><%=film.getDescription()%></p>
                  <% if(film.getShow() != null){ %>
                    <%
                        String link = "";
                        User userObjLogged = (User) session.getAttribute("user_session_login");
                        if(userObjLogged != null){
                            link = "BookServlet?show=".concat(String.valueOf(film.getShow().getId()));
                        }else{
                            link = "login.jsp";
                        }
                    %>
                    <a href="<%=link%>" class="btn btn-primary btn-small">Book Now</a>
                  <% } else{ %>
                    <strong>No shows available!</strong>
                  <% }%>
                </div>
                <div class="social-media">
                  <li><a href="<%=film.getTrailer()%>" target="_blank"><i class="tf-ion-social-youtube" aria-hidden="true"></i></a></li>
                </div>
              </div>
            </div>
          </div>
        </div>
    <% }%>
  </div>
</section>
  
<!-- Contact Us Sections
=========================-->
<section class="contact-call-to-action">
  <div class="shadow-block vh-center">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="block">
            <h2>Get In Touch</h2>
            <p>Any Queries? Please Contact us to know more about the shows and movies.</p>
            <a class="btn btn-default btn-main" href="contact.jsp" role="button">Contact Us</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <%@include file="includes/MapEmbedded.jsp" %>
</section>
<%@include file="includes/footer.jsp" %>
