<%@page import="Model.Catalog"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
    <body>
        <%
            String is_accessed = null;
            if(session.getAttribute("accessed_catalog") != null){
                is_accessed = session.getAttribute("accessed_catalog").toString();
            }
        %>
        <% if(Boolean.parseBoolean(is_accessed) == false){%>
            <h1 class="text-center">Online Book Catalog</h1>
            <h3 class="text-center">
                <a href="catalog_controller">Please Go to the Following Link</a>
            </h3>
            <div data-role="cube"></div>
        <% }else{%>
            <%
                ArrayList<Catalog> arrayListCatalog = (ArrayList<Catalog>)session.getAttribute("allcataloglist");
                if(arrayListCatalog.size() > 0){
            %>
                <table class="table">
                    <thead>
                        <tr>
                            <th style="color:white;">#</th>
                            <th style="color:white;">Title</th>
                            <th style="color:white;">Author</th>
                            <th style="color:white;">Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(int i=0; i < arrayListCatalog.size(); i++){%>
                            <tr>
                                <td><%=arrayListCatalog.get(i).getId()%></td>
                                <td><%=arrayListCatalog.get(i).getTitle()%></td>
                                <td><%=arrayListCatalog.get(i).getAuthor()%></td>
                                <td>$<%=arrayListCatalog.get(i).getPrice()%></td>
                            </tr>
                        <% }%>
                    </tbody>
                </table>
            <% }else{%>
                <h3 class="text-center">No Catalog Available</h3>
            <% }%>
        <% }%>
        <br>
        <hr>
        <form action="catalog_controller" method="post">
            <div class="form-group">
                <label>Enter Book Title</label>
                <input class="metro-input" name="book_title" type="text" placeholder="Book Title" required/>
            </div>
            <div class="form-group">
                <label>Enter Book Author</label>
                <input class="metro-input" name="book_author" type="text" placeholder="Book Author" required/>
            </div>
            <div class="form-group">
                <label>Enter Book Price</label>
                <input type="number" data-role="input" name="book_price" class="mb-1" data-prepend="<span class='mif-dollar2'></span>" data-append="<span>0.00</span>" required />
            </div>
            <div class="form-group">
                <button class="button success">Submit Book</button>
            </div>
        </form>
    <!-- rest of the code resides in the footer -->    
<%@include file="includes/footer.jsp" %>
