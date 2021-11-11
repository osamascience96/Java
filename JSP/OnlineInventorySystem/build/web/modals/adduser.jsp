<!-- Register Modal -->
<div id="add_user_modal" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add User</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="adduser_alert_placehodler"></div>
              <div class="form-group">
                  <label for="add_user_username">Enter Username</label>
                  <input type="text" id="add_user_username" class="form-control" placeholder="Username">
              </div>
              <div class="form-group">
                  <label for="add_user_email">Enter Email</label>
                  <input type="email" id="add_user_email" class="form-control" placeholder="Email">
              </div>
              <div class="form-group">
                  <label for="add_user_role">Enter Role</label>
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <label class="input-group-text" for="add_user_role">Roles</label>
                    </div>
                    <select class="custom-select" id="add_user_role">
                      <option value="admin">Admin</option>
                      <option value="manager">Manager</option>
                      <option value="customer">Customer</option>
                    </select>
                  </div>
              </div>
              <div class="form-group">
                  <label for="add_user_password">Enter Password</label>
                  <input type="password" id="add_user_password" class="form-control" placeholder="Password">
              </div>
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-info btn-block" onclick="adduser()">Add User</button>
      </div>
    </div>
  </div>
</div>