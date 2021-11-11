<%@page import="Bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp"%>
    <title>Log</title>
    <link rel="stylesheet" href="css/logmodify.css">
  </head>
  <body>
    <%@include file="includes/navigation.jsp"%>
    <div class="container">
        <!-- Employee Selection -->
        <div id="employeeselectoption" class="input-group mb-3">
          <div class="input-group-prepend">
            <label class="input-group-text" for="employee_select">Employee</label>
          </div>
          <%
              ArrayList<Student> studentArrayList = (ArrayList<Student>) session.getAttribute("studentlist");
          %>
          <% if(studentArrayList != null){%>
              <select class="custom-select" id="employee_select">
                <% for(int i=0; i < studentArrayList.size(); i++){%>
                  <option value="<%=studentArrayList.get(i).getSsnId()%>"><%=studentArrayList.get(i).getFirstName()%> <%=studentArrayList.get(i).getLastName()%></option>
                <% }%>
              </select>
          <% }%>
        </div>
        <div id="logs" class="row">
        </div>
        <div id="totalprice" class="float-right"></div>
    </div>
    <%@include file="includes/bootstrapjs.jsp"%>
    <%@include file="includes/footer.jsp"%>
    <script src="js/EmployeeData.js"></script>
  </body>
</html> 