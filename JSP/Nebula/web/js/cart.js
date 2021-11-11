/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function addtocart(userId, productId){
    let cartCount = document.getElementById("cart_count");
    
    var header = new Headers();
    header.append("Content-Type", "application/x-www-form-urlencoded");

    var urlencoded = new URLSearchParams();
    urlencoded.append("userid", userId);
    urlencoded.append("productId", productId);

    var requestOptions = {
      method: 'POST',
      headers: header,
      body: urlencoded,
      redirect: 'follow'
    };

    fetch("cart_servlet_api_controller", requestOptions)
      .then(response => response.json())
      .then(result => {
          let quantity = 0;

          for(let i=0; i < result.length; i++){
              quantity += result[i]['quantity'];
          }
          
          cartCount.innerHTML = quantity;
      }).catch(error => console.log('error', error));
}