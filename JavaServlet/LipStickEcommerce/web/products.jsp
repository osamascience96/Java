<%@page import="java.util.ArrayList"%>
<%@page import="com.pojo.Product"%>
<%@include file="includes/header.jsp" %>
<main>
    <!-- Hero Area Start-->
    <div class="slider-area ">
        <div class="single-slider slider-height2 d-flex align-items-center">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>LIP PENFARB FINDER</h2>
                            <p>Du bist auf der Suche nach der Lippenstiftfarbe, die perfekt zu Dir passt? Der Lipstick Finder findet Deine perfekte Shade und Textur. FÃ¼r jeden Hautton!</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Hero Area End-->
    
    <div class="gallery-box">
        <div class="container">
            <div class="row">
                <div align="center" class="tab-box row"  style="width: 100%;">
                    <div class="col-sm-4">
                        <form>
                            <input type="hidden" id="skintone" name="skin_type">
                            <input type="hidden" id="lipcolor" name="color_type">
                            <input type="hidden" id="finish" name="type">
                        </form>
                        <h3>NACH HAUTTON SORTIEREN:</h3>
                        <button class="tab-0nav btn-default filter-btn active" data-filter="bright" onclick="window.location.replace('product_servlet?skin_type_filter=bright')">Bright</button>
                        <button class="tab-0nav btn-default filter-btn" data-filter="medium" onclick="window.location.replace('product_servlet?skin_type_filter=medium')">Medium</button>
                        <button class="tab-0nav btn-default filter-btn" data-filter="dark" onclick="window.location.replace('product_servlet?skin_type_filter=dark')">Dark</button>

                    </div>
                    <div class="col-sm-4">
                        <h3>NACH FINISH FILTERN:</h3>
                        <button class="tab-0nav btn-default filter-button" data-filter="matt" onclick="window.location.replace('product_servlet?type=matt')">MATT</button>
                        <button class=" tab-0nav btn-default filter-button" data-filter="cream" onclick="window.location.replace('product_servlet?type=cream')">CREAM</button>
                        <button class="tab-0nav btn-default filter-button" data-filter="schimmer" onclick="window.location.replace('product_servlet?type=schimmer')">SCHIMMER</button>
                    </div>
                    <div class="col-sm-3 ">
                        <h3>NACH FARBE FILTERN:</h3>
                        <button class=" tab-0nav btn-default filter-btn" data-filter="pink" onclick="window.location.replace('product_servlet?color_type=pink')">Pink</button>
                        <button class="tab-0nav btn-default filter-btn" data-filter="red" onclick="window.location.replace('product_servlet?color_type=red')">Red</button>
                        <button class="tab-0nav btn-default filter-btn" data-filter="nude" onclick="window.location.replace('product_servlet?color_type=nude')">Nude</button>
                    </div>
                    <div class="col-sm-1">
                        <button class="tab-0nav btn-default filter-btn clerdksg mt-4" data-filter="clear" onclick="window.location.replace('product_servlet')">clear</button>
                    </div>                    
                </div>
                <!-- Festlegen der Produkt-Array-Liste-->
                    <%
                        // Initialisieren Sie die productArraylist aus der initiierten Sitzung
                        ArrayList<Product> productsArrayList = (ArrayList<Product>) session.getAttribute("product_list");
                    %>
                    <% if(productsArrayList != null){%>
                        <!-- Durchlaufen Sie die Liste, um die Daten zu replizieren-->
                        <% for(int i = 0; i < productsArrayList.size(); i++){%>
                            <div class="gallery_product  filter hdpe all">
                                <a href="product_user_servlet?product_template_id=<%=productsArrayList.get(i).GetId()%>">
                                    <img class="img-responsive"  src="files/product_image/<%=productsArrayList.get(i).GetImageName()%>"/>
                                    <div class="show-hover">
                                        <span><%=productsArrayList.get(i).GetName()%></span>                                          
                                    </div>
                                </a>
                            </div>
                        <%}%>
                    <%}else{
                        // Leiten Sie den Benutzer zum Produktservlet weiter
                        response.sendRedirect("product_servlet");
                    }%>
            </div>
        </div>
    </div>
</main>

<script type="text/javascript">
    /*$(document).ready(function () {
     
     $(".filter-btn").click(function () {
     var value = $(this).attr('data-filter');
     
     if (value == "all")
     {
     //$('.filter').removeClass('hidden');
     $('.filter').show('1000');
     } else
     {
     //            $('.filter[filter-item="'+value+'"]').removeClass('hidden');
     //            $(".filter").not('.filter[filter-item="'+value+'"]').addClass('hidden');
     $(".filter").not('.' + value).hide('3000');
     $('.filter').filter('.' + value).show('3000');
     
     }
     });
     
     if ($(".filter-btn").removeClass("active")) {
     $(this).removeClass("active");
     }
     $(this).addClass("active");
     
     });*/

    function getImages() {
        jQuery.ajax({
            type: 'POST',
            data: {skincolor: $('#skintone').val(), lipcolor: $('#lipcolor').val(), finish: $('#finish').val()},
            dataType: 'html',
            beforeSend: function (xhr) {
                xhr.setRequestHeader('X-CSRF-Token',"74f72b80aa39d989bc34ca4a2b6a1a0a2db1bd2ae328cbf36e3ebaa06ff616b319c75659a525d4cde8e493ae38c48713bf77c0edbefb0868d861cac5f2fd3ec8");
            },
            url: 'http://php.fitnessinfy.com/ecommerce/users/getfilterdata',
        }).done(function (res) {
            $('#all_images').html(res);

        }).fail(function () {
            alert('Error found. Try again..');
            return false;
        });
    }
</script>

<script>
    
</script>

<%@include file="includes/modals/basic_message.html" %>
<%@include file="includes/footer.jsp" %>

<script>
    <%
        // wenn die Antwort nicht eingestellt ist
        if(request.getParameter("response") != null){
    %>
        <%
            // wenn die Wunschliste hinzugefügt wird
            if(request.getParameter("response").compareToIgnoreCase("wish_list_added") == 0){
        %>
            document.getElementById('response_message').innerHTML = "Your Product Added to the WishList Successfully";
            $("#response_modal_basic").modal("show");
        <%}else if(request.getParameter("response").compareToIgnoreCase("cart_added") == 0){%>
            document.getElementById('response_message').innerHTML = "Your Product Added to the Cart Successfully";
            $("#response_modal_basic").modal("show");
        <%}%>
    <% }%>
</script>