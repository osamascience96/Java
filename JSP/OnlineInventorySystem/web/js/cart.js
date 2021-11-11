/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function addcart(id, name, price){
    var headers = new Headers();
    headers.append("Content-Type", "application/x-www-form-urlencoded");

    var urlencoded = new URLSearchParams();
    urlencoded.append("id", id);
    urlencoded.append("name", name);
    urlencoded.append("price", price);
    
     fetch('cart_controller', {
                method: 'post',
                headers: headers,
                body: urlencoded,
                redirect: 'follow'
        }).then(response => response.json())
        .then(result => {
            $("#cart_count").html(result.length);
        });
}