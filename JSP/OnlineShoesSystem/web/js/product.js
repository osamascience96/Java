/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function GetProduct(categoryId){
    $("#product_view").empty();
    
    var headers = new Headers();
    headers.append("Content-Type", "application/x-www-form-urlencoded");
    
    var urlencoded = new URLSearchParams();
    urlencoded.append("category_Id", categoryId);
    
    fetch('product_api_servlet', {
        method: 'post',
        headers: headers,
        body: urlencoded,
        redirect: 'follow'
    }).then(response => response.json())
    .then(data => {
        for(let i=0; i < data.length; i++){
            let encodedImageData = btoa(new Uint8Array(data[i]['image']['binaryData']).reduce(function (data, byte) {
                return data + String.fromCharCode(byte);
            }, ''));
            
            let imageString = data[i]['image']['binaryData'].length > 0 ? "data:image/jpg;base64,"+encodedImageData : "img/defaultproduct.jpg";
            
            var cardView = "<div class='col'>\n\
            <div class='card' style='width: 18rem;'>\n\
            <img class='card-img-top' height='200' src='"+imageString+"' alt='Card image cap'>\n\
            <div class='card-body'>\n\
            <h5 class='card-title'>"+data[i]['name']+"</h5>\n\
            <p class='card-text'>"+data[i]['description']+"</p>\n\
            <p class='card-text'>$"+data[i]['price']+"</p>\n\
            <button class='btn btn-outline-primary btn-block' onclick='cart("+data[i]['id']+")'>Add to Card</button></div></div></div>";
            
            $("#product_view").append(cardView);
        }
    });
}