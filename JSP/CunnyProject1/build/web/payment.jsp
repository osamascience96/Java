<%@page import="Bean.Payment"%>
<%@page import="Bean.PaymentLog"%>
<%@page import="Bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/head.jsp"%>
    <title>Log</title>
    <link rel="stylesheet" href="css/payment.css">
  </head>
  <body>
    <%@include file="includes/navigation.jsp"%>
    <div class="container">
        <div class="card">
            <%
                PaymentLog paymentLog = (PaymentLog) session.getAttribute("paymentLog");
                ArrayList<Payment> paymentArrayList = (ArrayList<Payment>) session.getAttribute("paymentList");
            %>
            <h5 class="card-header">Time Sheet Id: <%=paymentLog.getTImeSheetID()%> of employee <span class="text-primary"><%=paymentLog.getFirstName()%> <%=paymentLog.getLastName()%></span></h5>
            <div class="card-body">
                <h5 class="card-title">Payment Method: <span class="text-success"><%=paymentLog.getPayType()%></span></h5>
                <h5 class="card-title">Payment Price: <span class="text-info">$<%=paymentLog.getPayAmount()%></span></h5>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <label class="input-group-text" for="paymentmethod">Payment Method</label>
                    </div>
                    <% if(paymentArrayList != null){%>
                        <select class="custom-select" id="paymentmethod">
                            <% for(int i=0; i < paymentArrayList.size(); i++){%>
                                  <option value="<%=paymentArrayList.get(i).getId()%>"><%=paymentArrayList.get(i).getType()%> {$<%=paymentArrayList.get(i).getAmount()%>}</option>
                            <% }%>
                        </select>
                    <% }%>
                </div>
                <button class="btn btn-outline-primary btn-block" onclick="paymentMethod(<%=paymentLog.getTImeSheetID()%>)">Set Payment Method</button>
            </div>
        </div>
    </div>
    <%@include file="includes/bootstrapjs.jsp"%>
    <%@include file="includes/footer.jsp"%>
    <script src="js/payment.js"></script>
  </body>
</html> 