/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function AddCart(id){
    var header = new Headers();
    header.append("Content-Type", "application/x-www-form-urlencoded");
    
    let urlencoded = new URLSearchParams();
    urlencoded.append('id', id);
    
    fetch('add_cart', {
        method: 'post',
        headers: header,
        body: urlencoded,
        redirect: 'follow',
    }).then(response => response.json())
    .then(function(data){
        alert("Cart Items Added: " + data.length);
    });
}