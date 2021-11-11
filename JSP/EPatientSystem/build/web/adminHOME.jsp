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
    <link rel="stylesheet" href="css/adminHOME.css" />
    </head>
	<body>
            <section>
                <div class="circle"></div>
                <%@include file="includes/navigation.jsp" %>
                <div class="content">
                    <div class="textBox">
                        <h2>Welcome <br /><span>Admin!</span></h2>
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
