<!-- Modal -->
<div id="login_modal" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="login_modal_label" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="login_modal_label">Login</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="alert_placeholder_login"></div>
              <div class="form-group">
                  <label for="username_email">Enter Username or Email:</label>
                  <input type="text" name="username_email" class="form-control" id="username_email" placeholder="Username or Email">
              </div>
              <div class="form-group">
                  <label for="password_login">Password:</label>
                  <input type="password" name="password_login" class="form-control" id="password_login" placeholder="Password">
              </div>
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-outline-primary btn-block" onclick="Login();">Login</button>
      </div>
    </div>
  </div>
</div>