<%@page import="java.util.Map"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Session Tracking</title>
  </head>
  <body>
      <nav class="navbar navbar-light bg-light">
        <div class="form-inline">
            <button class="btn btn-outline-primary" type="button" data-toggle='modal' data-target='#session_modal'>My Cart</button>
        </div>
      </nav>
      <div class="container">
          <div class="text-center">
              <h4>Buy Anything you want</h4>
          </div>
          <div class="w-100"></div>
          <div class="row">
              <!-- button column -->
              <div class="col">
                  <a class="btn btn-success btn-block" type="button" href="servlet?name=yacht">yacht</a>
              </div>
              <div class="col">
                  <a class="btn btn-primary btn-block" type="button" href="servlet?name=car">car</a>
              </div>
              <div class="col">
                  <a class="btn btn-info btn-block" type="button" href="servlet?name=book">book</a>
              </div>
          </div>
      </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <!-- Modal -->
    <div class="modal fade" id="session_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">My Cart</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
              <div class="container">
                    <% if(session.getAttribute("cart_list") != null){ %>
                        <%
                            Map<String, Integer> mapCartList = (Map<String, Integer>)session.getAttribute("cart_list");
                        %>
                            <% if(mapCartList != null){%>
                                <%
                                    for(Map.Entry<String, Integer> cartListEntry: mapCartList.entrySet()){
                                %>
                                    <h6><%=cartListEntry.getKey()%> ==> <%=cartListEntry.getValue()%></h6>
                                    <div class="w-100"></div>
                                <% }%>
                            <% }%>
                    <% }else{%>
                        <div role='alert' class="alert alert-warning">No Items Selected.</div>
                    <% }%>
              </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>