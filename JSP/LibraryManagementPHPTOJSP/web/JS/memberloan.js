/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function addmemberload(book_loan_array){
    var bookId = book_loan_array[0];
    var personnelId = book_loan_array[1];
    var memberId = book_loan_array[2];
    var dateTime = book_loan_array[3];
    
    var headers = new Headers();
    headers.append("Content-Type", "application/x-www-form-urlencoded");
    
    var urlencoded = new URLSearchParams();
    urlencoded.append("book_id", bookId);
    urlencoded.append("personnel_id", personnelId);
    urlencoded.append("member_id", memberId);
    urlencoded.append("date_time", dateTime);
    
    fetch("member_loan_servlet", {
            method: 'post',
            headers: headers,
            body: urlencoded,
            redirect: 'follow' 
    }).then(response => response.json())
    .then(data => {
        if(data === "member_loan_failed"){
            alert_type = "danger";
            message = "Sorry the Loan was not assigned due to some problem";
            $("#alert_placeholder").html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
        }else if(data === "member_loan_success"){
            alert_type = "success";
            message = "Loan Assigned Successfully";
            $("#alert_placeholder").html('<div class="alert alert-'+alert_type+'"><a class="close" data-dismiss="alert">&times;</a><span>'+message+'</span></div>');
            window.location.replace("member_servlet");
        }
    });
}