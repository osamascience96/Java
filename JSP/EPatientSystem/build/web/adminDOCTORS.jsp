<%@page import="com.pojo.User"%>
<%@page import="java.util.ArrayList"%>
<%
    // disable the cache to page to disable any page content in the cache
    // clearing the cache
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
    response.setHeader("Pragma", "no-cache"); // Http 1.0
    if(session.getAttribute("admin_user") == null){
        response.sendRedirect("index.jsp");
    }
%>
<%@include file="includes/header.jsp" %>
    <link rel="stylesheet" href="css/adminDOCTORS.css" />
    </head>
	<body>
        <section>
            <%@include file="includes/navigation.jsp" %>
                <%
                    String resp = request.getParameter("response");
                %>
                <% if(resp != null){%>
                        <% if(resp.compareTo("doctor_exists") == 0){%>
                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                <strong>Failed!</strong> Doctor Already Exists.
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        <% }else if(resp.compareTo("doctor_inserted") == 0){%>
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                <strong>Success!</strong> Doctor Added of Id <%=request.getParameter("id")%>.
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        <% }else if(resp.compareTo("del_success") == 0){%>
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                <strong>Success!</strong> Patient Deleted Successfully.
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        <% }%>
                <% }%>
                <table class="hor-table">
                    <caption>Manage Doctors</caption>
                    <%
                        ArrayList<User> doctorsArrayList = (ArrayList<User>) session.getAttribute("doctor_list");
                        if(doctorsArrayList != null){
                    %>
                        <thead>
                            <tr>
                                <th>Full Name</th>
                                <th>Username</th>
                                <th>email</th>
                                <th>AMKA</th>
                                <th>Password</th>
                                <td>Profession</td>
                                <td>
                                    <div class="action_container" data-bs-toggle="modal" data-bs-target="#doctor_modal">
                                            <button class="success">
                                                    <i class="fa fa-plus"></i>
                                            </button>
                                    </div>
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(int i=0; i < doctorsArrayList.size(); i++){%>
                                <tr>
                                    <td><%=doctorsArrayList.get(i).getFullname()%></td>
                                    <td><%=doctorsArrayList.get(i).getUsername()%></td>
                                    <td><%=doctorsArrayList.get(i).getEmail()%></td>
                                    <td><%=doctorsArrayList.get(i).getPhone()%></td>
                                    <td class="hidetext"><%=doctorsArrayList.get(i).getPassword()%></td>
                                    <td><%=doctorsArrayList.get(i).getProfession()%></td>
                                    <td>
                                        <div class="action_container" onclick="window.location.replace('doctor_servlet?delete_id=<%=doctorsArrayList.get(i).getId()%>')">
                                            <button class="danger">
                                                <i class="fa fa-times"></i>
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            <% }%>
                        </tbody>
                    <% }%>
            </table>
        </section>
        <%@include file="modals/add_doctor_modal.jsp" %>
<%@include file="includes/footer.jsp" %>