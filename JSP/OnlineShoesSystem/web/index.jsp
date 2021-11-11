<%@include file="includes/head.jsp" %>
<link rel="stylesheet" rel="text/css" href="css/home.css">
<title>Home</title>
</head>
<body>
    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
              <img class="d-block w-100" src="img/dancingshoes.jpg" height="500" alt="First slide">
          </div>
          <div class="carousel-item">
              <img class="d-block w-100" src="img/tennisshoes.jpg" height="500" alt="Second slide">
          </div>
          <div class="carousel-item">
              <img class="d-block w-100" src="img/runningshoes.jpg" height="500" alt="Third slide">
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
    </div>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <h4>Welcome to Online Shoe Shopping</h4>
        <p>The online shoes shopping system lets you shop the all available categories. You can shop any type of shoes you want. A shoe is an item of footwear intended to protect and comfort the human foot. Shoes are also used as an item of decoration and fashion. The design of shoes has varied enormously through time and from culture to culture, with appearance originally being tied to function. Though the human foot is adapted to varied terrain and climate conditions, it is still vulnerable to environmental hazards such as sharp rocks and temperature extremes, which shoes protect against. Some shoes are worn as safety equipment, such as steel-soled boots which are required on construction sites.</p>
        <p>Additionally, fashion has often dictated many design elements, such as whether shoes have very high heels or flat ones. Contemporary footwear varies widely in style, complexity and cost. Basic sandals may consist of only a thin sole and simple strap and be sold for a low cost. High fashion shoes made by famous designers may be made of expensive materials, use complex construction and sell for hundreds or even thousands of dollars a pair. Some shoes are designed for specific purposes, such as boots designed specifically for mountaineering or skiing, while others have more generalized usage such as sneakers which have transformed from a special purpose sport shoe into a general use shoe.</p>
        <p>Traditionally, shoes have been made from leather, wood or canvas, but are increasingly made from rubber, plastics, and other petrochemical-derived materials.The shoe industry is $200 billion dollar a year industry. 90% of shoes end up in landfills, because the materials are hard to separate, recycle or otherwise reuse.</p>
    </div>
<%@include file="includes/boostrapjs.jsp" %>
<%@include file="includes/footer.jsp" %>
</body>
</html>