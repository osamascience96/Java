<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Home</title>
  </head>
  <body>
  	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
	  <ol class="carousel-indicators">
	    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	  </ol>
	  <div class="carousel-inner" style="height:600px;">
	    <div class="carousel-item active">
	      <img class="d-block w-100" src="img/main.jpg" alt="First slide">
	    </div>
	    <div class="carousel-item">
	      <img class="d-block w-100" src="img/main2.jpg" alt="Second slide">
	    </div>
	    <div class="carousel-item">
	      <img class="d-block w-100" src="img/main3.jpg" alt="Third slide">
	    </div>
	  </div>
	  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
	<%@include file="includes/navigation.jsp" %>
	<div class="container">
		<h2>Welcome to New Delhi Online Bookstore</h2>
		<p>The library was established on 27 October 1951 as a pilot project sponsored by UNESCO and the Government of India. The library project dates back to 1944, when Shri Ramkrishna Dalmia donated most of the amount required to construct a library building at the request of Gen. Sir Claude Auchinleck. In February 1950 the Indian government and UNESCO agreed to initiate the project, and the library was officially opened on 27 October 1951, by then Prime minister Jawaharlal Nehru. The library buildings were acquired between 1951 and 1953, with operations formally transferred from UNESCO to the Indian Government in 1955. The library provides training facilities to student librarians and social education workers from its early days.</p>
		<p>The library has been expanding its services as a centre for the dissemination of knowledge, information and culture. It is increasingly felt that the library should not merely serve as a centre for lending books, but should also grow as a robust organization devoted to promote intellectual pursuits and create community rapport among its readers.</p>
	</div>
	<footer class="bg-dark text-white text-center" style="padding:10px;">
		<h5>Courtesy: New Delhi Library India.</h5>
	</footer>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <%@include file="modal/login.jsp" %>
    <%@include file="modal/logout.jsp" %>
    <script src="js/home.js"></script>
  </body>
</html>