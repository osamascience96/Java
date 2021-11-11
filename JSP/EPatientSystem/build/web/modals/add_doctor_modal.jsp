<!-- Modal -->
<div class="modal fade" id="doctor_modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Doctor</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <div class="container-fluid">
              <form action="doctor_servlet" method="POST" class="container">
                <div class="form-group">
                  <input type="text" name="fullname" class="form-control" placeholder="Full Name" required>
                </div>
                <br>
                <div class="form-group">
                    <input type="text" name="username" class="form-control" placeholder="Username" required>
                </div>
                <br>
                <div class="form-group">
                    <input type="email" name="email" class="form-control" placeholder="Email Address" required>
                </div>
                <br>
                <div class="form-group">
                    <input type="text" name="phone" class="form-control" placeholder="AMKA" required>
                </div>
                <br>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="Password" required>
                </div>
                <br>
                <div class="form-group">
                    <select class="form-select" name="profession" required>
                        <option value="Orthodontist">Orthodontist</option>
                        <option value="Pathologist">Pathologist</option>
                        <option value="Dentist">Dentist</option>
                    </select>
                </div>
                <br>
                <div class="d-grid gap-2 col-6 mx-auto">
                    <input class="btn btn-primary" type="submit" value="Add Doctor">
                </div>
              </form>
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger btn-block" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>