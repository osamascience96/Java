/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// regex learned from w3 resource
var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+")){7,}@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
var candadian_phone_regex = /1[0-9]{10}$/;

function open_address_modal(address){
    document.getElementById("client_address_modal_text").innerHTML = address;
    $("#client_address_modal").modal("show");
}

function open_edit_client_modal(client_obj){
    document.getElementById('edit_client_modal_title').innerHTML = client_obj['id'];
    document.getElementById('client_id').value = client_obj['id'];
    document.getElementById('edit_client_name').value = client_obj['name'];
    document.getElementById('edit_client_address').value = client_obj['address'];
    document.getElementById('edit_client_email').value = client_obj['email'];
    document.getElementById('edit_client_phone').value = client_obj['phone'];
    let created_at = client_obj['created_at'].split(" ");
    let updated_at = client_obj['updated_at'].split(" ");
    document.getElementById('created_at_date').value = created_at[0];
    document.getElementById('created_at_time').value = created_at[1];
    document.getElementById('updated_at_date').value = updated_at[0];
    document.getElementById('updated_at_time').value = updated_at[1];
    $("#edit_client_modal").modal("show");
}

function insert_client_form(){
    let client_form = document.getElementById("client_add_form_modal");
    
    let client_alert_error = document.getElementById("insert_client_error_alert");
    let email_alert = document.getElementById("insert_client_email_alert");
    let phone_alert = document.getElementById("insert_client_phone_alert");
    let phone_regex_alert = document.getElementById("insert_client_phone_regex_alert");
    
    let client_name = document.getElementById("client_name").value;
    let client_address = document.getElementById("client_address").value;
    let client_email = document.getElementById("client_email").value;
    let client_phone = document.getElementById("client_phone").value;
    
    if(client_name === "" || client_address === "" || client_email === "" || client_phone === ""){
        client_alert_error.style.display = "block";
    }else{
        if((email_regex.test(client_email) === true) && (client_phone.length >= 7 && client_phone.length <= 15) && (candadian_phone_regex.test(client_phone) === true)){
            client_form.submit();
        }
        
        if(!(client_phone.length >= 7 && client_phone.length <= 15)){
            phone_alert.style.display = "block";
        } 
        
        if(email_regex.test(client_email) === false){
            email_alert.style.display = "block";
        }
        
        if(candadian_phone_regex.test(client_phone) === false){
            phone_regex_alert.style.display = "block"
        }
    }
}

function edit_client_form(){
    let client_form = document.getElementById("client_edit_form_modal");
    
    let client_alert_error = document.getElementById("edit_client_error_alert");
    let client_email_alert = document.getElementById("edit_client_email_alert");
    let phone_alert = document.getElementById("edit_client_phone_alert");
    let phone_regex_alert = document.getElementById("edit_client_phone_regex_alert");
    
    let client_name = document.getElementById("edit_client_name").value;
    let client_address = document.getElementById("edit_client_address").value;
    let client_email = document.getElementById("edit_client_email").value;
    let client_phone = document.getElementById("edit_client_phone").value;
    
    if(client_name === "" || client_address === "" || client_email === "" || client_phone === ""){
        client_alert_error.style.display = "block";
    }else{
        if((email_regex.test(client_email) === true) && (client_phone.length >= 7 && client_phone.length <= 15)  && (candadian_phone_regex.test(client_phone) === true)){
            client_form.submit();
        }
        
        if(!(client_phone.length >= 7 && client_phone.length <= 15)){
            phone_alert.style.display = "block";
        }
        
        if(email_regex.test(client_email) === false){
            client_email_alert.style.display = "block";
        }
        
        if(candadian_phone_regex.test(client_phone) === false){
            phone_regex_alert.style.display = "block"
        }
    }
}

function open_client_delete_modal(link){
    document.getElementById("delete_client_link").value = link;
    $("#client_delete_modal").modal("show");
}

function confirm_delete(){
    var link = document.getElementById("delete_client_link").value;
    window.location.replace(link);
}

function search_clients(){
    var inputSearch = document.getElementById("search_client_input");
    var filter = inputSearch.value.toUpperCase();
    var table = document.getElementById("client_table");
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