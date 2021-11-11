<!-- Modal -->
<div class="modal fade" id="employee_data_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">All Employee Data</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="delete_all_data_employee_data_modal();">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
              <h6 id="alert-employee-data-modal" class="alert alert-info" role="alert">No data available</h6>
              <div id="employee_task_table_modal" class="row">
                  <h6 class="col">Employee Tasks</h6>
                  <div class="w-100"></div>
                  <table class="col table table-sm text-center">
                    <thead class="table-dark">
                      <tr>
                        <th scope="col">ID.</th>
                        <th scope="col">Name</th>
                        <th scope="col">Duration</th>
                        <th scope="col">Action</th>
                      </tr>
                    </thead>
                    <tbody id="employee_task_table_modal_body">
                    </tbody>
                  </table>
              </div>
          </div>
      </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="delete_all_data_employee_data_modal();">Close</button>
      </div>
    </div>
  </div>
</div>