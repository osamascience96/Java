<!-- Team Members Scale Modal -->
<div class="modal fade" id="team_member_scale_modal" tabindex="-1" role="dialog" aria-labelledby="team_member_scale_modal" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="title">Scale Team Members</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div id="team_member_scale_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
              <strong>Error!</strong> <span id="team_member_scale_alert_message"></span>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <form id="team_member_form" action="team_servlet" method="POST">
              <div class="form-group">
                  <label for="member_scale">No. of Members</label>
                  <input id="team_member_scale" class="form-control" type="number" name="member_scale" placeholder="Scale Member" required>
              </div>
              <input type="hidden" name="post_action" value="scale_member">
              <input id="team_scale_team_id_form" type="hidden" name="team_id">
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <a type="button" class="btn btn-primary" style="color:white;" onclick="update_team_member_scale();">Scale</a>
      </div>
    </div>
  </div>
</div>