<%@include file="includes/header.jsp" %>
<main>
    <section class="banner-box">
        <img src="assets/images/banner.jpg">
    </section>
    <div class="grid__item">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="border-title ">
                        <h5 class="small-title" >Verschiedene Farbtöne</h5> 
                        <h2 >Für jeden Anlass</h2>
                        <div class="tilte_img">
                            <img src="assets/images/title_img_69x23.html" alt="" title="">
                        </div>  
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="icon-img-wrapper" style="visibility: visible;">            
                        <div class="icon-img">
                            <img src="assets/images/img4_b548434e-63f5-4030-a237-3a6bc5b4bfe7_1024x1024.webp" alt="" title="" style=""> 
                        </div>
                        <h4 style="color:Rich Matte Lipstick;">Reichhaltiger matter Lippenstift</h4>
                        <p>Es wurde in den 1960er Jahren mit der Veröffentlichung von Letraset-Blättern mit Lorem Ipsum-Passagen und in jüngerer Zeit mit Donec lorem risus populär gemacht</p>

                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="icon-img-wrapper" style="visibility: visible;">            
                        <div class="icon-img">
                            <img src="assets/images/img4_b548434e-63f5-4030-a237-3a6bc5b4bfe7_1024x1024.webp" alt="" title="" style=""> 
                        </div>
                        <h4 style="color:Rich Matte Lipstick;">Reichhaltiger matter Lippenstift</h4>
                        <p>Es wurde in den 1960er Jahren mit der Veröffentlichung von Letraset-Blättern mit Lorem Ipsum-Passagen und in jüngerer Zeit mit Donec lorem risus populär gemacht</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="icon-img-wrapper" style="visibility: visible;">            
                        <div class="icon-img">
                            <img src="assets/images/img4_b548434e-63f5-4030-a237-3a6bc5b4bfe7_1024x1024.webp" alt="" title="" style=""> 
                        </div>
                        <h4 style="color:Rich Matte Lipstick;">Reichhaltiger matter Lippenstift</h4>
                        <p>Es wurde in den 1960er Jahren mit der Veröffentlichung von Letraset-Blättern mit Lorem Ipsum-Passagen und in jüngerer Zeit mit Donec lorem risus populär gemacht</p>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="higlt-product">
        <div class="container">
            <div class="row">
                <div class="col-sm-7">
                    <div class="img-hover-effect-1 img-hover-effect"> 
                        <img src="assets/images/banner1_a887568a-d8e0-41bc-b12f-60b299d1e886.webp" alt="">
                    </div> 
                </div>
                <div class="col-sm-5">
                    <div class="img-hover-effect-2 img-hover-effect">
                        <img src="assets/images/banner2_ab7feea9-4311-49e9-bd7e-c3b4068000eb.webp" alt="">
                    </div>
                </div>
                <!-- <div class="col-sm-6">
                    <div class="img-hover-effect-2 img-hover-effect">
                        <img src="assets/images/banner3.jpg" alt="">
                    </div>
                </div>
                <div class="col-sm-6">
                   <div class="img-hover-effect-1 img-hover-effect"> 
                        <img src="assets/images/banner4.jpg" alt="">
                    </div> 
                </div> -->
            </div>
        </div>
    </div>
</main>        
<%@include file="includes/modals/basic_message.html" %>
<%@include file="includes/footer.jsp" %>

<script>
    <%
        // Überprüfen, ob der Antwortparameter eingestellt ist
        if(request.getParameter("response") != null){
    %>
        <%
            // Überprüfen, ob das Einfügen erfolgreich ist
            if(request.getParameter("response").compareToIgnoreCase("insert_success") == 0){
        %>
            document.getElementById('response_message').innerHTML = "Registration Successful! You got free 500 euros to use. Login to your account to enjoy the services. Thank You. Have a nice day.";
            $("#response_modal_basic").modal("show");
        <% }else if(request.getParameter("response").compareToIgnoreCase("login_successful") == 0){%>
            document.getElementById('response_message').innerHTML = "Login Successful! You logined to your System";
            $("#response_modal_basic").modal("show");
        <%}else if(request.getParameter("response").compareToIgnoreCase("login_failed") == 0){%>
            document.getElementById('response_message').innerHTML = "Login Failed! Kindly check you credentials, before login to our system.";
            $("#response_modal_basic").modal("show");
        <%}else if(request.getParameter("response").compareToIgnoreCase("balance_error") == 0){%>
            document.getElementById('response_message').innerHTML = "Your Balance is not enough for checkout";
            $("#response_modal_basic").modal("show");
        <%}else if(request.getParameter("response").compareToIgnoreCase("checkout_success") == 0){%>
            document.getElementById('response_message').innerHTML = "Checkout Successful, order is on the way!";
            $("#response_modal_basic").modal("show");
        <%}%>
    <% }%>
</script>