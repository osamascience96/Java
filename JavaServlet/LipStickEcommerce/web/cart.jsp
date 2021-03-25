<%@page import="com.pojo.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pojo.User"%>
<%@include file="includes/header.jsp" %>
<main>
    <!-- Hero Area Start-->
    <div class="slider-area ">
        <div class="single-slider slider-height2 d-flex align-items-center">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>Cart List</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--================Cart Area =================-->
    <%
        // Initialisieren Sie das Benutzerobjekt
        User user = (User) session.getAttribute("userObj");
        if(user == null){
            // Leiten Sie die Antwort um
            response.sendRedirect("login.jsp");
        }else{
    %>
    <%
        // Initiieren Sie die Arrayliste aus der Sitzung
        ArrayList<Cart> arrayCartList = (ArrayList<Cart>) session.getAttribute("cart_array_list");
    %>
    <div class="table table-bordered table-light table-responsive" style='padding:10px;'>
        <table class="table">
            <caption>CartList</caption>
            <thead>
                <th scope="col">ID.</th>
                <th scope="col">Product Id.</th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Image</th>
            </thead>
            <tbody>

                    <%
                        // Durchlaufen Sie die Liste und initialisieren Sie alle Werte, um die Daten anzuzeigen
                        for(int i=0; i < arrayCartList.size(); i++){
                    %>
                        <tr>
                            <th scope="row"><%=arrayCartList.get(i).GetId()%></th>
                            <td><%=arrayCartList.get(i).GetProductid()%></td>
                            <td><%=arrayCartList.get(i).GetProductName()%></td>
                            <td><%="$".concat(String.valueOf(arrayCartList.get(i).GetProductPrice()))%></td>
                            <td style='text-align:center;'><img width="100px" src="files/product_image/<%=arrayCartList.get(i).GetProductImageName()%>"></td>
                        </tr>
                    <%}%>
            </tbody>
        </table>
        <a type="button" class="btn btn-block btn-primary" href="chcekout_servlet?user_id=<%=user.GetId()%>">Checkout</a>
    </div>
    <% }%>
    <!--================End Cart Area =================-->
</main>        
<%@include file="includes/footer.jsp" %>