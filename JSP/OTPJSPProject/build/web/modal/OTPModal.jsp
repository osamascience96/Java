<!-- Modal -->
<div class="modal fade" id="otpModal" tabindex="-1" role="dialog" aria-labelledby="otpmodallabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="otpmodallabel">Validate OTP</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <div id="alert_otp_message"></div>
              <div class="form-group">
                  <input type="hidden" id="otp_reg_key">
                  <label for="otp_input">Ente OTP Code</label>
                  <input type="text" class="form-control" id="otp_input" placeholder="Enter OTP Code">
              </div>
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-outline-success btn-block" onclick="validateOTPCode()">Submit OTP</button>
      </div>
    </div>
  </div>
</div>

<script src="<%=request.getContextPath()%>/JS/validateOTP.js"></script>