<%@page import="bean.Doctor"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" type="text/css" href="css/home.css">
<title>Home</title>
  </head>
  <body>
    <!-- image sliders -->
    <div id="homecarouselindicators" class="carousel slide" data-ride="carousel">
	  <ol class="carousel-indicators">
	    <li data-target="#homecarouselindicators" data-slide-to="0" class="active"></li>
	    <li data-target="#homecarouselindicators" data-slide-to="1"></li>
	    <li data-target="#homecarouselindicators" data-slide-to="2"></li>
	  </ol>
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img id="slider_img" class="d-block w-100" src="img/doctorimage1.jpg" alt="First slide">
	    </div>
	    <div class="carousel-item">
	      <img id="slider_img" class="d-block w-100" src="img/doctorimage2.jpg" alt="Second slide">
	    </div>
	    <div class="carousel-item">
	      <img id="slider_img" class="d-block w-100" src="img/doctorimage3.svg" alt="Third slide">
	    </div>
	  </div>
	  <a class="carousel-control-prev" href="#homecarouselindicators" role="button" data-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="carousel-control-next" href="#homecarouselindicators" role="button" data-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
	<%@include file="includes/navigation.jsp" %> 
    <div class="container">
    	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse vitae varius libero. Phasellus tincidunt, neque nec euismod laoreet, sem nulla malesuada diam, at dapibus leo enim sed velit. Maecenas augue magna, scelerisque nec purus ut, auctor imperdiet nisi. Maecenas posuere turpis quis sapien venenatis vestibulum. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec vitae mattis eros. Suspendisse potenti. Suspendisse pharetra lacus vitae ex placerat, eu sodales nisl rhoncus. Sed eget commodo mauris.</p>
    	<p>Aenean quis lacinia nunc. Vestibulum nec euismod magna. Vivamus finibus ipsum ac viverra faucibus. Phasellus maximus sit amet augue eget fringilla. Curabitur hendrerit, risus eget vulputate vulputate, justo purus venenatis purus, quis mattis ligula ligula ut tellus. Ut risus nisi, auctor nec eleifend hendrerit, porttitor eget massa. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam ut tellus gravida, viverra nisi non, malesuada risus. Donec vel ante condimentum, feugiat sem vel, placerat est. Morbi mattis nulla risus. Aliquam dictum ante a mi interdum, eu pellentesque enim vestibulum. Fusce nec scelerisque leo, at dictum eros.</p>
    	<p>Curabitur dignissim porttitor magna, hendrerit bibendum eros condimentum eget. Nullam sodales metus at nisi hendrerit, vel suscipit lorem fermentum. Sed nisi dolor, ullamcorper et pulvinar vel, sagittis in enim. Integer nec erat a erat sodales commodo vel in justo. Donec sed purus id sem aliquam fringilla. Proin varius tellus turpis, vel venenatis mauris malesuada et. Morbi dapibus faucibus nulla, vitae aliquam augue laoreet sagittis. Vivamus mollis sapien sit amet vulputate condimentum. Nam eu sapien in sem ultrices tempor. Ut gravida ligula vel nunc interdum convallis. Sed ut pulvinar orci. Sed sollicitudin, purus eu eleifend efficitur, erat augue dignissim sapien, id congue tortor ante eu lacus. Cras odio nunc, auctor in feugiat vitae, aliquet in tortor. Phasellus nec ligula eu nisl blandit tempus.</p>
    	<p>Pellentesque pharetra elit purus, in faucibus odio dignissim vitae. Duis viverra, eros blandit pulvinar malesuada, risus quam hendrerit mauris, vitae interdum felis nibh quis lacus. Curabitur faucibus sagittis magna, vel malesuada quam iaculis sit amet. Suspendisse efficitur ultrices vulputate. Quisque at accumsan mi. Mauris a maximus felis, vel consequat quam. Phasellus convallis sem ac augue fermentum feugiat. Phasellus sit amet congue urna. Donec posuere metus felis, eu posuere sem condimentum eu. Fusce fermentum est vitae purus ullamcorper volutpat. Nam odio risus, sagittis non pretium non, lacinia vitae lectus. Nullam congue, erat in convallis consectetur, ligula massa aliquam ligula, eget convallis ex mauris at nisl. Cras et tortor feugiat, consequat mi volutpat, sodales enim. Morbi euismod non nisi finibus faucibus.</p>
    	<p>Vivamus eu rhoncus urna. Cras eu nunc at ante mollis venenatis ut vitae lacus. Suspendisse dictum scelerisque turpis, vitae rutrum turpis feugiat nec. Etiam nulla ligula, pulvinar in molestie ac, convallis nec massa. Curabitur pretium bibendum diam, vel congue quam ultrices ac. Etiam tincidunt imperdiet viverra. Curabitur in iaculis lacus. Cras id vestibulum turpis. Vestibulum consequat non dolor non lacinia. Vestibulum commodo ultrices est, a hendrerit lectus dignissim at. Vivamus vitae nisi et nulla iaculis tristique.</p>
    </div>
    <%@include file="includes/bootstrap.jsp" %>
    <%@include file="includes/footer.jsp" %>
  </body>
</html>