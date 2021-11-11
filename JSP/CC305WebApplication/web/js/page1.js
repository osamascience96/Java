/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function reset(){
    document.getElementById("forst_name").value = "";
    document.getElementById("last_name").value = "";
    document.getElementById("email").value = "";
    document.getElementById("male").checked = false;
    document.getElementById("female").checked = false;
}

function submit(){
    document.getElementById("htmlform").submit();
}