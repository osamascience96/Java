<%-- 
    Document   : wards
    Created on : Jan 28, 2021, 7:14:31 PM
    Author     : osama
--%>

<%@page import="com.conf.ImageBase64"%>
<%@page import="com.pojo.User"%>
<%@page import="java.util.ArrayList"%>
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
        <title>WBS| Users</title>
        <!-- Google Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
        <!-- icon image -->
        <link rel="icon" href="images/Majestic_Hotel_hd.png">
        <!-- default css page -->
        <link rel="stylesheet" type="text/css" href="css/includes/default.css">
        <link rel="stylesheet" type="text/css" href="css/includes/admin_interface.css">
        <!-- css page -->
        <link rel="stylesheet" type="text/css" href="css/users.css">
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
        
        ArrayList<User> arrayListUsers = (ArrayList<User>) session.getAttribute("users");
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
        <div class="container">
            <h2>All Users</h2>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Image</th>
                        <th scope="col">Status</th>
                        <th scope="col">Nationality</th>
                        <th scope="col">DOB</th>
                        <th scope="col">Date</th>
                        <th scope="col">Time</th>
                        <th scope="col"><i class="fa fa-pencil" aria-hidden="true"></i></th>
                        <th scope="col"><i class="fa fa-trash" aria-hidden="true"></i></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                      if(arrayListUsers != null){
                        for(int i=0; i < arrayListUsers.size(); i++){
                            String dateTimeArray[] = arrayListUsers.get(i).GetTimeStamp().split(" ");
                            out.println("<tr>");
                            out.println("<th scope='row'>" + arrayListUsers.get(i).GetId() + "</th>");
                            out.println("<th>" + arrayListUsers.get(i).GetName() + "</th>");
                            out.println("<th>" + arrayListUsers.get(i).GetEmail() + "</th>");
                            out.println("<th>" + arrayListUsers.get(i).GetGender() + "</th>");
                            out.println("<th>" + arrayListUsers.get(i).GetPhone() + "</th>");
                            if(arrayListUsers.get(i).GetImage() != null){
                                out.println("<td><img width='100px' height='90px' src='data:image/png;base64,"+ ImageBase64.GetImageData(arrayListUsers.get(i).GetImage()) +"'/></td>");
                            }else{
                                out.println("<td><img width='100px' height='90px' src='https://www.pavilionweb.com/wp-content/uploads/2017/03/man-300x300.png'/></td>");
                            }
                            out.println("<td>" + arrayListUsers.get(i).GetStatus() + "</td>");
                            out.println("<td>" + arrayListUsers.get(i).GetNationality() + "</td>");
                            out.println("<td>" + arrayListUsers.get(i).GetDateOfBirth() + "</td>");
                            out.println("<td>" + dateTimeArray[0] + "</td>");
                            out.println("<td>" + dateTimeArray[1] + "</td>");
                            out.println("<td><a href='admin-controller-servlet?admin-mode=edit&edit_mode=user&user="+arrayListUsers.get(i).GetId()+"'>Edit</a></td>");
                            out.println("<td><a href='admin-controller-servlet?admin-mode=delete&del_mode=user&current_module=users&user="+arrayListUsers.get(i).GetId()+"'>Delete</a></td>");
                            out.println("</tr>");
                        }
                      }
                    %>
                </tbody>
            </table>
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
    </body>
</html>
