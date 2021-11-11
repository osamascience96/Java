<%@page import="helper.AES"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<div class="container">
    <form action="member_admin_servlet" method="post">
        <fieldset>
            <legend>Members</legend>
            <table class="table">
                <thead>
                    <th scope="col">ID</th>
                    <th scope="col">Member Name</th>
                    <th scope="col">Action</th>
                </thead>
                <tbody>
                    <%
                        ArrayList<Member> memberArrayList = (ArrayList<Member>) session.getAttribute("member_admin_list");
                        if(memberArrayList != null){
                    %>
                        <% for(int i=0; i< memberArrayList.size(); i++){%>
                            <tr>
                                <th scope="row"><%=memberArrayList.get(i).getId()%></th>
                                <td><%=AES.Decrypt(memberArrayList.get(i).getMember_name())%></td>
                                <%
                                    int isActive = memberArrayList.get(i).getIs_active();
                                %>
                                <%
                                    if(isActive == 1){
                                %>
                                <td class="text-center"><a class="text-danger" href="update_member_servlet?action=deactive&member_id=<%=memberArrayList.get(i).getId()%>">Deactivate</a></td>
                                <% }else{%>
                                    <td class="text-center"><a class="text-primary" href="update_member_servlet?action=active&member_id=<%=memberArrayList.get(i).getId()%>">Activate</a></td>
                                <% }%>
                            </tr>
                        <% }%>
                    <% }%>
                    <tr>
                        <th scope="row"></th>
                        <td><input name="member_name" type="text" class="form-control" id="memberName" required placeholder="Member Name" maxlength="50"></td>
                        <td><input type="submit" class="btn btn-primary btn-block" value="Add" /><br /></td>
                    </tr>
                </tbody>
            </table>
        </fieldset>
    </form>
</div>