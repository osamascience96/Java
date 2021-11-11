<div id="login_modal" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Sign In Form</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <form id="login_form" action="login" method="POST">
                  <div class="form-group">
                      <label for="username">Enter Username</label>
                      <input id="username" class="form-control" type="text" name="username" placeholder="Username"/>
                  </div>
                  <div class="form-group">
                      <label for="password">Enter Password</label>
                      <input id="password" class="form-control" type="password" name="password" placeholder="Password"/>
                  </div>
              </form>
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-outline-success" onclick="login_handler(document.getElementById('login_form'))">Login</button>
        <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>