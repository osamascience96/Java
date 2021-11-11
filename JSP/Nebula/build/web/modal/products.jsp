<%@page import="Bean.Category"%>
<%@page import="java.util.ArrayList"%>
<div id="add_product_modal" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content bg-dark">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
            <div class="container">
                <div id="alert_placeholder_product_modal"></div>
                <form id="product_form" action="product_controller" method="post" enctype="multipart/form-data">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <label class="input-group-text" for="category_selection">Categories</label>
                        </div>
                        <select class="custom-select" id="category_selection" name="category_selection">
                          <%
                              ArrayList<Category> arrayListCategories = (ArrayList<Category>)session.getAttribute("category_list_session");
                              if(arrayListCategories != null){
                          %>
                                <% for(int i=0; i < arrayListCategories.size(); i++){%>
                                    <option value="<%=arrayListCategories.get(i).getId()%>"><%=arrayListCategories.get(i).getName()%></option>
                                <% }%>
                          <% }%>
                        </select>
                        </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="product_name" id="product_name" placeholder="Enter Name">
                    </div>
                    <div class="form-group">
                        <textarea name="product_description" id="product_description" rows="10" class="form-control" placeholder="Enter Description"></textarea>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <span class="input-group-text">$</span>
                        </div>
                        <input type="number" class="form-control" id="product_price" name="product_price" aria-label="Price" placeholder="Enter Price in Dollars">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <span class="input-group-text">Upload Image</span>
                        </div>
                        <div class="custom-file">
                          <input type="file" class="custom-file-input" id="product_upload" name="product_upload">
                          <label class="custom-file-label" for="product_upload">Choose file</label>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-outline-success btn-block" onclick="add_product()">Add Product</button>
        </div>
    </div>
  </div>
</div>