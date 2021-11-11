/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#employee_select").on('change', function(){
    let employeeId = document.getElementById("employee_select").value;
    $("#logs").html("");
    $("#totalprice").html("");
    GetEmployeeLogs(employeeId);
});

async function GetEmployeeLogs(employeeId){
    var headers = new Headers();
    headers.append("Content-Type", "application/x-www-form-urlencoded");
    
    var urlencoded = new URLSearchParams();
    urlencoded.append("employeeId", employeeId);
    
    fetch('log_employee_controller', {
        method: 'post',
        headers: headers,
        body: urlencoded,
        redirect: 'follow'
    }).then(response => response.json())
    .then(result => {
        console.log(result);
        if(result.length > 0){
            let totalPrice = 0.0;
            for(let i=0; i < result.length; i++){
                let startdatetime = result[i]['startTime'].split(" ");
                let enddatetime = result[i]['endTime'].split(" ");
                
                totalPrice += result[i]['payAmount'];
                
                var view = "<div class='col card text-center'>\n\
                    <div class='card-header'>\n\
                        <h5>Log No: "+(i+1)+"</h5>\n\
                    </div>\n\
                    <div class='card-body'>\n\
                        <div class='row'>\n\
                            <div class='col'>\n\
                                <label class='float-left'>Start Date and Time</label>\n\
                                <div class='form-group'>\n\
                                    <input type='date' id='startdate' class='form-control' value='"+startdatetime[0]+"' placeholder='Start Date'>\n\
                                </div>\n\
                                <div class='form-group'>\n\
                                    <input type='time' id='starttime' class='form-control' value='"+startdatetime[1]+"' placeholder='Start Time'>\n\
                                </div>\n\
                            </div>\n\
                            <div class='col'>\n\
                                <label class='float-left'>End Date and Time</label>\n\
                                <div class='form-group'>\n\
                                    <input type='date' id='enddate' class='form-control' value='"+enddatetime[0]+"' placeholder='End Date'>\n\
                                </div>\n\
                                <div class='form-group'>\n\
                                    <input type='time' id='endtime' class='form-control' value='"+enddatetime[1]+"' placeholder='End Time'>\n\
                                </div>\n\
                            </div>\n\
                        </div>\n\
                        <h5 class='float-left'>Payment Type: <span class='text-info'> $"+result[i]['payAmount']+"</span></h5>\n\
                        <a href='pay_type_controller?timesheetid="+result[i]['timesheetId']+"' class='btn btn-outline-success float-right'>Edit Payment Type</a>\n\
                    </div>\n\
                </div>";
                
                $("#logs").append(view);
            }
            $("#totalprice").html("<h5 class='text-primary mx-auto'>Total Price $"+totalPrice+"</h5>");
        }else{
            $("#logs").append("<h5 class='text-danger mx-auto'>No Record Found</h5>");
        }
    });
}