<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="bean.Book"%>
<%@page import="helper.AES"%>
<%@page import="bean.LoanBook"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp"%>
<div class="container">
        <form action="borrow_servlet" method="post">
            <fieldset>
                <legend>Borrows</legend>
                <table class="table">
                    <thead>
                        <th scope="col">ID.</th>
                        <th scope="col">Member Name</th>
                        <th scope="col">Lent Book</th>
                        <th scope="col">Date of Issue</th>
                        <th scope="col">Time of Issue</th>
                        <th scope="col">Action</th>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<LoanBook> loanbookArrayList = (ArrayList<LoanBook>) session.getAttribute("borrow_admin_list");
                            if(loanbookArrayList != null){
                        %>
                            <% for(int i=0; i < loanbookArrayList.size(); i++){%>
                                <tr>
                                    <th scope="row"><%=loanbookArrayList.get(i).getTransaction_id()%></th>
                                    <td><%=loanbookArrayList.get(i).getMember().getMember_name()%></td>
                                    <td><%=loanbookArrayList.get(i).getBook().getName()%></td>
                                    <td><input type="date" class="form-control" readonly="true" value="<%=loanbookArrayList.get(i).getDateOfIssue().split(" ")[0]%>"></td>
                                    <td><input type="time" class="form-control" readonly="true" value="<%=loanbookArrayList.get(i).getDateOfIssue().split(" ")[1]%>"></td>
                                    <td class="text-center"><a class="text-info" href="update_book_loan_servlet?bookId=<%=loanbookArrayList.get(i).getBook().getId()%>&transaction_id=<%=loanbookArrayList.get(i).getTransaction_id()%>">Return</a></td>
                                </tr>
                            <% }%>
                        <% }%>
                        <tr>
                            <th scope="row"></th>
                            <td>
                                <%
                                    ArrayList<Member> memberArrayList = (ArrayList<Member>)session.getAttribute("member_admin_active_list");
                                    if(memberArrayList != null){
                                %>
                                    <select name="inputMemberID" class="form-control" id="inputMemberID" required>
                                        <% for(int i=0; i < memberArrayList.size(); i++){%>
                                            <option value="<%=memberArrayList.get(i).getId()%>"><%=AES.Decrypt(memberArrayList.get(i).getMember_name())%></option>
                                        <% }%>
                                    </select>
                                <% }%>
                            </td>
                            <td>
                                <%
                                    ArrayList<Book> booksArrayList = (ArrayList<Book>) session.getAttribute("booksadminlist");
                                    if(booksArrayList != null){
                                %>
                                    <select name="inputBookID" class="form-control" id="inputBookID" required>
                                        <% for(int i=0; i < booksArrayList.size(); i++){%>
                                            <option value="<%=booksArrayList.get(i).getId()%>"><%=booksArrayList.get(i).getName()%></option>
                                        <% }%>
                                    </select>
                                <% }%>
                            </td>
                            <%
                                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                LocalDateTime localDateTime = LocalDateTime.now();
                                String datetime[] = dateTimeFormatter.format(localDateTime).split(" ");
                            %>
                            <td><input class="form-control" type="date" value="<%=datetime[0]%>" readonly></td>
                            <td><input class="form-control" type="time" value="<%=datetime[1]%>" readonly></td>
                            <input type="hidden" name="datetimeinput" value="<%=dateTimeFormatter.format(localDateTime)%>">
                            <td><input type="submit" class="btn btn-primary btn-block" value="Add" /><br /></td>
                        </tr>
                    </tbody>
                </table>
            </fieldset>
        </form>
    </div>
</body>
</html>