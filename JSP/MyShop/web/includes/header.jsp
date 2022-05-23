<!DOCTYPE html>
<html lang="en">

<head>
    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>MyShop</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- bootstrap css -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
    <!-- style css -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- Responsive-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/responsive.css">
    <!-- fevicon -->
    <link rel="icon" href="<%=request.getContextPath()%>/images/fevicon.png" type="image/gif" />
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.mCustomScrollbar.min.css">
    <!-- Tweaks for older IEs-->
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <!-- owl stylesheets -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!-- body -->

<body class="main-layout ">
    <!-- loader  -->
    <div class="loader_bg">
        <div class="loader"><img src="<%=request.getContextPath()%>/images/loading.gif" alt="#" /></div>
    </div>
    <!-- end loader -->
    <!-- header -->
    <header>
        <!-- header inner -->
        <div class="header">

            <div class="container">
                <div class="row">
                    <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                        <div class="full">
                            <div class="center-desk">
                                <div class="logo">
                                    <a href="<%=request.getContextPath()%>"><img src="<%=request.getContextPath()%>/images/logo.png" alt="#"></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                        <div class="menu-area">
                            <div class="limit-box">
                                <nav class="main-menu">
                                    <ul class="menu-area-main">
                                        <li class="active"> <a href="<%=request.getContextPath()%>">Home</a> </li>
                                        <li> <a href="<%=request.getContextPath()%>/about.jsp">About</a> </li>
                                        <li><a href="<%=request.getContextPath()%>/brand.jsp">Brand</a></li>
                                        <li><a href="<%=request.getContextPath()%>/special.jsp">Specials</a></li>
                                        <li><a href="<%=request.getContextPath()%>/contact.jsp">Contact Us</a></li>
                                        <li class="last">
                                            <a href="#"><img src="<%=request.getContextPath()%>/images/search_icon.png" alt="icon" /></a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 offset-md-6">
                        <div class="location_icon_bottum">
                            <ul>
                                <li><img src="<%=request.getContextPath()%>/icon/call.png" />(+1)555666333</li>
                                <li><img src="<%=request.getContextPath()%>/icon/email.png" />osamahu96@gmail.com</li>
                                <li><img src="<%=request.getContextPath()%>/icon/loc.png" />Location</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end header inner -->
    </header>