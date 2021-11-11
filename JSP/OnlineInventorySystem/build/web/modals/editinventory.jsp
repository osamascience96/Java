<!-- Register Modal -->
<div id="edit_inventory_modal" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Edit Inventory</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="editinventory_alert_placehodler"></div>
              <div class="form-group">
                  <label for="edit_inventory_name">Enter Name</label>
                  <input type="text" id="edit_inventory_name" class="form-control" placeholder="Name">
              </div>
              <div class="form-group">
                  <label for="edit_inventory_description">Enter Description</label>
                  <textarea id="edit_inventory_description" class="form-control" rows="10" cols="10" placeholder="Description"></textarea>
              </div>
              <div class="form-group">
                  <label for="edit_inventory_price">Enter Price</label>
                  <input type="number" id="edit_inventory_price" class="form-control" placeholder="Price">
              </div>
              <input type="hidden" id ="edit_inventory_id">
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-info btn-block" onclick="editinventory()">Edit Inventory</button>
      </div>
    </div>
  </div>
</div>