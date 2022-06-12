<%@page import="models.Film"%>
<%@page import="models.Seat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Show"%>
<%@include file="includes/header.jsp" %>

<%
    Show show = (Show) request.getAttribute("show");
    ArrayList<Seat> seats = (ArrayList<Seat>) request.getAttribute("seats");
    
    Film film = show.getFilm();
%>

<style>
    @import url("https://fonts.googleapis.com/css?family=Montserrat&display=swap");

    #theaterbookingUI {
        font-family: "Montserrat", sans-serif;
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        flex-direction: column;
        color: #fff;
        margin: 0;
    }

    .movie-container {
      margin: 20px 0px;
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column
    }

    .movie-container select {
      appearance: none;
      -moz-appearance: none;
      -webkit-appearance: none;
      border: 0;
      padding: 5px 15px;
      margin-bottom: 40px;
      font-size: 14px;
      border-radius: 5px;
    }

    .screencontainer {
      perspective: 1000px;
      margin: 40px 0;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
    }

    .seat {
      background-color: #444451;
      height: 12px;
      width: 15px;
      margin: 3px;
      border-top-left-radius: 10px;
      border-top-right-radius: 10px;
    }

    .selected {
      background-color: #0081cb;
    }

    .occupied {
      background-color: #fff;
    }

    .seat:nth-of-type(2) {
      margin-right: 18px;
    }

    .seat:nth-last-of-type(2) {
      margin-left: 18px;
    }

    .seat:not(.occupied):hover {
      cursor: pointer;
      transform: scale(1.2);
    }

    .showcase .seat:not(.occupied):hover {
      cursor: default;
      transform: scale(1);
    }

    .showcase {
      display: flex;
      justify-content: space-between;
      list-style-type: none;
      background: rgba(0,0,0,0.1);
      padding: 5px 10px;
      border-radius: 5px;
      color: #777;
    }

    .showcase li {
      display: flex;
      align-items: center;
      justify-content: center;
      margin: 0 10px;
    }

    .showcase li small {
      margin-left: 2px;
    }

    .row {
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .screen {
      background: #fff;
      height: 70px;
      width: 70%;
      margin: 15px 0;
      transform: rotateX(-45deg);
      box-shadow: 0 3px 10px rgba(255,255,255,0.7);
    }

    p.text {
      margin: 40px 0;
    }

    p.text span {
      color: #0081cb;
      font-weight: 600;
      box-sizing: content-box;
    }

    .credits a {
      color: #fff;
    }
</style>

<style>
    #show-error, #seats-error{
        color: red;
    }
</style>

<!-- Hero Area -section
=========================-->
<header class="contact-call-to-action">
  <div class="shadow-block vh-center">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="block">
            <h2><%=film.getName()%></h2>
            <p><%=film.getDescription()%></p>
            <p>
                <strong>Date: <%=show.getDate()%></strong> <br>
                <strong>Time: <%=show.getTime()%></strong>
            </p>
            <%
                String trailer = film.getTrailer();
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
    <img class="img-responsive" width="100%" height="100%" src="images/movies/<%=film.getImage()%>">
</header>


 <!-- Select Theater
  =========================-->

<section class="case-study">
    <div class="text-center">
      <h2 class="title">Seats</h2>
    </div>
    <div class="case-study-content">
        <div class="container">
            <div id="theaterbookingUI">
                <div class="movie-container">
                    <ul class="showcase">
                        <li>
                          <div class="seat"></div>
                          <small>N/A</small>
                        </li>
                        <li>
                          <div class="seat selected"></div>
                          <small>Selected</small>
                        </li>
                        <li>
                          <div class="seat occupied"></div>
                          <small>Occupied</small>
                        </li>    
                    </ul>

                    <div class="screencontainer">
                        <div class="screen"></div>
                        <% char selectedRow = 0;%>
                        <% for(Seat seat : seats){%>
                            <% 
                                if(selectedRow == 0){
                                    selectedRow = seat.getRowNum();
                            %>
                                <div class="row">
                            <% }%>
                            <% 
                                if(seat.getRowNum() != selectedRow){
                                    selectedRow = seat.getRowNum();
                            %>
                                <div class="row">
                            <% }%>
                            <div class="seat" data-toggle="tooltip" title="<%=seat.getRowNum()%><%=seat.getColumnNum()%>" data-seatNo="<%=seat.getId()%>-<%=seat.getPrice()%>"></div>
                            <% if(seat.getColumnNum() == 10){%>
                                </div>
                            <% }%>
                        <% }%>
                        <p class="text">
                          You have selected <span id="count">0</span> seats for the total price of $<span id="total">0.0</span>
                        </p>
                    </div>
                </div>
            </div>
                        
            <form id="bookticketform" style="text-align: center;" action="BookServlet" method="post">
                <input type="hidden" name="show" value="<%=show.getId()%>" />
                <input type="hidden" name="seats" id="seats"  />

                <div class="container">
                    <div class="row">
                        <div class="offset-md-4"></div>
                        <div class="col-xs-12 col-sm-12 col-md-6">
                            <input type="submit" class="btn btn-default btn-main btn-block" style="margin-top: 40px;" value="Book Now" />
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
    
<script>
    document.addEventListener("DOMContentLoaded", function(){
        // rules for the form
        $("#bookticketform").validate({
            ignore: [],
            rules: {
                show: {
                    required: true,
                },
                seats: {
                    required: true,
                },
            },
            messages: {
                show: 'Show cannot be Empty',
                seats: 'Please Select a seat to book a movie'
            }
        });
    });
</script>

<script>
    document.addEventListener('DOMContentLoaded', function(){
        
        $('[data-toggle="tooltip"]').tooltip();
        
        var count = 0;
        var totalPrice = 0.0;
        
        var seatsArr = [];
        $('.seat').on('click', function(){
            var data = $(this).attr("data-seatNo");
            let list = data.split("-");
            
            let seatId = list[0];
            let price = parseFloat(list[1]);
            
            if($(this).hasClass("selected")){
                count -=1;
                totalPrice -=price;
                
                // remove item
                const index = seatsArr.indexOf(seatId);
                seatsArr.splice(index, 1);
                
                $(this).removeClass("selected");
            }else{
                count +=1;
                totalPrice +=price;
                
                // add item
                seatsArr.push(seatId);
                
                $(this).addClass("selected");
            }
            
            $("#seats").val(seatsArr.toString());
            
            $("#count").html(count);
            $("#total").html(totalPrice);
        });
    });
</script>
 
<%@include file="includes/footer.jsp" %>