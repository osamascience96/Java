<div id="tasks_list_modal" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title">Task List</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="empty_table_body()">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
            <div class="container">
                <div class="table-responsive-sm">
                    <table class="table">
                        <caption>Tasks</caption>
                        <thead>
                          <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Team</th>
                            <th scope="col">Duration(Minutes)</th>
                          </tr>
                        </thead>
                        <tbody id="tasklist_table_body">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-outline-primary btn-block" data-dismiss="modal" onclick="empty_table_body()">OK</button>
        </div>
    </div>
  </div>
</div>