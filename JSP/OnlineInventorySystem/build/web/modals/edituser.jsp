<!-- Register Modal -->
<div id="edit_user_modal" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Edit User</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="edituser_alert_placehodler"></div>
              <div class="form-group">
                  <label for="edit_user_username">Enter Username</label>
                  <input type="text" id="edit_user_username" class="form-control" placeholder="Username">
              </div>
              <div class="form-group">
                  <label for="edit_user_email">Enter Email</label>
                  <input type="email" id="edit_user_email" class="form-control" placeholder="Email">
              </div>
              <div class="form-group">
                  <label for="edit_user_role">Enter Role</label>
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <label class="input-group-text" for="edit_user_role">Roles</label>
                    </div>
                    <select class="custom-select" id="edit_user_role">
                      <option value="admin">Admin</option>
                      <option value="manager">Manager</option>
                      <option value="customer">Customer</option>
                    </select>
                  </div>
              </div>
              <div class="form-group">
                  <label for="edit_user_password">Enter Password</label>
                  <input type="password" id="edit_user_password" class="form-control" placeholder="Password">
              </div>
              <input type="hidden" id="edit_user_id">
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-info btn-block" onclick="edituser()">Edit User</button>
      </div>
    </div>
  </div>
</div>