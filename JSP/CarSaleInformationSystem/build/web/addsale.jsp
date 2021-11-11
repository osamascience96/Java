<%@page import="Bean.Car"%>
<%@page import="java.util.ArrayList"%>
<%@include file="includes/header.jsp" %>
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="css/addsale.css">
    </head>
    <%
        // disable the cache to page to disable any page content in the cache
        // clearing the cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
        response.setHeader("Pragma", "no-cache"); // Http 1.0
        if(session.getAttribute("is_login") == null){
            response.sendRedirect("index.jsp");
        }
    %>
    <body>
        <%@include file="includes/navigation.jsp" %>
        <div class="container">
            <form action="car_servlet" method="post" enctype="multipart/form-data">
              <div class="row">
                <div class="col-25">
                  <label for="manufacturer">Manufacturer</label>
                </div>
                <div class="col-75">
                  <input type="text" id="manufacturer" name="manufacturer" placeholder="Manufacturer" required>
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="model">Model</label>
                </div>
                <div class="col-75">
                  <input type="text" id="model" name="model" placeholder="Model" required>
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="type">Type</label>
                </div>
                <div class="col-75">
                  <select id="type" name="type" required>
                    <option value="normal">Normal</option>
                    <option value="suv">SUV</option>
                    <option value="van">Van</option>
                  </select>
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="year_of_manufacturer">Year of Manufacturer</label>
                </div>
                <div class="col-75">
                  <input type="number" id="year_of_manufacturer" name="year_of_manufacturer" placeholder="Year of Manufacturer" required>
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="miles">Miles</label>
                </div>
                <div class="col-75">
                  <input type="number" id="miles" name="miles" placeholder="Driven Miles" required>
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="price">Price</label>
                </div>
                <div class="col-75">
                  <input type="number" id="price" name="price" placeholder="Price" required>
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="hasAC">AC</label>
                </div>
                <div class="col-75">
                  <select id="hasAC" name="hasAC" required>
                    <option value="T">Yes</option>
                    <option value="F">No</option>
                  </select>
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="hasDVD">DVD</label>
                </div>
                <div class="col-75">
                  <select id="hasDVD" name="hasDVD" required>
                    <option value="T">Yes</option>
                    <option value="F">No</option>
                  </select>
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="comments">Comments</label>
                </div>
                <div class="col-75">
                  <textarea id="comments" name="comments" placeholder="Write your Comment" style="height:200px"></textarea>
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="upload">Upload Image</label>
                </div>
                <div class="col-75">
                  <input type="file" id="upload" name="upload">
                </div>
              </div>
              <div class="row">
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Submit">
              </div>
            </form>
        </div>
        <script src="js/addsale.js"></script>
        <script src="js/toast.js"></script>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
