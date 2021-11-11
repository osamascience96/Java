/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function check_add_tweet(form){
    let post_text = document.getElementById("twet_text").value;
    
    if(post_text === ""){
        document.getElementById("alert_message").innerHTML = "Kindly write some text for tweet";
        document.getElementById("alert_message").style.display = "block";
    }else{
        form.submit();
    }
}

// like async function
async function handle_like(tweet_id){
    
    var header = new Headers();
    header.append("Content-Type", "application/x-www-form-urlencoded");
    
    let liked = document.getElementById("is_liked_"+tweet_id);
    
    let urlencoded = new URLSearchParams();
    urlencoded.append('tweet_id', tweet_id);
    urlencoded.append('ratio_type', liked.value === 'true' ? 'decrement' : 'increment');
    
    fetch("likes_api", {
        method: 'post',
        headers: header,
        body: urlencoded,
        redirect: 'follow',
    }).then(response => response.json())
    .then(function(data){
        var count = data['likes_count'];
        $("#likecount_"+tweet_id).html(count);
        $("#dislikecount_"+tweet_id).html(data['unlikes_count']);
        if(liked.value === 'true'){
            liked.value = 'false';
        }else{
            liked.value = 'true';
        }
    });
}

// unlike async function
async function handle_unlike(tweet_id){
    
    var header = new Headers();
    header.append("Content-Type", "application/x-www-form-urlencoded");
    
    let unliked = document.getElementById("is_unliked_"+tweet_id);
    
    let urlencoded = new URLSearchParams();
    urlencoded.append('tweet_id', tweet_id);
    urlencoded.append('ratio_type', unliked.value === 'true' ? 'decrement' : 'increment');
    
    fetch("dislikes_api", {
        method: 'post',
        headers: header,
        body: urlencoded,
        redirect: 'follow',
    }).then(response => response.json())
    .then(function(data){
        var count = data['unlikes_count'];
        $("#dislikecount_"+tweet_id).html(count);
        $("#likecount_"+tweet_id).html(data['likes_count']);
        if(unliked.value === 'true'){
            unliked.value = 'false';
        }else{
            unliked.value = 'true';
        }
    });
}

// async follow function 
async function followuser(userid, followuserid){
    var header = new Headers();
    header.append("Content-Type", "application/x-www-form-urlencoded");
    
    let urlencoded = new URLSearchParams();
    urlencoded.append("userId", userid);
    urlencoded.append("followuserid", followuserid);
    
    fetch("follow_servlet", {
        method: 'post',
        headers: header,
        body: urlencoded,
        redirect: 'follow',
    }).then(() => {
        window.location.replace("tweet_controller?user_id_response="+userid);
    });
}

// async unfollow function
async function unfollowuser(userid, followuserid){
    var header = new Headers();
    header.append("Content-Type", "application/x-www-form-urlencoded");
    
    let urlencoded = new URLSearchParams();
    urlencoded.append("userId", userid);
    urlencoded.append("followuserid", followuserid);
    
    fetch("unfollow_servlet", {
        method: 'post',
        headers: header,
        body: urlencoded,
        redirect: 'follow',
    }).then(() => {
        window.location.replace("tweet_controller?user_id_response="+userid);
    });
}


async function ExecuteTimeforTweets(){
    setTimeout(function(){
        fetch("getalltweets_servlet", {
            method: 'get',
        }).then(response => response.json())
        .then(function(data){
            if(tweetList != data.length){
                tweetList = data.length;
                let encodedImageData = btoa(String.fromCharCode.apply(null, new Uint8Array(data[data.length - 1]['image']['binaryData'])));
                let imageString = data[data.length-1]['image']['binaryData'].length > 0 ? "<img class='rounded mx-auto d-block w-100 p-3' alt='tweet_img' src='data:image/jpg;base64,"+encodedImageData+"'>" : "";
                let media = "<div class='media'> \n\
                    <div class='media-body'> \n\
                    <div class='mt-0'> "+data[data.length-1]['userObj']['username']+" </div>  \n\
                    "+data[data.length-1]['tweet_text']+"\n\
                    <div class='w-100'></div>\n\
                    "+imageString+"\
                    <div class='row'>\n\
                    <div>\n\
                    <input type='hidden' id='is_liked_"+data[data.length-1]['id']+"' value='false'>\n\
                    <span id='likecount_"+data[data.length-1]['id']+"'>"+data[data.length-1]['likes_count']+"</span>\n\
                    <button id='like_btn' class='btn btn-outline-primary' onclick='handle_like("+data[data.length-1]['id']+")'><i class='fa fa-thumbs-up' aria-hidden='true'></i></button>\n\
                    </div>\n\
                    &nbsp;\n\
                    <div>\n\
                    <input type='hidden' id='is_unliked_"+data[data.length-1]['id']+"' value='false'>\n\
                    <span id='dislikecount_"+data[data.length-1]['id']+"'>"+data[data.length-1]['unlikes_count']+"</span>\n\
                    <button id='dislike_btn' class='btn btn-outline-danger' onclick='handle_unlike("+data[data.length-1]['id']+")'><i class='fa fa-thumbs-down' aria-hidden='true'></i></button>\n\
                    </div>\n\
                    </div>\n\
                    </div> \n\
                    </div>";
                $("#media_tweet_section").append(media);
            }
            
            // updating likes and dislikes on every iteration 
            for(let i=0; i < data.length; i++){
                $("#likecount_"+data[i]['id']).html(data[i]['likes_count']);
                $("#dislikecount_"+data[i]['id']).html(data[i]['unlikes_count']);
            }
            
            ExecuteTimeforTweets();
        });
    }, 800);
}

ExecuteTimeforTweets();