<div id="job_add_comment_modal" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title">Add Comments</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
            <div class="container">
                <form id="add_comment_form" action="job_servlet" method="POST">
                    <div class="form-group">
                        <textarea id="add_comment_input" class="form-control" rows="10" cols="10" name="comment" placeholder="Enter Comments"></textarea>
                    </div>
                    <input id="job_id_add_comment" type="hidden" name="job_id" value="add_comment"/>
                    <input type="hidden" name="request_type" value="add_comment"/>
                </form>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-outline-primary" onclick="event.preventDefault(); add_comment_submit_form(document.getElementById('add_comment_form'))">Add Comment</button>
            <button type="button" class="btn btn-outline-danger" data-dismiss="modal" onclick="">Close</button>
        </div>
    </div>
  </div>
</div>