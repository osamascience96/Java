<%@page import="models.Room"%>
<%@page import="services.RoomService"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
<section class="page-header services-header" data-parallax="scroll" data-image-src="images/header/header_cenima.jpg">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1 class="text-center"> Our Rooms. <br> We have best cenimatic Ecosystem.</h1>
      </div>
    </div>
  </div>
</section>

<!-- Service Item Sections 
=========================-->
<section class="services">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="title text-center">
          <h2>Our Rooms</h2>
        </div>
      </div>
      <%
          RoomService roomService = new RoomService();
      %>
      
      <%
          ArrayList<Room> rooms = (ArrayList<Room>) roomService.GetAllRooms();
          for(Room room : rooms){
      %>
        <div class="col-md-4">
          <div class="service-item text-center">
            <div class="services-icon">
              <i class="tf-ion-record"></i>
            </div>
            <h4 class="service-title"><%=room.getName()%></h4>
            <p class="service-description">
              <%=room.getDescription()%>
            </p>
          </div>
        </div>
      <% }%>
    </div>
  </div>
</section>


<!-- Pricing Table Sections 
=========================-->
<section class="pricing-table">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="title text-center">
            <h2>Our Room Best Seat Price</h2>
          </div>
        </div>
        <%
          ArrayList<Room> roomsBestPrices = (ArrayList<Room>) roomService.GetAllRoomsBestPrice();
          for(Room room : roomsBestPrices){
        %>
        <div class="col-md-4">
          <div class="table text-center">
            <!-- pricing table
            ===================== -->
            <div class="table-price border-effect">
              <h4 class="pricing-title"><%=room.getName()%></h4>
              <h2 class="price">&#36; <%=room.getSeat().getPrice()%></h2>
            </div>
            <div class="pricing-list border-effect">
                <a type="button" href="#" class="btn btn-default btn-main th-btn-border">Book Movies</a>
            </div>
          </div>
        </div>
        <% }%>
      </div>
    </div>
</section>
<%@include file="includes/footer.jsp" %>  