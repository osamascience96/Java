<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <div class="card fixed-bottom bg-dark">
        <div class="card-body">
          <blockquote class="blockquote mb-0 text-white">
            <%
                if(session.getAttribute("username") != null){
            %>
                <%
                    if(application.getAttribute("tracking") != null){
                    boolean is_tracked = (Boolean) application.getAttribute("tracking");
                %>
                <%
                    if(is_tracked){
                %>
                    <p>Dear User you are tracked</p>
                <% }
                }%>
            <% }%>
            <footer class="blockquote-footer text-white">Developed by <cite title="Source Title">Nothing</cite></footer>
          </blockquote>
        </div>
    </div>
  </body>
</html>