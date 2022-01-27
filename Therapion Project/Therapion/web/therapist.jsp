<%@page import="java.util.ArrayList"%>
<%@page import="pojo.Therapist"%>
<%@include file="includes/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/therapist.css">
<title>Therapists - Therapion</title>
</head>
    <%
        ArrayList<Therapist> therapistList = (ArrayList<Therapist>)request.getAttribute("therapistList");
    %>
  <body>
      <div class="container">
          
      </div>
<%@include file="includes/footer.jsp" %>