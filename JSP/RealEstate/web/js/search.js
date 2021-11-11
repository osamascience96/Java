/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    $("#input").on("keyup", function(){
        var value = $(this).val().toLowerCase();
        $("#bodyTable tr").filter(function(){
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
        });
    });
});