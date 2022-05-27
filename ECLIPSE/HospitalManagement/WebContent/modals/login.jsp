<!-- Login Modal -->
<div class="modal fade" id="login_modal" tabindex="-1" role="dialog" aria-labelledby="loginModelLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="loginModelLabel">Login to Continue</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="container">
        	<div id="alert_placeholder"></div>
        	<div class="form-group">
        		<label for="username_email">Enter Username or Email</label>
        		<input type="text" id="username_email" class="form-control" placeholder="Username or Email">
        	</div>
        	<div class="form-group">
        		<label for="login_password">Enter Password</label>
        		<input type="password" id="login_password" class="form-control" placeholder="Password">
        	</div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-outline-primary" onclick="login();">Login</button>
      </div>
    </div>
  </div>
</div>