<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="bean.Book"%>
<%@page import="java.util.ArrayList"%>
<%
    // disable the cache to page to disable any page content in the cache
    // clearing the cache
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
    response.setHeader("Pragma", "no-cache"); // Http 1.0
    if(session.getAttribute("member") == null){
        response.sendRedirect("index.jsp");
    }
%>
<%@include file="includes/header.jsp" %>
        <div class="container">
            <div id="alert_placeholder"></div>
            <div>
                <fieldset>
                    <legend>Books</legend>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Book</th>
                                <th scope="col">Author</th>
                                <th scope="col">Category</th>
                                <th scope="col">ISBN</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Book> booksArrayList = (ArrayList<Book>) session.getAttribute("bookArrayList");
                                Member memberObj = (Member) session.getAttribute("member");
                                if(booksArrayList != null){
                            %>
                                <% for(int i=0; i < booksArrayList.size(); i++){%>
                                    <% if(booksArrayList.get(i).getIs_issued() == 0){%>
                                        <tr>
                                            <th class="row"><%=booksArrayList.get(i).getId()%></th>
                                            <td><%=booksArrayList.get(i).getName()%></td>
                                            <td><%=booksArrayList.get(i).getAuthor()%></td>
                                            <td><%=booksArrayList.get(i).getCategory().getCategory()%></td>
                                            <td><%=booksArrayList.get(i).getISBN()%></td>
                                            <%
                                                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
                                                LocalDateTime localDateTime = LocalDateTime.now();
                                                String datetime = dateTimeFormatter.format(localDateTime);
                                            %>
                                            <td><button class="btn btn-outline-primary" onclick="addmemberload([<%=booksArrayList.get(i).getId()%>,1,<%=memberObj.getId()%>,'<%=datetime%>'])">Loan Book</button></td>
                                        </tr>
                                    <% }%>
                                <% }%>
                            <% }%>
                        </tbody>
                    </table>
                </fieldset>
            </div>
        </div>
    </body>
    <script src="JS/memberloan.js"></script>
</html>