<!-- Modal -->
<div class="modal fade" id="login_modal" tabindex="-1" role="dialog" aria-labelledby="login_modal_Label" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="login_modal_Label">Login</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="alert_placeholder_login_modal"></div>
              <form action="" method="post">
                <div class="form-group">
                    <input type="text" name="username_email" class="form-control" id="username_email" placeholder="Enter Username or Email" required>
                </div>
                <div class="form-group">
                    <input type="password" name="login_password" class="form-control" id="login_password" placeholder="Enter Password" required>
                </div>
              </form>
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-outline-success btn-block" onclick="login()">Login</button>
      </div>
    </div>
  </div>
</div>