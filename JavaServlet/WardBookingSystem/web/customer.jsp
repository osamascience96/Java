<%-- 
    Document   : customer
    Created on : Jan 27, 2021, 5:48:29 PM
    Author     : osama
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.pojo.User"%>
<%@page import="com.conf.ImageBase64"%>
<%@page import="com.pojo.Ward"%>
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
        <title>WBS| Dashboard</title>
        <!-- Google Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
        <!-- icon image -->
        <link rel="icon" href="images/Majestic_Hotel_hd.png">
        <!-- default css page -->
        <link rel="stylesheet" type="text/css" href="css/includes/default.css">
        <link rel="stylesheet" type="text/css" href="css/includes/admin_interface.css">
        <!-- css page -->
        <link rel="stylesheet" type="text/css" href="css/customer.css">
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
        ArrayList<Ward> arrayListWard = (ArrayList<Ward>) session.getAttribute("wardsList");
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
        <% if(request.getParameter("submitqueryresponse") != null){%>
            <% if(request.getParameter("submitqueryresponse").equals("submit")){%>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Submitted!</strong> Your Message is send to the Administration.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% }else{ %>
                <div class="alert alert-alert alert-dismissible fade show" role="alert">
                    <strong>Not Submitted!</strong> Your Message was not send due to some problem.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            <% } %>
        <% } %>
        <div class="container">
            <h2>Available Wards</h2>
            <div class="row">
                <%if(arrayListWard != null){%>
                    <% 
                        int count = 0;
                        for(int i=0; i < arrayListWard.size(); i++){        
                    %>
                        <% if(count == 3){%>
                            <div class="w-100"></div>
                            <% count = 0;%>
                        <% } %>
                        <div class="ward-item col">
                            <%
                                if(arrayListWard.get(i).GetImage() != null){
                                    out.println("<img class='img' width='100%' height='100%' src='data:image/png;base64,"+ ImageBase64.GetImageData(arrayListWard.get(i).GetImage()) +"'/>");
                                }else{
                                    out.println("<img class='img' width='100%' height='100%' src='images/delux.png'/>");
                                }
                            %>
                            <%
                                String link = "'customer-controller-servlet?customer-mode=ward-book&ward_id=" + arrayListWard.get(i).GetId() + "'";
                            %>
                            <div class="book-btn" onclick="redirect_book_ward(<%=link%>);">Book Now</div>
                            <div class="ward-specs">
                                <h6>Ward Name: <%=arrayListWard.get(i).GetName()%></h6>
                                <h6>Ward Type: <%=arrayListWard.get(i).GetType()%></h6>
                                <h6>Ward Price: <%=arrayListWard.get(i).GetPrice()%></h6>
                            </div>
                        </div>
                        <% count++; %>
                    <% } %>
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
        
        <script src="javascript/redirect_book.js"></script>
    </body>
</html>
