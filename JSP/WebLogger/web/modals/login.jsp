<div id="login_form" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Enter username or name to login</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <form id="loginform" action="login_servlet" method="POST">
              <div class="form-group">
                  <input type="text" name="username" class="form-control" placeholder="Username"/>
              </div>
          </form>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-outline-primary" onclick="$('#loginform').submit()">Login</button>
        <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>