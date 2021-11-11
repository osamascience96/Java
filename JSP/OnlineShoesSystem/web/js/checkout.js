/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function checkout(){
    var headers = new Headers();
    headers.append("Content-Type", "application/x-www-form-urlencoded");
    
    var urlencoded = new URLSearchParams();
    urlencoded.append("checkout", true);
    
    fetch("checkout_servlet", {
        method: 'post',
        headers: headers,
        body: urlencoded,
        redirect: 'follow',
    }).then(response => response.json())
    .then(result => {
        if(result === "no_list"){
            alert_type = "danger";
            message = "Not Verified Checkout Request";
            $('#alert_placeholder_login').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else if(result === "insert_success"){
            alert_type = "success";
            message = "Order Created Successfully";
            $('#alert_checkout_placeholder').html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            window.location.replace("index.jsp");
        }
    });
}