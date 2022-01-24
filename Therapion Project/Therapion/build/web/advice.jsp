<%@include file="includes/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/advice.css">
<title>Advice - Therapion</title>
</head>
  <body>
      <div class="container">
          <div class="row">
            <div id="articles" class="col-xs-12 col-sm-12 col-md-9 mt-2 p-2">
            <h3 class="text-center">Article & Advice About Mental Health</h3>
            <div class="row d-flex justify-content-center">
                <div class="col-xs-12 col-sm-12 col-md-5 sub_articles">
                    <h4>Recent Articles</h4>
                    <p>Lorem Ipsum</p>
                    <p>Lorem Ipsum</p>
                    <p>Lorem Ipsum</p>
                    <p>Lorem Ipsum</p>
                    <p>Lorem Ipsum</p>
                    <p>Lorem Ipsum</p>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-5 sub_articles">
                    <h4>Popular Articles</h4>
                    <p>Lorem Ipsum</p>
                    <p>Lorem Ipsum</p>
                    <p>Lorem Ipsum</p>
                    <p>Lorem Ipsum</p>
                    <p>Lorem Ipsum</p>
                    <p>Lorem Ipsum</p>
                </div>
            </div>
            <div class="row sub_articles p-2">
                <h5>What is mental health?</h5>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Orci, diam a tincidunt tortor donec pharetra, aliquam eget. Faucibus ornare lectus libero, ac eget erat id. Tempus, vitae in elementum sagittis, nec, facilisis arcu.</p>
            </div>
            <div class="row sub_articles p-2">
                <h5>Mental Illness And Its Effect On Emotional Health</h5>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Orci, diam a tincidunt tortor donec pharetra, aliquam eget. Faucibus ornare lectus libero, ac eget erat id. Tempus, vitae in elementum sagittis, nec, facilisis arcu.</p>
            </div>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-2 m-2 p-2">
            <div class="row">Search topic</div>
            <div class="row" style="margin-left:30px;">
                <div class="d-flex justify-content-center">
                    <input type="text" placeholder="Search Article">
                    <button style="background: #858CE4;">
                        <img src="<%=request.getContextPath()%>/img/searchbtn.png">
                    </button>
                </div>
            </div>
        </div>
          </div>
      </div>
<%@include file="includes/footer.jsp" %>