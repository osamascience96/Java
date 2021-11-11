/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function add_category(){
    var message = "";
    
    var form = document.getElementById("category_form");
    
    let category_name = document.getElementById("category_name").value;
    let category_description = document.getElementById("category_description").value;
    
    // check if the value of both is empty 
    if(category_description === "" || category_name === ""){
        message = "All text fields must be filled in order for the customer to take interest";
        $("#alert_placeholder_category_modal").html('<div class="alert alert-danger"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>')
    }else{
        // submit the form 
        form.submit();
    }
}

function add_product(){
    var message = "";
    
    var form = document.getElementById("product_form");
    
    let product_name = document.getElementById("product_name").value;
    let product_description = document.getElementById("product_description").value;
    let product_price = document.getElementById("product_price").value;
    
    // check if the value of both is empty 
    if(product_name === "" || product_description === "" || product_price === ""){
        message = "Please fill up all the textfields.";
        $("#alert_placeholder_product_modal").html('<div class="alert alert-danger"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>')
    }else{
        // submit the form 
        form.submit();
    }
}