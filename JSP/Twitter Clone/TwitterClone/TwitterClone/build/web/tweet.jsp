<%@page import="java.util.Base64"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Tweet"%>
<%@include file="includes/header.jsp" %>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/tweet.css">
  </head>
  <body>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <%
            // disable the cache to page to disable any page content in the cache
            // clearing the cache
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
            response.setHeader("Pragma", "no-cache"); // Http 1.0
            if(session.getAttribute("is_login") == null || session.getAttribute("userObj") == null){
                response.sendRedirect("index.jsp");
            }
        %>
        <%
            ArrayList<Tweet> tweetArrayList = (ArrayList<Tweet>) session.getAttribute("tweetList");
            User userObj = (User) session.getAttribute("userObj");
        %>
        <%
            if(tweetArrayList != null && userObj != null){
        %>
            <script>
                var tweetList = <%=tweetArrayList.size()%>;
            </script>
            <button id="add_tweet" onclick="$('#addtweet_modal').modal('show')" type="button" class="btn btn-outline-light btn-block">Add Tweet +</button>
            <div id="media_tweet_section">
                <!-- Show Tweets -->
                <%
                    for(int i=0; i < tweetArrayList.size(); i++){
                %>
                    <div class="media">
                        <div class="media-body">
                          <h5 class="mt-0"><%=tweetArrayList.get(i).getUserObj().getUsername()%></h5>
                          <%=tweetArrayList.get(i).getTweet_text()%>
                          <div class="w-100"></div>
                          <%
                              if(tweetArrayList.get(i).getImage().length() != 0){
                          %>
                            <%
                                byte[] imageBytes = tweetArrayList.get(i).getImage().getBytes(1, (int)tweetArrayList.get(i).getImage().length());
                                String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                                String image = "data:image/jpg;base64,".concat(encodedImage);
                            %>

                            <img src="<%=image%>" class="rounded mx-auto d-block w-100 p-3" alt="tweet_img">
                          <%
                              }
                          %>  
                            <div class="row">
                                <div>
                                    <input type="hidden" id="is_liked_<%=tweetArrayList.get(i).getId()%>" value="false">
                                    <span id="likecount_<%=tweetArrayList.get(i).getId()%>"><%=tweetArrayList.get(i).getLikes_count()%></span>
                                    <button id="like_btn" class="btn btn-outline-primary" onclick="handle_like(<%=tweetArrayList.get(i).getId()%>)"><i class="fa fa-thumbs-up" aria-hidden="true"></i></button>
                                </div>
                                &nbsp;
                                <div>
                                    <input type="hidden" id="is_unliked_<%=tweetArrayList.get(i).getId()%>" value="false">
                                    <span id="dislikecount_<%=tweetArrayList.get(i).getId()%>"><%=tweetArrayList.get(i).getUnlikes_count()%></span>
                                    <button id="dislike_btn" class="btn btn-outline-danger" onclick="handle_unlike(<%=tweetArrayList.get(i).getId()%>)"><i class="fa fa-thumbs-down" aria-hidden="true"></i></button> 
                                </div>
                            </div>
                        </div>
                    </div>
                <% }%>
            </div>
        <% }%>
        <%
            String respond = request.getParameter("response");
            if(respond != null){
        %>
            <%
                String alertType = "";
                String alertTitle = "";
                String alertMessage = "";
                
                if(respond.compareTo("username_error") == 0){
                    alertType = "danger";
                    alertTitle = "Error!";
                    alertMessage = "Username must be of 7 characters.";
                }else if(respond.compareTo("password_error") == 0){
                    alertType = "danger";
                    alertTitle = "Error!";
                    alertMessage = "Password must be of 7 characters.";
                }else if(respond.compareTo("user_exists") == 0){
                    alertType = "danger";
                    alertTitle = "Error!";
                    alertMessage = "User already exists";
                }else if(respond.compareTo("registration_success") == 0){
                    alertType = "primary";
                    alertTitle = "Success!";
                    alertMessage = "Twitter Registration Successful";
                }
            %>
            <div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
                <strong><%=alertTitle%></strong> <%=alertMessage%>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
    </div>
    <%@include file="modal/addtweet.jsp" %>
    <%@include file="modal/followuser.jsp" %>
    <%@include file="includes/footer.jsp" %>
    <script src="js/tweet.js"></script>
  </body>
</html>