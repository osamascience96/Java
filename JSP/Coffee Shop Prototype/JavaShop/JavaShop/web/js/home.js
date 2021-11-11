/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function open_cart_modal(product){
    document.getElementById("product_Id_cartmodal").value = product['product_id'];
    document.getElementById("price_cart_modal").value = product['price'];
    document.getElementById("quantity_cart_modal").value = product['quantity'];
    $("#cart_modal").modal("show");
}

function insert_cart(){
    let form = document.getElementById("cart_form");
    
    var product_id = document.getElementById("product_Id_cartmodal").value;
    var price = document.getElementById("price_cart_modal").value;
    var quantity = document.getElementById("quantity_cart_modal").value;
    
    if(product_id === "" || price === "" || quantity === ""){
        document.getElementById("message").innerHTML = "All values including Product Id, Price and Quantity must not be empty";
        $("#message_modal").modal("show");
    }else{
        let ratio = parseInt(quantity);
        
        if(ratio > 0){
            form.submit();
        }else{
            document.getElementById("message").innerHTML = "Quanitity must be greater than 0";
            $("#message_modal").modal("show");  
        }
    }
}