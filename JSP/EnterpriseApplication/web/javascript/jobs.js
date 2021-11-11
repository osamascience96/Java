/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function insert_job_form_modal(form){
    
    var clients_array = document.getElementById("client_array").value;
    var teams_array = document.getElementById("teams_array").value;
    var tasks_array = document.getElementById("tasks_array").value;
    
    var description = document.getElementById("description").value;
    var comments = document.getElementById("comment").value;
    
    var start_date = document.getElementById("start_date").value;
    var start_time = document.getElementById("start_time").value;
    
    var end_date = document.getElementById("end_date").value;
    var end_time = document.getElementById("end_time").value;
    
    if(clients_array == "" || teams_array == "" || tasks_array == "" || description == "" || start_date == "" || start_time == "" || end_date == "" || end_time == ""){
        document.getElementById("insert_job_modal_alert").style.display = "block";
    }else{
        // compare the date and time
        if(new Date(start_date + " " + start_time) < new Date(end_date + " " + end_time)){
            form.submit();
        }else{
            document.getElementById("insert_client_datetime_error_alert").style.display = "block";
        }
    }
}


function open_task_list_modal(jobtasklist){
    var taskList_table_body = document.getElementById("tasklist_table_body");
    
    for(let i=0; i < jobtasklist.length; i++){
        var row = taskList_table_body.insertRow();
        
        var idcell = row.insertCell();
        var task_name_cell = row.insertCell();
        var task_duration_cell = row.insertCell();
        
        idcell.appendChild(document.createTextNode(jobtasklist[i]['taskid']));
        task_name_cell.appendChild(document.createTextNode(jobtasklist[i]['taskname']));
        task_duration_cell.appendChild(document.createTextNode(jobtasklist[i]['duration']));
    }
    $("#tasks_list_modal").modal("show");
}

function open_description_modal(description){
    document.getElementById("description_text").innerHTML = description;
    $("#job_description_modal").modal("show");
}

function open_comments_modal(comments){
    document.getElementById("comments_text").innerHTML = comments;
    $("#job_comments_modal").modal("show");
}

function open_add_comment_form_modal(job_id){
    document.getElementById("job_id_add_comment").value = job_id;
    $('#job_add_comment_modal').modal('show')
}

function open_delete_modal(link){
    document.getElementById("delete_job_link").value = link;
    $("#job_delete_modal").modal("show");
}

function open_finish_modal(link){
    document.getElementById("finish_job_link").value = link;
    $("#job_finish_modal").modal("show");
}

function confirm_finsih(){
    var link = document.getElementById("finish_job_link").value;
    window.location.replace(link);
}

function confirm_delete(){
    var link = document.getElementById("delete_job_link").value;
    window.location.replace(link);
}

function add_comment_submit_form(form){
    var comments = document.getElementById("add_comment_input").value;
    
    if(!(comments === "")){
        form.submit();
    }
}

function empty_table_body(){
    $("#tasklist_table_body").empty();
}
