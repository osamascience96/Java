<!-- Modal -->
<div class="modal fade" id="login_modal" tabindex="-1" role="dialog" aria-labelledby="loginmodallabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="loginmodallabel">Login</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="container">
        	<div id="alert_placeholder_login_modal"></div>
        	<div class="form-group">
        		<label for="credential_username_email">Enter UserName or Email</label>
        		<input type="text" name="credential_username_email" class="form-control" id="credential_username_email" placeholder="Username or Email" required>
        	</div>
        	<div class="form-group">
        		<label for="password">Enter Password</label>
        		<input type="password" name="password" class="form-control" id="login_password" placeholder="Password" required>
        	</div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-outline-primary btn-block" onclick="login_credentials()">Login</button>
      </div>
    </div>
  </div>
</div>