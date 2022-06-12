<%@page import="services.TicketService"%>
<%@page import="models.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<!-- Tickets -->
<section class="blog">
    <div class="container">
        <div class="row">
            <div class="title text-center" style="margin-top: 50px;">
              <h2>My Tickets</h2>
            </div>
            <% 
                User user = (User) session.getAttribute("user_session_login");
                if(user == null){
                    response.sendRedirect("login.jsp");
                }else{
                
                    TicketService ticketService = new TicketService();
                    ticketService.setUserId(user.getId());

                    ArrayList<Ticket> tickets = (ArrayList<Ticket>) ticketService.GetTicketsByUserId();
            %>
        </div>
        
        <table class="table table-responsive table-bordered">
            <thead>
                <tr>
                    <td>Film Name</td>
                    <td>Film Director</td>
                    <td>Date</td>
                    <td>Time</td>
                    <td>Room</td>
                    <td>Seat</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <% for(Ticket ticket : tickets){%>
                    <tr>
                        <td><%=ticket.getShow().getFilm().getName()%></td>
                        <td><%=ticket.getShow().getFilm().getDirectorName()%></td>
                        <td><%=ticket.getShow().getDate()%></td>
                        <td><%=ticket.getShow().getTime()%></td>
                        <td><%=ticket.getSeat().getRoom().getName()%></td>
                        <td><%=ticket.getSeat().getRowNum()%><%=ticket.getSeat().getColumnNum()%></td>
                        <td>
                            <a href="ticket.jsp?id=<%=ticket.getId()%>" class="btn btn-default btn-main">View Ticket</a>
                        </td>
                    </tr>
                <% }%>
            </tbody>
        </table>
    </div>
    <% }%>
</section>
<%@include file="includes/footer.jsp" %>