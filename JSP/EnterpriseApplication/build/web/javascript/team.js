/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function open_team_member_scale_modal(team_scale, team_id){
    document.getElementById('team_member_scale').value = team_scale;
    document.getElementById('team_scale_team_id_form').value = team_id;
    $("#team_member_scale_modal").modal("show");
}

function open_team_members_modal(team_members_array){
    var list = document.getElementById("show_team_members_modal");
    // iterate throught the memebers list 
    for(let i=0; i < team_members_array.length; i++){
        var li = document.createElement("li");
        li.classList.add("list-group-item");
        li.appendChild(document.createTextNode(team_members_array[i]));
        list.appendChild(li);
    }
    $("#show_members_modal").modal("show");
}


function open_edit_team_modal(team_object){
    document.getElementById('edit_team_modal_title').innerHTML = team_object['id'];
    document.getElementById('team_member_id').value = team_object['id'];
    document.getElementById('edit_team_name').value = team_object['team_name'];
    if(team_object['is_on_call'] === 1){
        document.getElementById('on_call_active').checked = true;
    }else{
        document.getElementById('on_call_deactive').checked = true;
    }
    
    var un_ordered_list = document.getElementById('team_members_edit_modal');
    for(let i = 0; i < team_object['pre_employee_list'].length; i++){
        var li = document.createElement("li");
        li.classList.add("list-group-item");
        li.appendChild(document.createTextNode(team_object['pre_employee_list'][i]));
        un_ordered_list.appendChild(li);
    }
    
    let team_members_space_scale = team_object['team_members'];
    let team_members_current_size = team_object['pre_employee_list'].length;
    
    let final_scale = team_members_space_scale - team_members_current_size;
    
    var selection_box_team_members = document.getElementById('team_members_edit_select_options');
    var free_employees_size = document.getElementById("free_emps").value;
    
    if(selection_box_team_members != null){
        if(free_employees_size != 0){
            if(final_scale <= 0){
                selection_box_team_members.style.display = "none";
            }else{
                selection_box_team_members.style.display = "block";
            }
        }else{
            selection_box_team_members.style.display = "none";
        }
    }
    
    document.getElementById('final_team_scale').value = final_scale;
    
    $("#edit_team_modal").modal("show");
}

function reset_edit_modal(){
    // empty team member list 
    var un_ordered_list = document.getElementById('team_members_edit_modal');
    $(un_ordered_list).empty();
    $("#show_team_members_modal").empty();
}

function update_team_member_scale(){
    let team_member_form = document.getElementById("team_member_form");
    
    let scale_value = document.getElementById("team_member_scale").value;
    if(scale_value != ""){
        team_member_form.submit();
    }else{
        document.getElementById("team_member_scale_alert_message").innerHTML = "Empty Team Scale";
        document.getElementById("team_member_scale_alert").style.display = "block";
    }
}

function insert_team_member_form(){
    let insert_team_form = document.getElementById("insert_team_form");
    
    let insert_team_form_alert_error = document.getElementById("insert_team_error_alert");
    
    let team_name = document.getElementById("insert_team_name_input").value;
    let on_call_option = document.getElementById("insert_input_on_call");
    let off_call_option = document.getElementById("insert_input_off_call");
    let final_selected_radion = undefined;
    
    if(on_call_option.checked){
        final_selected_radion = on_call_option.value;
    }else if(off_call_option.checked){
        final_selected_radion = off_call_option.value;
    }
    
    var employee_array = document.getElementById("employee_array");
    if(team_name == "" || final_selected_radion == undefined){
        insert_team_form_alert_error.style.display = "block";
    }else{
        if(employee_array != null){
            if(employee_array.length > 0){
                insert_team_form.submit();
            }else{
                document.getElementById("insert_team_select_alert").style.display = "block";
            }
        }else{
            document.getElementById("insert_team_select_available_alert").style.display = "block";
        }
    }
}

function edit_team_member_form(){
    let edit_team_form = document.getElementById('edit_team_modal_form');
    
    let edit_team_form_alert_error = document.getElementById("edit_team_error_alert");
    
    let team_name = document.getElementById("edit_team_name").value;
    let on_call_option = document.getElementById("on_call_active");
    let off_call_option = document.getElementById("on_call_deactive");
    let final_selected_radion = undefined;
    
    if(on_call_option.checked){
        final_selected_radion = on_call_option.value;
    }else if(off_call_option.checked){
        final_selected_radion = off_call_option.value;
    }
    
    if(team_name == "" || final_selected_radion == undefined){
        edit_team_form_alert_error.style.display = "block";
    }else{
        edit_team_form.submit();
    }
}

function open_team_delete_modal(link){
    document.getElementById('delete_team_link').value = link;
    $("#team_delete_modal").modal("show");
}

function confirm_delete(){
    var link = document.getElementById('delete_team_link').value;
    window.location.replace(link);
}