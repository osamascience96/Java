<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!-- Modal -->
<div id="insert_clients_modal" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add New Client</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="insert_client_error_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> All the fields must be filled to insert the client.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div id="insert_client_email_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> Email must have a correct format.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div id="insert_client_phone_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> Phone number must be greater than 7 and less than or equal to 15 characters.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div id="insert_client_phone_regex_alert" class="alert alert-danger alert-dismissible fade show" style="display: none;" role="alert">
                <strong>Error!</strong> Phone number must meet the Canadian Phone Number Standards.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <form id="client_add_form_modal" action="client_servlet" method="POST">
                  <div class="form-group">
                      <label for="client_name">Enter Client Name:</label>
                      <input id="client_name" class="form-control" type="text" name="name" placeholder="Client Name" required>
                  </div>
                  <div class="form-group">
                      <label for="client_address">Enter Location Address:</label>
                      <input id="client_address" class="form-control" type="text" name="address" placeholder="Client Address" required>
                  </div>
                  <div class="form-group">
                      <label for="client_email">Enter Email Address:</label>
                      <input id="client_email" class="form-control" type="email" name="email" placeholder="Client Email" required>
                  </div>
                  <div class="form-group">
                      <label for="client_phone">Enter Phone No:</label>
                      <input id="client_phone" class="form-control" type="number" name="phone" placeholder="Client Phone" required>
                  </div>
                  <%
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String datetime[] = dtf.format(now).split(" ");
                  %>
                  <label>Date and Time:</label>
                  <div class="row">
                      <div class="col">
                        <div class="form-group">
                            <input id="created_date" class="form-control" type="date" name="created_date" value="<%=datetime[0]%>" required>
                        </div>
                      </div>
                      <div class="col">
                        <div class="form-group">
                            <input id="created_time" class="form-control" type="time" name="created_time" value="<%=datetime[1]%>" required>
                        </div>
                      </div>
                  </div>
                    <input type="hidden" name="request_type" value="insert" >
                    <input type="hidden" name="created_at" value="<%=dtf.format(now)%>" >
              </form>
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="insert_client_form()">Add Client</button>
      </div>
    </div>
  </div>
</div>