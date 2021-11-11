<%@page import="com.pojo.Product"%>
<%@include file="includes/header.jsp" %>
<main>
    <div class="slider-area ">
        <div class="single-slider slider-height2 d-flex align-items-center">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2> Product Details</h2>
                            <p>Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passt? Der Lipstick Finder findet Deine perfekte Shade und Textur. Für jeden Hautton!</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Hero Area End-->


    <!--================Single Product Area =================-->



     <%
         // Initialisieren Sie das Produktobjekt aus der Sitzung
        Product productObj = (Product) session.getAttribute("product_data");
    %>
    <%
        // wenn das Produktobjekt nicht null ist
        if(productObj != null){
    %>
    <div class="product_image_area">
        <div class="container">
            <div class="row ">
                <div class="col-sm-6">
                    <section id="default" class="padding-top0">
                        <div class="row">                      
                            <div class="large-5 column">
                                <div class="xzoom-container">
                                    
                                                                                        <img class="xzoom" id="xzoom-default" src="files/product_image/<%=productObj.GetImageName()%>" xoriginal="files/product_image/<%=productObj.GetImageName()%>" width="500"/>
                                                
                                        <div class="xzoom-thumbs">
                                                                                            <a href="files/product_image/<%=productObj.GetImageName()%>"><img class="xzoom-gallery" width="80" src="files/product_image/<%=productObj.GetImageName()%>" title=""></a>
                                                                                    </div>
                                                                    </div>        
                            </div>
                            <div class="large-7 column"></div>
                        </div>
                    </section>
                </div>
                <div class="col-sm-6">
                    <div class="single_product_text ">
                        <div class="ccheck-out">
                            <h2 class="p-title"><%=productObj.GetName()%></h2>
                            <h3 class="p-price">$<%=productObj.GetPrice()%></h3> 
                            <div>
                                <span>Select weight: </span>
                                <div class="custom-control custom-radio custom-control-inline mb-4">
                                    <input type="radio" class="custom-control-input" id="customRadio1" value="3" name="weight" checked>
                                    <label class="custom-control-label" for="customRadio1">3gm</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <input type="radio" class="custom-control-input" id="customRadio2" value="5" name="weight">
                                    <label class="custom-control-label" for="customRadio2">5gm</label>
                                </div>
                            </div>
                            <a id="cart-link" href="cart_servlet?product_id=<%=productObj.GetId()%>"><i class="fa fa-shopping-cart"></i> Add to cart</a>
                            <a id="wishlist-link" href="wish_servlet?product_id=<%=productObj.GetId()%>"><i class="fa fa-heart"></i> Add to wishlist</a>
                        </div>
                        <div class="profile-content">

                            <h3>DETAILS</h3>
                            <div class="tab-content mt-4" style="width: 100%;">
                                <p><%=productObj.GetDescription()%></p>
                            </div>
                        </div>                        
                    </div>
                </div>
            <%}else{
                // Leiten Sie den Benutzer zum Produktservlet weiter
                response.sendRedirect("product_servlet");
            }%>
        </div>
        </div>
    </div>


</main>

<script src='../../../unpkg.com/xzoom%401.0.14/dist/xzoom.min.js'></script>
<script src='../../../hammerjs.github.io/dist/hammer.min.js'></script>
<script src='../../../cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/js/foundation.min.js'></script>

