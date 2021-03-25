<%@page import="java.util.ArrayList"%>
<!-- Modal -->
<div class="modal fade" id="session_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="container">
            <% if(session.getAttribute("session_list") != null){ %>
                <%
                    ArrayList<String> arrayListSession = (ArrayList<String>) session.getAttribute("session_list");
                %>
                <%
                    for(int i=0; i < arrayListSession.size(); i++){
                %>
                    <h6><%=arrayListSession.get(i)%></h6>
                <% }%>
            <% }else{%>
                <div class="alert alert-warning" role="alert">No URL's visited.</div>
            <% }%>
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>