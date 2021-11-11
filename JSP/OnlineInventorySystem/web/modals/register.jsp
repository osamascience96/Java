<!-- Register Modal -->
<div id="register_modal" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Register</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="reg_alert_placeholder"></div>
              <div class="form-group">
                  <label for="username">Enter Username</label>
                  <input type="text" id="reg_username" class="form-control" placeholder="Username">
              </div>
              <div class="form-group">
                  <label for="email">Enter Email</label>
                  <input type="email" id="reg_email" class="form-control" placeholder="Email">
              </div>
              <div class="form-group">
                  <label for="">Enter Password</label>
                  <input type="password" id="reg_password" class="form-control" placeholder="Password">
              </div>
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-primary" onclick="register()">Register</button>
      </div>
    </div>
  </div>
</div>