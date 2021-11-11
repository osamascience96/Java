/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function cart(id){
    var headers = new Headers();
    headers.append("Content-Type", "application/x-www-form-urlencoded");
    
    var urlencoded = new URLSearchParams();
    urlencoded.append("id", id);
    
    fetch("cart_controller", {
        method: 'post',
        headers: headers,
        body: urlencoded,
        redirect: 'follow'
    }).then(response => response.json())
    .then(result => {
        if(result === "session_timeout"){
            alert_type = "danger";
            message = "Login to Add to Cart";
            $('#alert_placeholder_product_message').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else{
            $("#cart_count").html(result.length);
        }
    });
}