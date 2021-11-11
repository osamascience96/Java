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
                        <% if(resp.compareTo("patient_exists") == 0){%>
                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                <strong>Failed!</strong> Patient Already Exists.
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        <% }else if(resp.compareTo("patient_inserted") == 0){%>
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                <strong>Success!</strong> Patient Added of Id <%=request.getParameter("id")%>.
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
                    <caption>Manage Patients</caption>
                    <%
                        ArrayList<User> patientArrayList = (ArrayList<User>) session.getAttribute("patient_list");
                        if(patientArrayList != null){
                    %>
                        <thead>
                            <tr>
                                <th>Full Name</th>
                                <th>Username</th>
                                <th>email</th>
                                <th>AMKA</th>
                                <th>Password</th>
                                <td>
                                    <div class="action_container">
                                            <button class="success" data-bs-toggle="modal" data-bs-target="#patient_modal">
                                                    <i class="fa fa-plus"></i>
                                            </button>
                                    </div>
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(int i=0; i < patientArrayList.size(); i++){%>
                                <tr>
                                    <td><%=patientArrayList.get(i).getFullname()%></td>
                                    <td><%=patientArrayList.get(i).getUsername()%></td>
                                    <td><%=patientArrayList.get(i).getEmail()%></td>
                                    <td><%=patientArrayList.get(i).getPhone()%></td>
                                    <td class="hidetext"><%=patientArrayList.get(i).getPassword()%></td>
                                </tr>
                            <% }%>
                        </tbody>
                    <% }%>
            </table>
        </section>
        <%@include file="modals/add_patient_modal.jsp" %>
<%@include file="includes/footer.jsp" %>