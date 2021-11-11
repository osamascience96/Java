<%-- 
    Document   : profile
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
        <link rel="stylesheet" type="text/css" href="css/profile.css">
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
        <% if(user != null){%>
            <form action="editprofilecontroller" method="POST">
                <input type="hidden" name="user_id" value="<%=user.GetId()%>">
                <div class="container">
                    <h2>My Profile</h2>
                    <div class="container rounded bg-white mt-5 mb-5">
                        <div class="row">
                            <div class="col-md-3 border-right">
                                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                    <% if(user.GetImage() != null){%>
                                        <img class="rounded-circle mt-5" width="200px" src="data:image/png;base64,<%=ImageBase64.GetImageData(user.GetImage())%>"><span class="font-weight-bold"><%=user.GetName()%></span><span class="text-black-50"><%=user.GetEmail()%></span><span> </span>
                                    <% }else {%>
                                        <img class="rounded-circle mt-5" width="200px" src="https://www.pavilionweb.com/wp-content/uploads/2017/03/man-300x300.png"><span class="font-weight-bold"><%=user.GetName()%></span><span class="text-black-50"><%=user.GetEmail()%></span><span> </span>
                                    <% } %>
                                </div>
                            </div>
                            <div class="col-md-5 border-right">
                                
                                <div class="p-3 py-5">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <h4 class="text-right">Profile</h4>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col">
                                            <label class="labels">Full Name</label>
                                            <input type="text" class="form-control" name="full-name" placeholder="Full Name" value="<%=user.GetName()%>">
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-md-12">
                                            <label class="labels">Phone Number</label>
                                            <input type="text" class="form-control" name="phone" placeholder="Enter Phone Number" value="<%= user.GetPhone() == null ? "" : user.GetPhone()%>">
                                        </div>
                                        <div class="col-md-12" style="margin: 10px auto 10px auto;">
                                            <label class="labels">Email Address</label>
                                            <input type="text" class="form-control" name="email" placeholder="Enter Email Address" value="<%=user.GetEmail()%>">
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-md-6">
                                            <label class="labels">Gender</label>
                                            <select class="custom-select" name="gender">
                                                <%
                                                    if(user.GetGender() == null){
                                                        out.println("<option selected value='Male'>Male</option>");
                                                        out.println("<option value='Female'>Female</option>");
                                                        out.println("<option value='Transgender'>Transgender</option>");
                                                    }else if(user.GetGender().equals("Male")){
                                                        out.println("<option selected value='Male'>Male</option>");
                                                        out.println("<option value='Female'>Female</option>");
                                                        out.println("<option value='Transgender'>Transgender</option>");
                                                    }else if(user.GetGender().equals("Female")){
                                                        out.println("<option selected value='Female'>Female</option>");
                                                        out.println("<option value='Male'>Male</option>");
                                                        out.println("<option value='Transgender'>Transgender</option>");
                                                    }else if(user.GetGender().equals("Transgender")){
                                                        out.println("<option selected value='Transgender'>Transgender</option>");
                                                        out.println("<option value='Male'>Male</option>");
                                                        out.println("<option value='Female'>Female</option>");
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="labels">Martial Status</label>
                                            <select class="custom-select" name="martial-status"> 
                                                <%
                                                    out.println("<option selected value='Married'>Married</option>");
                                                    out.println("<option value='Unmarried'>Unmarried</option>");
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Save</button></div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="p-3 py-5">
                                    <div class="col">
                                        <label class="labels">Nationality</label>
                                        <input type="text" name="nationality" class="form-control" placeholder="Enter Nationality" value="<%= user.GetNationality() == null ? "" : user.GetNationality()%>">
                                    </div>
                                    <br>
                                    <div class="col">
                                        <label class="labels">Date of Birth:</label>
                                        <input type="date" name="date-of-birth" class="form-control" value="<%= user.GetDateOfBirth() == null ? "1947-08-14" : user.GetDateOfBirth()%>">
                                    </div>
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
        
        <script src="javascript/redirect_book.js"></script>
    </body>
</html>
