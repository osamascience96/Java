<div id="add_categories_modal" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content bg-dark">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
            <div class="container">
                <div id="alert_placeholder_category_modal"></div>
                <form id="category_form" action="category_controller" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="text" class="form-control" name="category_name" id="category_name" placeholder="Enter Name">
                    </div>
                    <div class="form-group">
                        <textarea name="category_description" id="category_description" rows="10" class="form-control" placeholder="Enter Description"></textarea>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <span class="input-group-text">Upload Image</span>
                        </div>
                        <div class="custom-file">
                          <input type="file" class="custom-file-input" id="category_upload" name="category_upload">
                          <label class="custom-file-label" for="category_upload">Choose file</label>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-outline-success btn-block" onclick="add_category()">Add Category</button>
        </div>
    </div>
  </div>
</div>