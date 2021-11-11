<div id="cart_modal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Cart</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
            <h4>Add Ons</h4>
            <hr>
            <form id="cart_form" action="cart_servlet" method="POST">
                <input type="hidden" name="product_Id" id="product_Id_cartmodal">
                <input type="hidden" name="price" id="price_cart_modal">
                <input type="hidden" name="quantity" id="quantity_cart_modal">
                <div class="row">
                    <div class="input-group col">
                        <div class="input-group-prepend">
                          <div class="input-group-text">
                            <input type="radio" aria-label="Radio button for following text input" name="cream_add_on" value="Add Cream">
                          </div>
                        </div>
                        <input type="text" class="form-control" aria-label="Text input with radio button" value="Add Cream" readonly>
                    </div>  
                    <div class="input-group col">
                        <div class="input-group-prepend">
                          <div class="input-group-text">
                            <input type="radio" aria-label="Radio button for following text input" name="cream_add_on" value="No Cream">
                          </div>
                        </div>
                        <input type="text" class="form-control" aria-label="Text input with radio button" value="No Cream" readonly>
                    </div>  
                </div>
                <br>
                <div class="row form-group">
                    <textarea class="form-control" rows="10" name="extra_notes" placeholder="Add Extra Notes"></textarea>
                </div>
            </form>
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-outline-primary" onclick="insert_cart()">Add to Cart</button>
        <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>