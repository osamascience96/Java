<div id="job_finish_modal" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title">Finish Job</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
            <div class="container">
                <h5>Do you want to finish the Job ?</h5>
                <div class="row">
                    <input type="hidden" id="finish_job_link" />
                    <button type="button" class="col btn btn-outline-primary" onclick="confirm_finsih()">Confirm</button>
                    &nbsp;
                    &nbsp;
                    &nbsp;
                    &nbsp;
                    &nbsp;
                    <button type="button" class="col btn btn-outline-danger" data-dismiss="modal">No</button>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-outline-danger btn-block" data-dismiss="modal" onclick="">Close</button>
        </div>
    </div>
  </div>
</div>