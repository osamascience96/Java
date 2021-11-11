<%@page import="com.pojo.User"%>
<%
    // disable the cache to page to disable any page content in the cache
    // clearing the cache
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
    response.setHeader("Pragma", "no-cache"); // Http 1.0
    if(session.getAttribute("patient_profile") == null){
        response.sendRedirect("index.jsp");
    }
%>
<%@include file="includes/header.jsp" %>
    <link rel="stylesheet" href="css/adminHOME.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
    <section>
            <div class="circle"></div>
            <header>
                <a href="test.html"><img src="images/logo.png" class="logo" /></a>
                <%@include file="includes/navigation_patient.jsp" %>
            </header>
            <div class="content">
                    <%
                        User userObj = (User)session.getAttribute("patient_profile");
                    %>
                    <div class="textBox">
                            <%
                                if(userObj != null){
                            %>
                                <h2>Hello, <br /><span>Mr.<%=userObj.getFullname()%>!</span></h2>
                            <%
                                }
                            %>
                            <p>
                                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis
                                    maiores delectus sunt eos minima esse, quasi voluptatem est
                                    doloribus. Totam quisquam distinctio fugiat minima consectetur porro
                                    impedit, id incidunt suscipit.
                            </p>
                    </div>
                    <div class="imgBox">
                        <img src="images/img3.png" class="medLogo" />
                    </div>
            </div>
    </section>
<%@include file="includes/footer.jsp" %>
