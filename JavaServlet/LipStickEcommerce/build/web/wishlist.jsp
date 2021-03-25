<%@page import="com.pojo.WishList"%>
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
                            <h2>Wish List</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--================Wish Area =================-->
    <%
        // Initialisieren Sie das Benutzerobjekt aus der initiierten Sitzung
        User user = (User) session.getAttribute("userObj");
        // wenn der Benutzer null ist
        if(user == null){
            // Leiten Sie den Benutzer zur Anmeldeseite weiter
            response.sendRedirect("login.jsp");
        }else{
    %>
    <%
        // Initialisieren Sie die arrayWishList aus der erstellten Sitzung
        ArrayList<WishList> arrayWishList = (ArrayList<WishList>) session.getAttribute("wish_array_list");
    %>
    <div class="table table-bordered table-light table-responsive" style='padding:10px;'>
                <table class="table">
                    <caption>WishList</caption>
                    <thead>
                        <th scope="col">ID.</th>
                        <th scope="col">Product Id.</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Image</th>
                        <th scope="col">Actions</th>
                    </thead>
                    <tbody>

                            <%
                                // Durchlaufen Sie die Liste, um die Daten zu replizieren
                                for(int i=0; i < arrayWishList.size(); i++){
                            %>
                                <tr>
                                    <th scope="row"><%=arrayWishList.get(i).GetId()%></th>
                                    <td><%=arrayWishList.get(i).GetProductid()%></td>
                                    <td><%=arrayWishList.get(i).GetProductName()%></td>
                                    <td><%="$".concat(String.valueOf(arrayWishList.get(i).GetProductPrice()))%></td>
                                    <td style='text-align:center;'><img width="100px" src="files/product_image/<%=arrayWishList.get(i).GetProductImageName()%>"></td>
                                    <td class="text-center align-middle">
                                        <div class="btn-group align-top">
                                            <a class="btn btn-sm btn-outline-primary badge" type="button" href="cart_servlet?product_id=<%=arrayWishList.get(i).GetProductid()%>">Cart</a>
                                            <a class="btn btn-sm btn-outline-primary badge" href="#"><i class="fa fa-trash"></i></a>
                                        </div>
                                    </td>
                                </tr>
                            <%}%>
                    </tbody>
                </table>
            </div>
    <% }%>
    <!--================End Cart Area =================-->
</main>        
<%@include file="includes/footer.jsp" %>