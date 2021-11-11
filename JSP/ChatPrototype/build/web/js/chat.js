/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var chat_area =  document.getElementById("chat_area").innerHTML;

async function ExecuteTimeForChat(){
    // fetching the chat on O(n) that is the worst case when the size of the chat increases and not an ideal solution.
    // function that fetch the chat after every 1/2 secs
    setTimeout(function(){
        var response = fetch("chat_api").then((response) => response.json()).then(data => {
            var string = "";
            for(let i=0; i < data.length; i++){
                var user_obj = data[i];
                string += user_obj['username'] + ": " + user_obj['comment'] + "\n";
            }
            $("#chat_area").html(string);
            ExecuteTimeForChat();
        }); 
    }, 500);
}

ExecuteTimeForChat();