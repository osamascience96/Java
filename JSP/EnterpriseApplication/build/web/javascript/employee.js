/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function open_edit_modal(id, first_name, last_name, sin, hourly_rate){
    document.getElementById("edit_first_name").value = first_name;
    document.getElementById("edit_last_name").value = last_name;
    document.getElementById("edit_sin").value = sin;
    document.getElementById("edit_hourly_rate").value = hourly_rate;
    document.getElementById("employee_id").value = id;
    $("#edit_employee_modal").modal("show");
}

function open_employee_data_modal(taskObjArray){
    var tasK_table_modal = document.getElementById("employee_task_table_modal");
    // if the task object array length is 0,
    if(taskObjArray.length > 0){
        tasK_table_modal.style.display = "block";
        document.getElementById("alert-employee-data-modal").style.display = "none";
        let task_table_modal_body = document.getElementById("employee_task_table_modal_body");
        for(let i=0; i < taskObjArray.length; i++){
            // row in table
            var row = task_table_modal_body.insertRow(i);
            //data in cells
            var task_id = row.insertCell(0);
            var name = row.insertCell(1);
            var duration = row.insertCell(2);
            var delete_button = row.insertCell(3)
            
            task_id.innerHTML = taskObjArray[i]['id'];
            name.innerHTML = taskObjArray[i]['name'];
            duration.innerHTML = taskObjArray[i]['duration'] + " mins";
            // add delete link 
            delete_button.innerHTML = "<a class='btn btn-outline-danger' href='employee_servlet?delete_task_id="+taskObjArray[i]['id']+"&employee_id="+taskObjArray[i]['employee_id']+"'>Delete</a>";
            
        }
    }else{
        tasK_table_modal.style.display = "none";
        document.getElementById("alert-employee-data-modal").style.display = "block";
    }
    $("#employee_data_modal").modal("show");
}


function delete_all_data_employee_data_modal(){
    // empty the task table 
    $("#employee_task_table_modal_body tr").remove();
}

function submit_insert_employee_form(){
    var employee_form = document.getElementById('insert_employee_form');
    
    let firstname = document.getElementById("insert_first_name").value;
    let lastname = document.getElementById("insert_last_name").value;
    let sin_input1 = document.getElementById("sin1").value;
    let sin_input2 = document.getElementById("sin2").value;
    let sin_input3 = document.getElementById("sin3").value;
    let hourly_rate = document.getElementById("insert_hourly_rate").value;
    
    // check if any of the values are empty
    if(firstname === "" || lastname === "" || sin_input1 === "" || sin_input2 === "" || sin_input3 === "" || hourly_rate === ""){
        document.getElementById("insert_modal_alert_error_message").innerHTML = "Fill All the fields to insert the employee records";
        document.getElementById("insert_modal_alert_error").style.display = "block";
    }else{
        // submit the form
        employee_form.submit();
    }
}

function edit_insert_employee_form(){
    var employee_form = document.getElementById('edit_employee_form');
    
    let firstname = document.getElementById("edit_first_name").value;
    let lastname = document.getElementById("edit_last_name").value;
    let hourly_rate = document.getElementById("edit_hourly_rate").value;
    
    // check if any of the values are empty
    if(firstname === "" || lastname === "" || hourly_rate === ""){
        document.getElementById("edit_modal_alert_error_message").innerHTML = "Fill All the fields to insert the employee records";
        document.getElementById("edit_modal_alert_error").style.display = "block";
    }else{
        // submit the form
        employee_form.submit();
    }
}


function open_delete_confirm_modal(link){
    // set the link to the hidden element 
    document.getElementById("delete_employee_link").value = link;
    $("#employee_delete_modal").modal("show");
}

function confirm_delete(){
    var link = document.getElementById("delete_employee_link").value;
    window.location.replace(link);
}

function search_employees(){
    var inputSearch = document.getElementById("search_employee_input");
    var filter = inputSearch.value.toUpperCase();
    var table = document.getElementById("employee_table");
    var tr = table.getElementsByTagName("tr");
    
    // iterate through all table rows, and hide those that didn't match
    for(let i=0; i < tr.length; i++){
        var td = tr[i].getElementsByTagName("td")[0];
        if(td){
            var textValue = td.textContent || td.innerHTML;
            if(textValue.toUpperCase().indexOf(filter) > -1){
                // do nothing to display
                tr[i].style.display = "";
            }else{
                // set display to none
                tr[i].style.display = "none";
            }
        }
    }
}