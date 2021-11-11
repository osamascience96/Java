/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function redirect(type){
    if (type === 'employee'){
        window.location.replace("employee_servlet");
    }else if(type === 'teams'){
        window.location.replace("team_servlet");
    }else if(type === 'tasks'){
        window.location.replace("task_servlet");
    }else if(type === 'jobs'){
        window.location.replace("job_servlet");
    }
}