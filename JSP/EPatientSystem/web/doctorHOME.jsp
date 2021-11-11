<%@page import="com.pojo.User"%>
<%
    // disable the cache to page to disable any page content in the cache
    // clearing the cache
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
    response.setHeader("Pragma", "no-cache"); // Http 1.0
    if(session.getAttribute("doctor_profile") == null){
        response.sendRedirect("index.jsp");
    }
%>
<%@include file="includes/header.jsp" %>
        <link rel="stylesheet" href="css/doctorHome.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    </head>
    <body>
        <section>
                <div class="circle"></div>
                <header>
                    <a href="doctorHOME.jsp"><img src="images/logo.png" class="logo" /></a>
                    <%@include file="includes/navigation_doctor.jsp" %>
                </header>
                <div class="content">
                    <div class="textBox">
                            <%
                                User userPojo = (User)session.getAttribute("doctor_profile");
                            %>
                            <% if(userPojo != null){%>
                                <h2>Welcome <br /><span>Dr.<%=userPojo.getFullname()%>!</span></h2>
                                <p>
                                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis
                                    maiores delectus sunt eos minima esse, quasi voluptatem est
                                    doloribus. Totam quisquam distinctio fugiat minima consectetur porro
                                    impedit, id incidunt suscipit.
                                </p>
                            <% }%>
                    </div>
                    <div class="imgBox">
                        <img src="images/img3.png" class="medLogo" />
                    </div>
                </div>
        </section>
<%@include file="includes/footer.jsp" %>
