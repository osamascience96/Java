<%-- 
    Document   : contact-us
    Created on : Jan 27, 2021, 5:48:29 PM
    Author     : osama
--%>

<%@page import="com.pojo.User"%>
<%@page import="com.conf.ImageBase64"%>
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
        <title>WBS| Contact Us</title>
        <!-- Google Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
        <!-- icon image -->
        <link rel="icon" href="images/Majestic_Hotel_hd.png">
        <!-- default css page -->
        <link rel="stylesheet" type="text/css" href="css/includes/default.css">
        <link rel="stylesheet" type="text/css" href="css/includes/admin_interface.css">
        <!-- css page -->
        <link rel="stylesheet" type="text/css" href="css/contactus.css">
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
                    <a href="customer-controller-servlet?customer-mode=default">Home</a>
                </li>
                <li>
                    <a href="customer-controller-servlet?customer-mode=bookings">Bookings</a>
                </li>
                <li>
                    <a href="customer-controller-servlet?customer-mode=transactions">Payments</a>
                </li>
                <li>
                    <a href="customer-controller-servlet?customer-mode=profile">Profile</a>
                </li>
                <li>
                    <a href="customer-controller-servlet?customer-mode=history">History</a>
                </li>
                <li>
                    <a href="customer-controller-servlet?customer-mode=contactus">Contact Us</a>
                </li>
            </ul>
        </nav>
        <% if(user != null){ %>
            <form action="customer-controller-servlet" method="POST">
                <div class="container">
                    <h2>Contact Us</h2>
                    <div class="container rounded bg-white mt-5 mb-5">
                        <div class="row">
                            <div class="col border-right">
                                <div class="p-3 py-5">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <h4 class="text-right">Contact us</h4>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col"><label class="labels">Name</label><input type="text" class="form-control" placeholder="Name" value="<%=user.GetName()%>" disabled="true"></div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col"><label class="labels">Phone Number</label><input type="text" class="form-control" placeholder="enter phone number" value="<%=user.GetPhone()%>" disabled="true"></div>
                                        <div class="col"><label class="labels">Email ID</label><input type="text" class="form-control" placeholder="enter email id" value="<%=user.GetEmail()%>" disabled="true"></div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col">
                                            <label class="labels">Message</label>
                                            <input type="hidden" name="user_id" value="<%=user.GetId()%>" >
                                            <textarea type="text" class="form-control" name="user-review" rows="10" placeholder="Write Your Message Here"></textarea>
                                        </div>
                                    </div>
                                    <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Send Message</button></div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="p-3 py-5">
                                    <!--Embedded the map-->
                                    <h6 style="font-weight: bold; text-align: center;">Our Location:</h6>
                                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3988.3406242084548!2d103.62517791523078!3d1.5594341612994447!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31da76af1f67f15b%3A0x55859cb64612767b!2sUTM%20Health%20Centre!5e0!3m2!1sen!2smy!4v1606655710443!5m2!1sen!2smy" width="100%" height="650" frameborder="0" style="border: 2px solid black; border-radius: 10px;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        <% } %>
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
    </body>
</html>
