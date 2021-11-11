<!-- Login Modal -->
<div class="modal fade" id="loginModel" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="loginModalLabel">Login</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="login_alert_message"></div>
              <!-- login email -->
              <div class="form-group">
                  <label for="email">Enter Email</label>
                  <input type="text" id="email" placeholder="Enter Email Address" class="form-control">
              </div>
              <!-- login password -->
              <div class="form-group">
                  <label for="password">Enter Password</label>
                  <input type="password" id="password" placeholder="Enter Password" class="form-control">
              </div>
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-primary" onclick="login()">Login</button>
      </div>
    </div>
  </div>
</div>
<script src="<%=request.getContextPath()%>/JS/login.js"></script>