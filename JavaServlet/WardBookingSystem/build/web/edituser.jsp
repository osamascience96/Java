<%-- 
    Document   : wards
    Created on : Jan 28, 2021, 7:14:31 PM
    Author     : osama
--%>

<%@page import="com.conf.ImageBase64"%>
<%@page import="com.pojo.User"%>
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
        <title>Edit Ward| WBS</title>
        <!-- Google Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
        <!-- icon image -->
        <link rel="icon" href="images/Majestic_Hotel_hd.png">
        <!-- default css page -->
        <link rel="stylesheet" type="text/css" href="css/includes/default.css">
        <link rel="stylesheet" type="text/css" href="css/includes/admin_interface.css">
        <!-- css page -->
        <link rel="stylesheet" type="text/css" href="css/edituser.css">
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
        
        User adminUser = (User) session.getAttribute("User");
        User user = (User) session.getAttribute("user-edit");
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
                <li>
                    <a href="settings.jsp">Settings</a>
                </li>
            </ul>
        </nav>
        <% if(user != null){%>
            <form action="editusercontroller" method="POST">
                <div class="container rounded bg-white mt-5 mb-5">
                    <div class="row">
                        <div class="col-md-3 border-right">
                            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                <% if(user.GetImage() != null){
                                    out.println("<img width='180px' height='200px' class='rounded-circle mt-5' src='data:image/png;base64,"+ImageBase64.GetImageData(user.GetImage())+"'>");
                                }else{
                                    out.println("<img width='180px' height='200px' class='rounded-circle mt-5' src='https://www.pavilionweb.com/wp-content/uploads/2017/03/man-300x300.png'>");
                                }%>
                                <span class="text-black-50">User ID: <%=user.GetId()%></span>
                                <input type="hidden" name="userid" value="<%=user.GetId()%>">
                            </div>
                        </div>
                        <div class="col-md-5 border-right">
                            <div class="p-3 py-5">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                    <h4 class="text-right">Edit User</h4>
                                </div>
                                <div class="row">
                                    <div class="col"><label class="labels">Name</label><input type="text" class="form-control" name="user_name" placeholder="Name" value="<%=user.GetName()%>"></div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-md-12"><label class="labels">Phone Number</label><input type="text" class="form-control" placeholder="Enter phone number" name="phone" value="<%=user.GetPhone() == null ? "+xxxxxxxxxxxxx" : user.GetPhone()%>"></div>
                                    <div class="col-md-12"><label class="labels">Email Address</label><input type="text" class="form-control" placeholder="Enter email id" name="email" value="<%=user.GetEmail()%>"></div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col"><label class="labels">Nationality</label><input type="text" class="form-control" placeholder="Nationality" name="nationality" value="<%=user.GetNationality() == null ? "Pakistani" : user.GetNationality()%>"></div>
                                </div>
                                <div class="mt-5 text-center"><input class="btn btn-primary profile-button" type="submit" value="Edit User"></div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="p-3 py-5">
                                <div class="col-md-12">
                                    <label class="labels">Gender</label>
                                    <select name="gender" class="custom-select custom-select-lg mb-3">
                                        <%
                                            if(user.GetGender() == null){
                                                out.println("<option value='Male' selected>Male</option>");
                                                out.println("<option value='Female'>Female</option>");
                                                out.println("<option value='Transgender'>Transgender</option>");
                                            }else if(user.GetGender().equals("Male")){
                                                out.println("<option value='Male' selected>Male</option>");
                                                out.println("<option value='Female'>Female</option>");
                                                out.println("<option value='Transgender'>Transgender</option>");
                                            }else if(user.GetGender().equals("Female")){
                                                out.println("<option value='Female' selected>Female</option>");
                                                out.println("<option value='Male'>Male</option>");
                                                out.println("<option value='Transgender'>Transgender</option>");
                                            }else if(user.GetGender().equals("Transgender")){
                                                out.println("<option value='Transgender' selected>Transgender</option>");
                                                out.println("<option value='Male'>Male</option>");
                                                out.println("<option value='Female'>Female</option>");
                                            }
                                        %>
                                    </select>
                                </div> 
                                <br>
                                <div class="col-md-12">
                                    <label class="labels">Status</label>
                                    <select name="status" class="custom-select custom-select-lg mb-3">
                                        <%
                                            if(user.GetStatus()== null){
                                                out.println("<option value='Married' selected>Married</option>");
                                                out.println("<option value='Unmarried'>Unmarried</option>");
                                            }else if(user.GetStatus().equals("Married")){
                                                out.println("<option value='Married' selected>Married</option>");
                                                out.println("<option value='Unmarried'>Unmarried</option>");
                                            }else if(user.GetStatus().equals("Unmarried")){
                                                out.println("<option value='Unmarried' selected>Unmarried</option>");
                                                out.println("<option value='Married'>Married</option>");
                                            }
                                        %>
                                    </select>
                                </div> 
                                <br>
                                <div class="col-md-12">
                                    <label class="labels">Date Created</label>
                                    <input class="col" type="date" value="<%=user.GetTimeStamp().split(" ")[0]%>" disabled="true"> 
                                </div> 
                                <br>
                                <div class="col-md-12">
                                    <label class="labels">Date of Birth</label>
                                    <input class="col" name="dob" type="date" value="<%=user.GetDateOfBirth() == null ? "1970-01-01" : user.GetDateOfBirth()%>"> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        <% } %>
        </div>
        </div>
        <!-- Modal -->
        <% if(adminUser != null){ %>
            <div class="modal fade" id="user-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="user-modal-title"><%=adminUser.GetName()%></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                    Email: <%=adminUser.GetEmail()%>
                    <%
                        if(adminUser.GetImage() != null){
                            out.println("<div style='text-align:center; padding:50px;'><img width='100px' height='90px' src='data:image/png;base64,"+ ImageBase64.GetImageData(adminUser.GetImage()) +"'/></div>");
                        }else{
                            out.println("<div style='text-align:center; padding:50px;'><img width='100px' height='90px' src='https://www.pavilionweb.com/wp-content/uploads/2017/03/man-300x300.png'/></div>");
                        }
                    %>
                    Phone: <%=adminUser.GetPhone()%>
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
