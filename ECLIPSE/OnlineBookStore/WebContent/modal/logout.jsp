<!-- Modal -->
<div class="modal fade" id="profile_modal" tabindex="-1" role="dialog" aria-labelledby="logoutLabelled" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="logoutLabelled">User Profile</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="container">
        	<h4>Username: <%=session.getAttribute("username") != null ? session.getAttribute("username") : "" %></h4>
        	<h4>Email: <%=session.getAttribute("email") != null ? session.getAttribute("email") : "" %></h4>
        	<h4>Password: <%=session.getAttribute("password") != null ? session.getAttribute("password") : "" %></h4>
        </div>
      </div>
      <div class="modal-footer">
        <a class="btn btn-outline-danger btn-block" href="Logout">Logout</a>
      </div>
    </div>
  </div>
</div>