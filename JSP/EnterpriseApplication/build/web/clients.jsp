<%@page import="com.pojo.Client"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    
    <link rel="stylesheet" type="text/css" href="css/clients.css">
    <link rel="stylesheet" type="text/css" href="css/navigation.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    
    <title>Clients</title>
  </head>
  <body>
    <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("login") == null){
            response.sendRedirect("/EnterpriseApplication/");
        }
    %>
    <%@include file="includes/navigation.jsp" %>
    <div class="container">
        <%
            if(request.getParameter("response") != null){
        %>
            <%
                String operationalResponse = request.getParameter("response");
                String alertType = "";
                String alertTitle = "";
                String alertMessage = "";
                
                if(operationalResponse.compareTo("client_insert_success") == 0){
                    alertType = "success";
                    alertTitle = "Client Added!";
                    alertMessage = "Your Client Added to the System Successfully";
                }else if(operationalResponse.compareTo("client_exists") == 0){
                    alertType = "danger";
                    alertTitle = "Client Exists!";
                    alertMessage = "Your Client Already exists in the System";
                }else if(operationalResponse.compareTo("client_update_success") == 0){
                    alertType = "success";
                    alertTitle = "Client Updated!";
                    alertMessage = "Your Client Updated Successfully";
                }else if(operationalResponse.compareTo("deleted_successfully") == 0){
                    alertType = "success";
                    alertTitle = "Client Deleted!";
                    alertMessage = "Your Client Deleted Successfully";
                }
            %>
            <div class="alert alert-<%=alertType%> alert-dismissible fade show" role="alert">
                <strong><%=alertTitle%></strong> <%=alertMessage%>.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% }%>
        <div class="table-container container">
            <% if(session.getAttribute("clients_list") != null){%>
                <%
                    ArrayList<Client> arrayListClients = (ArrayList<Client>) session.getAttribute("clients_list");
                    if(arrayListClients.size() > 0){
                %>
                    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                        <h6 class="text-white">Search Clients</h6>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#search_client_content" aria-controls="search_client_content" aria-expanded="false" aria-label="Toggle navigation">
                          <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="search_client_content">
                          <ul class="navbar-nav mr-auto">
                          </ul>
                          <div class="form-inline my-2 my-lg-0">
                              <input id="search_client_input" onkeyup="search_clients()" class="form-control mr-sm-2" type="search" placeholder="Search by Name" aria-label="Search">
                          </div>
                        </div>
                      </nav>
                    <div class="table table-bordered table-light table-responsive-lg">
                    <!-- Adding a search navbar -->
                    
                    <table id="client_table" class="table">
                        <caption>List of Clients</caption>
                        <thead>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Address</th>
                            <th scope="col">Email</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Created_at</th>
                            <th scope="col">Updated_at</th>
                            <th scope="col">Actions</th>
                        </thead>
                        <tbody>
                            <% for(int i=0; i < arrayListClients.size(); i++){%>
                                <tr>
                                    <th scope="row"><%=arrayListClients.get(i).GetId()%></th>
                                    <td><%=arrayListClients.get(i).GetName()%></td>
                                    <td><button class="btn btn-outline-info btn-block" type="button" onclick="open_address_modal('<%=arrayListClients.get(i).GetAddress()%>');">Address</button></td>
                                    <td><%=arrayListClients.get(i).GetEmail()%></td>
                                    <td><%=arrayListClients.get(i).GetPhone()%></td>
                                    <td><%=arrayListClients.get(i).GetCreatedAT()%></td>
                                    <td><%=arrayListClients.get(i).GetUpdatedAt()%></td>
                                    <script>
                                        var client_obj_<%=arrayListClients.get(i).GetId()%> = {
                                            id: <%=arrayListClients.get(i).GetId()%>,
                                            name: '<%=arrayListClients.get(i).GetName()%>',
                                            address: '<%=arrayListClients.get(i).GetAddress()%>',
                                            email: '<%=arrayListClients.get(i).GetEmail()%>',
                                            phone: '<%=arrayListClients.get(i).GetPhone()%>',
                                            created_at: '<%=arrayListClients.get(i).GetCreatedAT()%>',
                                            updated_at: '<%=arrayListClients.get(i).GetUpdatedAt()%>'
                                        }
                                    </script>
                                    <td class="text-center align-middle">
                                        <div class="btn-group align-top">
                                            <button class="btn btn-sm btn-outline-primary badge" type="button" onclick="open_edit_client_modal(client_obj_<%=arrayListClients.get(i).GetId()%>);">Edit</button>
                                            <button class="btn btn-sm btn-outline-danger badge" onclick="open_client_delete_modal('client_servlet?request_type=del&client_id=<%=arrayListClients.get(i).GetId()%>')"><i class="fa fa-trash"></i></button>
                                        </div>
                                    </td>
                                </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
                <% }else{%>
                    <div class="alert alert-info alert-dismissible fade show" role="alert">
                        <strong>Report!</strong> No Clients Added yet.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                <% }%>
            <% }%>
            <button type="button" class="btn btn-primary btn-block add_client_btn" data-toggle="modal" data-target="#insert_clients_modal">Add Client</button>
        </div>
    </div>
    <%@include file="includes/footer.html" %>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <!-- Modals -->
    <%@include file="modals/client_modals/insert_client_modal.jsp" %>
    <%@include file="modals/client_modals/client_address_modal.jsp" %>
    <%@include file="modals/client_modals/edit_client_modal.jsp" %>
    <%@include file="modals/client_modals/delete_confirm_modal.jsp" %>
    
    <!-- scripts -->
    <script type="text/javascript" src="javascript/clients.js"></script>
  </body>
</html>