<script type="text/javascript">

    $('input[type=radio][name=weight]').change(function () {
        if (this.value == 3) {
            $("#cart-link").removeAttr('href');
            $("#wishlist-link").removeAttr('href');
            $("#cart-link").attr('href', '../index.html');
            $("#wishlist-link").attr('href', '../login0ccc.html');
        } else if (this.value == 5) {
            $("#cart-link").removeAttr('href');
            $("#wishlist-link").removeAttr('href');
            $("#cart-link").attr('href', '../index.html');
            $("#wishlist-link").attr('href', '../login2e94.html');
        }
    });

    (function ($) {
        $(document).ready(function () {



            $('.xzoom, .xzoom-gallery').xzoom({zoomWidth: 400, title: true, tint: '#333', Xoffset: 15});
            $('.xzoom2, .xzoom-gallery2').xzoom({position: '#xzoom2-id', tint: '#ffa200'});
            $('.xzoom3, .xzoom-gallery3').xzoom({position: 'lens', lensShape: 'circle', sourceClass: 'xzoom-hidden'});
            $('.xzoom4, .xzoom-gallery4').xzoom({tint: '#006699', Xoffset: 15});
            $('.xzoom5, .xzoom-gallery5').xzoom({tint: '#006699', Xoffset: 15});

            //Integration with hammer.js
            var isTouchSupported = 'ontouchstart' in window;

            if (isTouchSupported) {
                //If touch device
                $('.xzoom, .xzoom2, .xzoom3, .xzoom4, .xzoom5').each(function () {
                    var xzoom = $(this).data('xzoom');
                    xzoom.eventunbind();
                });

                $('.xzoom, .xzoom2, .xzoom3').each(function () {
                    var xzoom = $(this).data('xzoom');
                    $(this).hammer().on("tap", function (event) {
                        event.pageX = event.gesture.center.pageX;
                        event.pageY = event.gesture.center.pageY;
                        var s = 1, ls;

                        xzoom.eventmove = function (element) {
                            element.hammer().on('drag', function (event) {
                                event.pageX = event.gesture.center.pageX;
                                event.pageY = event.gesture.center.pageY;
                                xzoom.movezoom(event);
                                event.gesture.preventDefault();
                            });
                        }

                        xzoom.eventleave = function (element) {
                            element.hammer().on('tap', function (event) {
                                xzoom.closezoom();
                            });
                        }
                        xzoom.openzoom(event);
                    });
                });

                $('.xzoom4').each(function () {
                    var xzoom = $(this).data('xzoom');
                    $(this).hammer().on("tap", function (event) {
                        event.pageX = event.gesture.center.pageX;
                        event.pageY = event.gesture.center.pageY;
                        var s = 1, ls;

                        xzoom.eventmove = function (element) {
                            element.hammer().on('drag', function (event) {
                                event.pageX = event.gesture.center.pageX;
                                event.pageY = event.gesture.center.pageY;
                                xzoom.movezoom(event);
                                event.gesture.preventDefault();
                            });
                        }

                        var counter = 0;
                        xzoom.eventclick = function (element) {
                            element.hammer().on('tap', function () {
                                counter++;
                                if (counter == 1)
                                    setTimeout(openfancy, 300);
                                event.gesture.preventDefault();
                            });
                        }

                        function openfancy() {
                            if (counter == 2) {
                                xzoom.closezoom();
                                $.fancybox.open(xzoom.gallery().cgallery);
                            } else {
                                xzoom.closezoom();
                            }
                            counter = 0;
                        }
                        xzoom.openzoom(event);
                    });
                });

                $('.xzoom5').each(function () {
                    var xzoom = $(this).data('xzoom');
                    $(this).hammer().on("tap", function (event) {
                        event.pageX = event.gesture.center.pageX;
                        event.pageY = event.gesture.center.pageY;
                        var s = 1, ls;

                        xzoom.eventmove = function (element) {
                            element.hammer().on('drag', function (event) {
                                event.pageX = event.gesture.center.pageX;
                                event.pageY = event.gesture.center.pageY;
                                xzoom.movezoom(event);
                                event.gesture.preventDefault();
                            });
                        }

                        var counter = 0;
                        xzoom.eventclick = function (element) {
                            element.hammer().on('tap', function () {
                                counter++;
                                if (counter == 1)
                                    setTimeout(openmagnific, 300);
                                event.gesture.preventDefault();
                            });
                        }

                        function openmagnific() {
                            if (counter == 2) {
                                xzoom.closezoom();
                                var gallery = xzoom.gallery().cgallery;
                                var i, images = new Array();
                                for (i in gallery) {
                                    images[i] = {src: gallery[i]};
                                }
                                $.magnificPopup.open({items: images, type: 'image', gallery: {enabled: true}});
                            } else {
                                xzoom.closezoom();
                            }
                            counter = 0;
                        }
                        xzoom.openzoom(event);
                    });
                });

            } else {
                //If not touch device

                //Integration with fancybox plugin
                $('#xzoom-fancy').bind('click', function (event) {
                    var xzoom = $(this).data('xzoom');
                    xzoom.closezoom();
                    $.fancybox.open(xzoom.gallery().cgallery, {padding: 0, helpers: {overlay: {locked: false}}});
                    event.preventDefault();
                });

                //Integration with magnific popup plugin
                $('#xzoom-magnific').bind('click', function (event) {
                    var xzoom = $(this).data('xzoom');
                    xzoom.closezoom();
                    var gallery = xzoom.gallery().cgallery;
                    var i, images = new Array();
                    for (i in gallery) {
                        images[i] = {src: gallery[i]};
                    }
                    $.magnificPopup.open({items: images, type: 'image', gallery: {enabled: true}});
                    event.preventDefault();
                });
            }
        });
    })(jQuery);
</script>
<%@include file="includes/footer.jsp" %>