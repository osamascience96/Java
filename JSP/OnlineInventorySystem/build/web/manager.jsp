<%@page import="bean.Inventory"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp" %>
<link rel="stylesheet" href="css/manager.css">
<title>Home</title>
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <% 
        ArrayList<Inventory> inventoryArrayList = (ArrayList<Inventory>) session.getAttribute("inventory_managemet_list");
    %>
    <% if(inventoryArrayList != null){%>
    <div class="container">
        <div class="table table-bordered table-light table-responsive-lg">
            <table class="table">
                <caption>Inventory List</caption>
                <thead>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Image</th>
                    <th scope="col">Actions</th>
                </thead>
                <tbody>
                    <% for(int i=0; i < inventoryArrayList.size(); i++){%>
                        <tr>
                            <th scope="row"><%=inventoryArrayList.get(i).getId()%></th>
                            <td><%=inventoryArrayList.get(i).getName()%></td>
                            <td class="text-primary">$<%=inventoryArrayList.get(i).getPrice()%></td>
                            <td><img src="img/management_prduct.jpg" width="50"></td>
                            <td class="text-center align-middle">
                                <div class="btn-group align-top">
                                    <button class="btn btn-sm btn-outline-primary badge" type="button" onclick="open_edit_inventory(<%=inventoryArrayList.get(i).getId()%>, '<%=inventoryArrayList.get(i).getName()%>', '<%=inventoryArrayList.get(i).getDescription()%>', <%=inventoryArrayList.get(i).getPrice()%>)">Edit</button>
                                    <a class="btn btn-sm btn-outline-danger badge" href="management_controller?is_del=true&id=<%=inventoryArrayList.get(i).getId()%>"><i class="fa fa-trash"></i></a>
                                </div>
                            </td>
                        </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
        <button class="btn btn-outline-info btn-block" data-toggle="modal" data-target="#add_inventory_modal">Add Inventory</button>
    </div>
    <% }else{
        response.sendRedirect("index.jsp");
    }%>
<%@include file="includes/boostrapJS.jsp" %>
<%@include file="modals/addinventory.jsp" %>
<%@include file="modals/editinventory.jsp" %>
<script src="js/inventory.js"></script>
</body>
</html>