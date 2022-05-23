<%@include file="includes/header.jsp" %>
    <!-- end header -->
    <section class="slider_section">
       <div id="myCarousel" class="carousel slide banner-main" data-ride="carousel">
          <div class="carousel-inner">
             <div class="carousel-item active">
                <img class="first-slide" src="images/banner.jpg" alt="First slide">
                <div class="container">
                   <div class="carousel-caption relative">
                      <span>All New Phones </span>
                      <h1>up to 25% Flat Sale</h1>
                      <p>It is a long established fact that a reader will be distracted by the readable content
                         <br> of a page when looking at its layout. The point of using Lorem Ipsum is that</p>
                      <a class="buynow" href="#">Buy Now</a>

                   </div>
                </div>
             </div>
             <div class="carousel-item">
                <img class="second-slide" src="<%=request.getContextPath()%>/images/banner1.png" alt="Second slide">
                <div class="container">
                   <div class="carousel-caption relative">
                      <span>All New Phones </span>
                      <h1>up to 50% Flat Sale</h1>
                      <p>It is a long established fact that a reader will be distracted by the readable content
                         <br> of a page when looking at its layout. The point of using Lorem Ipsum is that</p>
                      <a class="buynow" href="#">Buy Now</a>

                   </div>
                </div>
             </div>

          </div>
          <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
          <i class='fa fa-angle-left'></i>
          </a>
          <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
          <i class='fa fa-angle-right'></i>
          </a>
       </div>
    </section>
<%@include file="includes/footer.jsp" %>