<%@page import="Pojo.Comment"%>
<%@page import="java.util.Stack"%>
<%@include file="includes/header.jsp"%>
<title>Home</title>
</head>
<body>
    <%@include file="includes/navigation.jsp" %>
    <%
        String send_chat_response = request.getParameter("response");
        if(send_chat_response != null){
    %>
        <%
            if(send_chat_response.compareTo("not_login") == 0){
        %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Error!</strong> Kindly login before sending comment.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
    <% }%>
    <div class="container" style="margin-top: 10px;">
        <form action="send_chat" method="POST">
            <div class="form-group">
                <input class="form-control" type="text" name="comment" placeholder="Comment" />
            </div>
            <%
                Stack<Comment> stackComment = (Stack<Comment>) application.getAttribute("comment_stack");
                String chat = "";
                // check if the stackComment is not null,
                if(stackComment != null){
                    for(int i = 0; i < stackComment.size(); i++){
                        chat = chat.concat(stackComment.get(i).GetUsername() + ": " + stackComment.get(i).GetComment()).concat("\n");
                    }
                }
            %>
            <div class="form-group">
                <textarea id="chat_area" class="form-control" rows="10" cols="10" placeholder="Your Chat" readonly><%=chat%></textarea>
            </div>
        </form>
    </div>
<%@include file="includes/footer.jsp" %>
<script src="js/chat.js"></script>
</body>
</html>