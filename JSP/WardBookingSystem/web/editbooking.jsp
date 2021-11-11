<%-- 
    Document   : wards
    Created on : Jan 28, 2021, 7:14:31 PM
    Author     : osama
--%>

<%@page import="com.pojo.User"%>
<%@page import="com.conf.ImageBase64"%>
<%@page import="com.pojo.Booking"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!-- font awesome icon-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Edit Booking| WBS</title>
        <!-- Google Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
        <!-- icon image -->
        <link rel="icon" href="images/Majestic_Hotel_hd.png">
        <!-- default css page -->
        <link rel="stylesheet" type="text/css" href="css/includes/default.css">
        <link rel="stylesheet" type="text/css" href="css/includes/admin_interface.css">
        <!-- css page -->
        <link rel="stylesheet" type="text/css" href="css/editadminbooking.css">
    </head>
    <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
    %>
    <%    
        if(session.getAttribute("User") == null){
            response.sendRedirect("login.html");
        }
        
        User user = (User) session.getAttribute("User");
        Booking booking = (Booking) session.getAttribute("bookingdatauser");
    %>
    <body>
        <div class="header">
            <h2>Ward Booking System</h2>
            <img width="60px" src="images/Majestic_Hotel_hd.png" alt="icon_img" >
            <i class="icon-header fa fa-user-circle-o fa-2x" aria-hidden="true" type="button" data-toggle="modal" data-target="#user-modal"></i>
        </div>
        <nav class="navigation" role="navigation">
            <ul>
                <li>
                    <a href="admin-controller-servlet?admin-mode=admin">Home</a>
                </li>
                <li>
                    <a href="admin-controller-servlet?admin-mode=users">Users</a>
                </li>
                <li>
                    <a href="admin-controller-servlet?admin-mode=ward">Wards</a>
                </li>
                <li>.
                    <a href="admin-controller-servlet?admin-mode=bookings">Bookings</a>
                </li>
                <li>.
                    <a href="admin-controller-servlet?admin-mode=reports">Reports</a>
                </li>
                <li>
                    <a href="admin-controller-servlet?admin-mode=reviews">Reviews</a>
                </li>
                <li>
                    <a href="settings.jsp">Settings</a>
                </li>
            </ul>
        </nav>
        <% if(booking != null){%>
            <form action="editbookingcontroller" method="POST">
                <div class="container rounded bg-white mt-5">
                    <div class="row">
                        <div class="col-md-8">
                            <div class="p-3 py-5">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                    <h6 class="text-right">Edit Booking</h6>
                                </div>
                                <div class="row mt-2">
                                    <div class="col">
                                        <input type="text" class="form-control" placeholder="Name" value="<%=booking.GetUsername()%>" disabled="true">
                                    </div>
                                    <div class="col">
                                        <input type="text" class="form-control" placeholder="Email" value="<%=booking.GetUserEmail()%>" disabled="true">
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col">
                                        <input type="text" class="form-control" placeholder="Ward Name" value="<%=booking.GetWardName()%>" disabled="true">
                                    </div>
                                    <div class="col">
                                        <input type="text" class="form-control" placeholder="Ward Type" value="<%=booking.GetWardType()%>" disabled="true">
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col">
                                        <h6>Price per Day: </h6>
                                        <input class="custom-select custom-select-lg mb-3" type="text" value="<%=booking.GetWardPrice()%>" placeholder="Price Per Day" disabled="true">
                                    </div>
                                </div>
                                <h6>Actions</h6>
                                <div class="row mt-3">
                                    <div class="col-md-6">
                                        <h6>Check-in Date: </h6>
                                        <input type="date" class="form-control" name="check-in-date" value="<%=booking.GetCheckInDate()%>">
                                    </div>
                                    <div class="col-md-6">
                                        <h6>Check-out Date: </h6>
                                        <input type="date" class="form-control" name="check-out-date" value="<%=booking.GetCheckOutDate()%>">
                                    </div>
                                </div>
                                    <input type="hidden" name="booking_id" value="<%=booking.GetBookingId()%>">
                                <div class="mt-5 text-right"><input class="btn btn-primary profile-button" type="submit" value="Edit Booking"></div>
                            </div>
                        </div>
                    </div>
                    <%
                        if(booking.GetStatus().equals("accepted")){
                            if(booking.GetCheckInDate() != null && booking.GetCheckOutDate() != null){
                                out.println("<a href='customer-controller-servlet?customer-mode=edit-payment&booking_id="+booking.GetBookingId()+"' class='active-payed' >Amount Payed</a>");
                                out.println("<a href='customer-controller-servlet?customer-mode=edit-ward-status&booking_id="+booking.GetBookingId()+"' class='checkout-booking' >Checkout Booking</a>");
                            }
                        }
                        
                        // check if the status of the order is pending 
                        if(booking.GetStatus().equals("pending")){
                            out.println("<a class='accepted-btn' href='customer-controller-servlet?customer-mode=edit-booking-status&booking_Status=accepted&booking_id="+booking.GetBookingId()+"'>Accepted</a>");
                            out.println("<a class='cancell-btn'href='customer-controller-servlet?customer-mode=edit-booking-status&booking_Status=cancelled&booking_id="+booking.GetBookingId()+"'>Cancel</a>");
                        }else if(booking.GetStatus().equals("accepted")){
                            out.println("<a class='completed-btn' href='customer-controller-servlet?customer-mode=edit-booking-status&booking_Status=completed&booking_id="+booking.GetBookingId()+"'>Complete</a>");
                        }
                    %>
                </div>
            </form>
        <% } %>
        </div>
        </div>
        <!-- Modal -->
        <% if(user != null){%>
            <div class="modal fade" id="user-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="user-modal-title"><%=user.GetName()%></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                    Email: <%=user.GetEmail()%>
                    <%
                        if(user.GetImage() != null){
                            out.println("<div style='text-align:center; padding:50px;'><img width='100px' height='90px' src='data:image/png;base64,"+ ImageBase64.GetImageData(user.GetImage()) +"'/></div>");
                        }else{
                            out.println("<div style='text-align:center; padding:50px;'><img width='100px' height='90px' src='https://www.pavilionweb.com/wp-content/uploads/2017/03/man-300x300.png'/></div>");
                        }
                    %>
                    Phone: <%=user.GetPhone()%>
                  </div>
                  <div class="modal-footer">
                      <a type="button" href="logoutservlet" class="btn btn-primary">Logout</a>
                  </div>
                </div>
              </div>
            </div>
        <% } %>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
        <script src="redirect_book.js"></script>
    </body>
</html>
