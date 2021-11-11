<%@include file="includes/head.jsp" %>
<link rel="stylesheet" href="css/home.css">
<title>Home</title>
</head>
<body>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
              <img class="d-block w-100" height="700" src="img/fooditem.jpg" alt="First slide">
              <div class="carousel-caption d-none d-md-block text-primary">
                <h2>Food Court</h2>
                <h5>Find and Explore the finest Quality Product</h5>
              </div>
          </div>
          <div class="carousel-item">
              <img class="d-block w-100" height="700" src="img/clothes.jpg" alt="Second slide">
              <div class="carousel-caption d-none d-md-block text-info">
                <h5>Mens and Women Wears</h5>
                <p>Take the fashion to the most next and decent level</p>
              </div>
          </div>
          <div class="carousel-item">
              <img class="d-block w-100" height="700" src="img/tech.jpg" alt="Third slide">
              <div class="carousel-caption d-none d-md-block text-white">
                <h5>Tech Hub</h5>
                <p>Take best Quality Tech Products</p>
              </div>
          </div>
          <div class="carousel-item">
              <img class="d-block w-100" height="700" src="img/toys.jpg" alt="Fourth slide">
              <div class="carousel-caption d-none d-md-block text-info">
                <h5>Toys Spot</h5>
                <p>Take most fun and engaging toys</p>
              </div>
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
        <h3>Inventory System</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam lacinia libero metus, ac vestibulum tortor suscipit eget. Nunc ipsum lacus, varius vitae ligula at, ultricies lacinia eros. Mauris ac urna scelerisque, volutpat lacus nec, semper neque. Aliquam ornare lacus at dui eleifend cursus. Vivamus malesuada sapien in risus tempus venenatis. In dictum sodales nunc in cursus. Fusce consequat ipsum at dolor vestibulum, sed mollis eros vehicula. Proin consectetur, velit ac ullamcorper pretium, magna leo lobortis dui, vitae congue justo ex ut nisl. Nulla mi risus, dignissim sed tincidunt quis, commodo nec elit. Praesent mollis eu felis vitae elementum. Sed in nibh neque. Nulla facilisi. Proin eget lectus mauris. Praesent dignissim posuere arcu, sit amet dignissim felis dignissim id.</p>
        <p>Sed sagittis nibh non lorem tempus ullamcorper. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus fringilla, sapien at blandit auctor, est tortor malesuada magna, sit amet vulputate leo nulla quis velit. Morbi nec scelerisque risus. Donec ullamcorper porttitor eros nec fermentum. Mauris interdum felis justo, vitae interdum diam faucibus ut. Fusce vitae purus velit. Aenean et imperdiet augue. Ut scelerisque sapien non eros posuere feugiat. Nunc porttitor velit id erat viverra, sit amet tincidunt lacus tempus. Aliquam sit amet nunc vel nulla porttitor viverra sollicitudin eu quam.</p>
        <p>Nunc semper augue et rhoncus pharetra. Suspendisse fermentum ullamcorper scelerisque. Etiam tincidunt a sapien nec lobortis. Ut luctus risus posuere metus varius aliquet. In est velit, laoreet eget tempus at, accumsan id ex. Nullam sed viverra sem, vel viverra tortor. Aenean nec pharetra nisl. Quisque in arcu posuere, ultrices justo eu, consequat mauris. Morbi sit amet neque dictum, fermentum augue sit amet, tempus nisl. Ut in suscipit arcu. Maecenas finibus finibus ipsum, eget dapibus ligula laoreet a. Quisque laoreet ipsum mauris, quis aliquam ipsum euismod vel. Aliquam leo enim, venenatis sit amet luctus in, auctor ultrices risus.</p>
        <p>Fusce condimentum finibus ligula ut tincidunt. In sed purus in urna egestas scelerisque at a velit. Quisque euismod dolor et viverra iaculis. Donec sit amet metus arcu. Cras a leo purus. Curabitur vel nulla ac erat pellentesque euismod bibendum a sapien. Donec quis odio eget leo tincidunt lacinia at vel mi. Praesent ac lobortis justo.</p>
        <p>Mauris hendrerit orci aliquam ex posuere hendrerit. Ut nec risus eu nulla porta bibendum. Quisque porttitor placerat erat, quis faucibus tellus facilisis ac. Integer eget nunc dictum, aliquam mauris quis, elementum risus. Ut interdum egestas scelerisque. Proin non semper dui. Curabitur posuere tincidunt urna sed egestas. Suspendisse tincidunt nisi id ligula consectetur, id elementum justo faucibus. Praesent mauris nunc, accumsan sed turpis id, ultrices auctor enim.</p>
    </div>
<%@include file="includes/boostrapJS.jsp" %>
</body>
</html>