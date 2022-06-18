<%@page import="models.Ticket"%>
<%@page import="models.Show"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
    <%
        ArrayList<Show> shows = (ArrayList<Show>) request.getAttribute("today_show_list");
        ArrayList<Ticket> tickets = (ArrayList<Ticket>) request.getAttribute("today_tickets_list");
        double todayRevenue = (Double)request.getAttribute("today_revenue");
        double totalRevenue = (Double)request.getAttribute("total_revenue");
    %>
    <!-- Sale & Revenue Start -->
    <div class="container-fluid pt-4 px-4">
        <div class="row g-4">
            <div class="col-sm-6 col-xl-3">
                <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                    <i class="fa fa-chart-line fa-3x text-primary"></i>
                    <div class="ms-3">
                        <p class="mb-2">Today Shows</p>
                        <h6 class="mb-0"><%=shows.size()%></h6>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-xl-3">
                <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                    <i class="fa fa-chart-bar fa-3x text-primary"></i>
                    <div class="ms-3">
                        <p class="mb-2">Tickets Today</p>
                        <h6 class="mb-0"><%=tickets.size()%></h6>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-xl-3">
                <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                    <i class="fa fa-chart-area fa-3x text-primary"></i>
                    <div class="ms-3">
                        <p class="mb-2">Today Revenue</p>
                        <h6 class="mb-0">$<%=todayRevenue%></h6>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-xl-3">
                <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                    <i class="fa fa-chart-pie fa-3x text-primary"></i>
                    <div class="ms-3">
                        <p class="mb-2">Total Revenue</p>
                        <h6 class="mb-0">$<%=totalRevenue%></h6>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Sale & Revenue End -->


    <!-- Sales Chart Start -->
    <div class="container-fluid pt-4 px-4">
        <div class="row g-4">
            <div class="col-sm-12 col-xl-12">
                <div class="bg-light text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Exploratory Graph</h6>
                    </div>
                    <canvas id="exploratory_graph"></canvas>
                </div>
            </div>
        </div>
    </div>
    <!-- Sales Chart End -->
<%@include file="includes/footer.jsp" %>