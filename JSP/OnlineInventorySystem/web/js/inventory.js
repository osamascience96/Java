/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function addinventory(){
    var name = document.getElementById("add_inventory_name").value;
    var description = document.getElementById("add_inventory_description").value;
    var price = document.getElementById("add_inventory_price").value;
    
    if(name === "" || description === "" || price === ""){
        alert_type = "danger";
        message = "All fields are required";
        $('#addinventory_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        var headers = new Headers();
        headers.append("Content-Type", "application/x-www-form-urlencoded");
        
        var urlencoded = new URLSearchParams();
        urlencoded.append("action_type", "insert");
        urlencoded.append("name", name);
        urlencoded.append("description", description);
        urlencoded.append("price", price);
        
        fetch('management_controller', {
                method: 'post',
                headers: headers,
                body: urlencoded,
                redirect: 'follow'
        }).then(response => response.json())
        .then(result => {
            if(result === "insert_successfully"){
                alert_type = "success";
                message = "Inventory Added Successfully";
                $('#addinventory_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }
            
            window.location.replace("management_controller");
        });
    }
}

async function editinventory(){
    var id = document.getElementById("edit_inventory_id").value;
    var name = document.getElementById("edit_inventory_name").value;
    var description = document.getElementById("edit_inventory_description").value;
    var price = document.getElementById("edit_inventory_price").value;
    
    if(id === "" || name === "" || description === "" || price === ""){
        alert_type = "danger";
        message = "All fields are required";
        $('#editinventory_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
    }else{
        var headers = new Headers();
        headers.append("Content-Type", "application/x-www-form-urlencoded");
        
        var urlencoded = new URLSearchParams();
        urlencoded.append("action_type", "update");
        urlencoded.append("id", id);
        urlencoded.append("name", name);
        urlencoded.append("description", description);
        urlencoded.append("price", price);
        
        fetch('management_controller', {
                method: 'post',
                headers: headers,
                body: urlencoded,
                redirect: 'follow'
        }).then(response => response.json())
        .then(result => {
            if(result === "update_successfully"){
                alert_type = "success";
                message = "Inventory Updated Successfully";
                $('#editinventory_alert_placehodler').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            }
            
            window.location.replace("management_controller");
        });
    }
}

function open_edit_inventory(id, name, description, price){
    $("#edit_inventory_name").val(name);
    $("#edit_inventory_description").val(description);
    $("#edit_inventory_price").val(price);
    $("#edit_inventory_id").val(id);
    $("#edit_inventory_modal").modal("show");
}