<div id="feedback_modal" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Add Feedback</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="feedback_alert_message" class="alert alert-danger alert-dismissible fade" role="alert">
                <strong><span id="feedback_alert_title"></span>!</strong> <span id="feedback_alert_message"></span>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <form id="form_feedback" action="Feedback" method="POST">
                  <div class="form-group">
                      <label for="name">Your Name</label>
                      <input id="name" class="form-control" type="text" name="name" placeholder="Full Name" required/>
                  </div>
                  <div class="form-group">
                      <label for="country">Your Country</label>
                      <input id="country" class="form-control" type="text" name="country" placeholder="Enter Country" required/>
                  </div>
                  <div class="form-group">
                      <label for="phone">Your Phone Number</label>
                      <input id="phone" class="form-control" type="number" name="phone" placeholder="Enter Phone" required/>
                  </div>
                  <div class="form-group">
                      <label for="email">Your Email</label>
                      <input id="email" class="form-control" type="email" name="email" placeholder="Enter Email" required/>
                  </div>
                  <div class="input-group mb-3">
                      <div class="input-group-prepend">
                        <label class="input-group-text" for="type_options">Types</label>
                      </div>
                      <select class="custom-select" id="type_options" name="type_options">
                        <option value="desktop">Desktop</option>
                        <option value="laptop">Laptop</option>
                        <option value="tablet">Tablet</option>
                      </select>
                  </div>
                  <div class="form-group">
                      <label for="subject">Enter your Subject</label>
                      <input id="subject" class="form-control" type="text" name="subject" placeholder="Enter Subject" required/>
                  </div>
                  <div class="form-group">
                      <label for="messages">Enter your Message:</label>
                      <textarea id="messages" class="form-control" type="text" name="messages" placeholder="Enter Message" rows="20" cols="20" required></textarea>
                  </div>
              </form>
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-outline-primary" onclick="feedback_handler(document.getElementById('form_feedback'))">Send Feedback</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>