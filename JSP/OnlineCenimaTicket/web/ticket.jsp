<%@page import="models.Ticket"%>
<%@page import="services.TicketService"%>
<%@include file="includes/header.jsp" %>
<!-- Hero Area -section
=========================-->
<%
    
    User user = (User) session.getAttribute("user_session_login");
    if(user == null){
        response.sendRedirect("login.jsp");
    }else{
    
        int id = Integer.parseInt(request.getParameter("id"));
        TicketService ticketService = new TicketService();
        ticketService.setId(id);

        Ticket ticket = ticketService.GetTicketById();
%>
<header class="contact-call-to-action">
    <div class="shadow-block vh-center">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="block">
              <h2><%=ticket.getShow().getFilm().getName()%></h2>
              <p><%=ticket.getShow().getFilm().getDescription()%></p>
              <p>
                  <strong>Date: <%=ticket.getShow().getDate()%></strong> <br>
                  <strong>Time: <%=ticket.getShow().getTime()%></strong>
              </p>
              <p>Seat No: <%=ticket.getSeat().getRowNum()%><%=ticket.getSeat().getColumnNum()%></p>
              <%
                  String trailer = ticket.getShow().getFilm().getTrailer();
                  if(trailer.contains("youtube")){
              %>
                  <a class="btn btn-danger" target="_blank" href="<%=trailer%>" role="button">Watch on Youtube</a>
              <% }else if(trailer.contains("dailymotion")){%>
                  <a class="btn btn-warning" target="_blank" href="<%=trailer%>" role="button">Watch on DailyMotion</a>
              <% }%>
            </div>
          </div>
        </div>
      </div>
    </div>
    <img class="img-responsive" width="100%" height="100%" src="images/movies/<%=ticket.getShow().getFilm().getImage()%>">
</header>
<% }%>
<%@include file="includes/footer.jsp" %>