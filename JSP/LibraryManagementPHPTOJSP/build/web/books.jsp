<%@page import="bean.Category"%>
<%@page import="bean.Book"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<div class="container">
    <form action="books_admin_servlet" method="post">
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
                        ArrayList<Book> booksArrayList = (ArrayList<Book>) session.getAttribute("booksadminlist");
                        if(booksArrayList != null){
                    %>
                        <% for(int i=0; i < booksArrayList.size(); i++){%>
                            <tr>
                                <th scope="row"><%=booksArrayList.get(i).getId()%></th>
                                <td><%=booksArrayList.get(i).getName()%></td>
                                <td><%=booksArrayList.get(i).getAuthor()%></td>
                                <td><%=booksArrayList.get(i).getCategory().getCategory()%></td>
                                <td><%=booksArrayList.get(i).getISBN()%></td>
                                <td class="text-center"> <a class="text-danger" href="delete_book_servlet?book_id=<%=booksArrayList.get(i).getId()%>">Delete</a> </td>
                            </tr>
                        <% }%>
                        <tr>
                            <th scope="row"></th>
                            <td><input name="inputBook" type="text" class="form-control" id="inputBook" required placeholder="Book" maxlength="100"></td>
                            <td><input name="inputAuthor" type="text" class="form-control" id="inputAuthor" required placeholder="Author" maxlength="50"></td>
                            <td>
                                <select name="inputCategory" class="form-control" id="inputCategory" placeholder="Category" required>
                                    <%
                                        ArrayList<Category> categoryArrayList = (ArrayList<Category>) session.getAttribute("categorieslist");
                                        if(categoryArrayList != null){
                                    %>
                                        <% for(int i=0; i < categoryArrayList.size(); i++){%>
                                            <option value="<%=categoryArrayList.get(i).getId()%>"><%=categoryArrayList.get(i).getCategory()%></option>
                                        <% }%>
                                    <% }%> 
                                </select>
                            </td>
                            <td><input name="inputISBN" type="text" class="form-control" id="inputISBN" required placeholder="ISBN" maxlength="10" pattern="[0-9]*"></td>
                            <td><input type="submit" class="btn btn-primary btn-block" value="Add"/></td>
                        </tr>
                    <% }%>
                </tbody>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>