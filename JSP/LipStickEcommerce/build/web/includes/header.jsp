<!doctype html>
<html class="no-js" lang="zxx">
    
<!-- Mirrored from php.fitnessinfy.com/ecommerce/ by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 04 Mar 2021 13:44:22 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
        <meta charset="utf-8">
        <title>eCommers</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <!-- CSS here -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="../../cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <!-- jQuery library -->
        <script src="assets/js/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="../../cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="assets/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    </head>

    <body>


        <style>
    .head-login {
        position: relative;
        -webkit-transition: all .2s ease 0s;
        -moz-transition: all .2s ease 0s;
        -ms-transition: all .2s ease 0s;
        -o-transition: all .2s ease 0s;
        transition: all .2s ease 0s;
    }

    .head-login ul li {
        display: inline-block;
        width: 100%;
        color: #333;
    }
    .head-login ul li a {
        border: none;
        padding: 0;
        font-size: 15px;
        background: #ccc;
        border-radius: 0;
        padding: 4px;
        width: 100%;
    }
    li.head-login ul {
        position: absolute;
        background: #e4e4e4;
        text-align: left;
        z-index: 11111;
        top: 41px;
        visibility: hidden;
        max-height: 0px;
        opacity: 1;
        transition: 500ms all ease-in-out 0s;
        -webkit-transition: all .2s ease 0s;
        -moz-transition: all .2s ease 0s;
        -ms-transition: all .2s ease 0s;
        -o-transition: all .2s ease 0s;
        transition: all .2s ease 0s;
    }

    li.head-login:hover ul{
        visibility: visible;
        opacity: 1;
        -webkit-transition: all .2s ease 0s;
        -moz-transition: all .2s ease 0s;
        -ms-transition: all .2s ease 0s;
        -o-transition: all .2s ease 0s;
        transition: all .2s ease 0s;
    }

</style>

<header>
    <!-- Header Start -->
    <div class="header-area">
        <div class="main-header header-sticky">
            <div class="container-fuild">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="logo">
                            <a href="index.jsp"><h2>Luxus Lippenstifte</h2></a>
                        </div>
                    </div>
                    <!-- Main-menu -->
                    <div class="col-sm-8">
                        <div class="main-menu  d-lg-block">
                            <input id="menu-toggle" type="checkbox" />
                            <label class='menu-button-container' for="menu-toggle">
                                <div class='menu-button'></div>
                            </label>                                     
                            <ul id="navigation " class="menu">
                                <li><a href="index.jsp">Zuhause</a></li> 
                                <li><a href="product_servlet">Produkt</a></li> 
                                <li><a href="cart.jsp">Wagen</a></li>
                            </ul>

                        </div>

                        <div class="header-right">
                            <ul>
                                <li class="head-login">
                                    <% if(session.getAttribute("userObj") != null){%>
                                        <a href="logout_servlet"> <i class="fa fa-user"></i> Ausloggen</a> </li>
                                    <% }else{%>
                                        <a href="login.jsp"> <i class="fa fa-user"></i> Anmeldung</a> </li>
                                    <% }%>

                                <li><a href="wish_servlet?redir=view">
                                        <i class="fa fa-heart"></i> Wunschzettel                                        
                                    </a>
                                </li>


                                <li><a href="cart_servlet?redir=view">
                                        <svg aria-hidden="true" focusable="false" data-prefix="fal" data-icon="shopping-cart" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" class="svg-inline--fa fa-shopping-cart fa-w-18 fa-7x"><path fill="currentColor" d="M551.991 64H129.28l-8.329-44.423C118.822 8.226 108.911 0 97.362 0H12C5.373 0 0 5.373 0 12v8c0 6.627 5.373 12 12 12h78.72l69.927 372.946C150.305 416.314 144 431.42 144 448c0 35.346 28.654 64 64 64s64-28.654 64-64a63.681 63.681 0 0 0-8.583-32h145.167a63.681 63.681 0 0 0-8.583 32c0 35.346 28.654 64 64 64 35.346 0 64-28.654 64-64 0-17.993-7.435-34.24-19.388-45.868C506.022 391.891 496.76 384 485.328 384H189.28l-12-64h331.381c11.368 0 21.177-7.976 23.496-19.105l43.331-208C578.592 77.991 567.215 64 551.991 64zM240 448c0 17.645-14.355 32-32 32s-32-14.355-32-32 14.355-32 32-32 32 14.355 32 32zm224 32c-17.645 0-32-14.355-32-32s14.355-32 32-32 32 14.355 32 32-14.355 32-32 32zm38.156-192H171.28l-36-192h406.876l-40 192z" class=""></path></svg>Wagen
                                                                            </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- Header End -->
</header>