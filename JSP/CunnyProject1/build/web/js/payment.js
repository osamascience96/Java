/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


async function paymentMethod(timesheetID){
    var paymentType = document.getElementById("paymentmethod").value;
    
    var headers = new Headers();
    headers.append("Content-Type", "application/x-www-form-urlencoded");
    
    var urlencoded = new URLSearchParams();
    urlencoded.append("paymentType", paymentType);
    urlencoded.append("timesheetID", timesheetID);
    
    fetch('pay_type_controller', {
        method: 'post',
        headers: headers,
        body: urlencoded,
        redirect: 'follow'
    }).then(response => response.json())
    .then(result => {
        if(result === "payment_method_update_done"){
            window.location.replace("log_employee_controller");
        }
    });
}