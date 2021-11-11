/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function open_description(task_description){
    document.getElementById('task_description_para').innerHTML = task_description;
    $("#task_description_modal").modal("show");
}

function load_edit_task_modal(task_object){
    document.getElementById('edit_task_modal_title').innerHTML = task_object['id'];
    document.getElementById('edit_task_id').value = task_object['id'];
    document.getElementById('edit_task_name').value = task_object['name'];
    document.getElementById('edit_task_description').value = task_object['description'];
    document.getElementById('edit_task_duration').value = task_object['duration'];
    let created_at = task_object['created_at'].split(' ');
    let updated_at = task_object['updated_at'].split(' ');
    document.getElementById('created_at_date').value = created_at[0];
    document.getElementById('created_at_time').value = created_at[1];
    document.getElementById('updated_at_date').value = updated_at[0];
    document.getElementById('updated_at_time').value = updated_at[1];
    $("#edit_task_modal").modal("show");
}

function insert_task_modal_submit(){
    let form = document.getElementById("insert_task_form");
    
    let task_name = document.getElementById("insert_task_name").value;
    let task_description = document.getElementById("insert_task_description").value;
    let task_duration = document.getElementById("insert_task_duration").value;
    
    // check if any of the variable is empty 
    if(task_name === "" || task_description === "" || task_duration === ""){
        document.getElementById("insert_task_modal_alert").style.display = "block";
    }else{
        form.submit();
    }
}

function edit_task_modal_submit(){
    let form = document.getElementById("edit_task_form");
    
    let task_name = document.getElementById("edit_task_name").value;
    let task_description = document.getElementById("edit_task_description").value;
    let task_duration = document.getElementById("edit_task_duration").value;
    
    // check if any of the variable is empty 
    if(task_name === "" || task_description === "" || task_duration === ""){
        document.getElementById("edit_task_modal_alert").style.display = "block";
    }else{
        form.submit();
    }
}

function insert_task_increament(){
    var duration = parseInt(document.getElementById('insert_task_duration').value);
    duration += 15;
    document.getElementById('insert_task_duration').value = duration;
}

function edit_task_increment(){
    var duration = parseInt(document.getElementById("edit_task_duration").value);
    duration += 15;
    document.getElementById("edit_task_duration").value = duration;
}

function edit_task_decrement(){
    var duration = parseInt(document.getElementById("edit_task_duration").value);
    duration -= 15;
    
    if(duration >= 30){
        document.getElementById("edit_task_duration").value = duration;
    }
}

function insert_task_decrement(){
    var duration = parseInt(document.getElementById('insert_task_duration').value);
    
    duration -= 15;
    
    if(duration >= 30){
        document.getElementById('insert_task_duration').value = duration;
    }
}


function open_task_delete_modal(link){
    document.getElementById("delete_task_link").value = link;
    $("#task_delete_modal").modal("show");
}

function confirm_delete(){
    var link = document.getElementById("delete_task_link").value;
    window.location.replace(link);
}