<!-- Register Modal -->
<div id="add_inventory_modal" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Inventory</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="addinventory_alert_placehodler"></div>
              <div class="form-group">
                  <label for="add_inventory_name">Enter Name</label>
                  <input type="text" id="add_inventory_name" class="form-control" placeholder="Name">
              </div>
              <div class="form-group">
                  <label for="add_inventory_description">Enter Description</label>
                  <textarea id="add_inventory_description" class="form-control" rows="10" cols="10" placeholder="Description"></textarea>
              </div>
              <div class="form-group">
                  <label for="add_inventory_price">Enter Price</label>
                  <input type="number" id="add_inventory_price" class="form-control" placeholder="Price">
              </div>
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-info btn-block" onclick="addinventory()">Add Inventory</button>
      </div>
    </div>
  </div>
</div>