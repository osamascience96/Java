<%@page import="bean.Inventory"%>
<%@page import="java.util.ArrayList"%>
<!-- Login Modal -->
<div id="checkout_modal" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Checkout</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <%
                  ArrayList<Inventory> inventoryCartArrayList = (ArrayList<Inventory>) session.getAttribute("inventoryList");
                  if(inventoryCartArrayList != null){
              %>
                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">Id</th>
                      <th scope="col">Name</th>
                      <th scope="col">Price</th>
                      <th scope="col">Image</th>
                    </tr>
                  </thead>
                  <tbody>
                      <%
                          double totalPrice =  0;
                      %>
                    <% for(int i=0; i < inventoryCartArrayList.size(); i++){%>
                        <tr>
                          <th scope="row"><%=inventoryCartArrayList.get(i).getId()%></th>
                          <td><%=inventoryCartArrayList.get(i).getName()%></td>
                          <td>$<%=inventoryCartArrayList.get(i).getPrice()%></td>
                          <%
                              totalPrice += inventoryCartArrayList.get(i).getPrice();
                          %>
                          <td><img width="50" src="<%=request.getContextPath()%>/img/product.jpg"></td>
                        </tr>
                    <% }%>
                  </tbody>
                </table>
                  <h3 class="text-primary">Total Price: $<%=totalPrice%></h3>
              <% }else{%>
                <h4 class="mx-auto">No Product Added to Cart</h4>
              <% }%>
          </div>
      </div>
      <div class="modal-footer">
        <a class="btn btn-outline-dark btn-block" href="checkout_controller">Checkout</a>
      </div>
    </div>
  </div>
</div>