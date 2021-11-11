<!-- Modal -->
<div id="edit_client_modal" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="edit_client_modal_title" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
          <h5 class="modal-title">Client Id. <span id="edit_client_modal_title"></span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="edit_client_error_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> All the fields must be filled to insert the client.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div id="edit_client_email_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> Email must have a correct format.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div id="edit_client_phone_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> Phone number must be greater than 7 and less than or equal to 15 characters.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div id="edit_client_phone_regex_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> Phone number must meet the Canadian Phone Number Standards.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <form id="client_edit_form_modal" action="client_servlet" method="POST">
                  <div class="form-group">
                      <label for="edit_client_name">Enter Client Name:</label>
                      <input id="edit_client_name" class="form-control" type="text" name="name" placeholder="Client Name" required>
                  </div>
                  <div class="form-group">
                      <label for="edit_client_address">Enter Location Address:</label>
                      <input id="edit_client_address" class="form-control" type="text" name="address" placeholder="Client Address" required>
                  </div>
                  <div class="form-group">
                      <label for="edit_client_email">Enter Client Email:</label>
                      <input id="edit_client_email" class="form-control" type="email" name="email" placeholder="Client Email" required>
                  </div>
                  <div class="form-group">
                      <label for="edit_client_phone">Enter Client Phone:</label>
                      <input id="edit_client_phone" class="form-control" type="number" name="phone" placeholder="Client Phone" required>
                  </div>
                  <div class="form-group">
                    <label>Created Date Time:</label>
                    <div class="row">
                        <div class="col">
                            <input id="created_at_date" type="date" class="form-control" name="created_at_date" placeholder="Created Date">
                        </div>
                        <div class="col">
                            <input id="created_at_time" type="time" class="form-control" name="created_at_time" placeholder="Created Time">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label>Updated Date Time:</label>
                    <div class="row">
                        <div class="col">
                            <input id="updated_at_date" type="date" class="form-control" name="updated_at_date" placeholder="Updated Date">
                        </div>
                        <div class="col">
                            <input id="updated_at_time" type="time" class="form-control" name="updated_at_time" placeholder="Updated Time">
                        </div>
                    </div>
                </div>
                  <input type="hidden" name="request_type" value="update">
                  <input type="hidden" id="client_id" name="client_id">
              </form>
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="edit_client_form();">Update Client</button>
      </div>
    </div>
  </div>
</div>