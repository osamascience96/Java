<%@include file="includes/header.jsp" %>
                    <div class="container" >
                    <div class="card-deck">
                        <div class="card border-dark">
                            <div class="card-body text-center">
                                <img class="card-img-top" src="assets/images/archive.png">
                                <h5 class="card-title">
                                    Book count: </br></br><b><%=request.getAttribute("bookcount")%></b>
                                </h5>
                                </br>
                                <a href="books_admin_servlet" class="btn btn-dark">View</a>
                            </div>
                        </div>
                        <div class="card border-dark">
                            <div class="card-body text-center">
                                <img class="card-img-top" src="assets/images/check.png">
                                <h5 class="card-title">
                                    Borrow count: </br></br> <b><%=request.getAttribute("booksloaned")%></b>
                                </h5>
                                </br>
                                <a href="borrow_servlet" class="btn btn-dark">View</a>
                            </div>
                        </div>
                        <div class="card border-dark">
                            <div class="card-body text-center">
                                <img class="card-img-top" src="assets/images/person.png">
                                <h5 class="card-title">
                                    Member count: </br></br> <b><%=request.getAttribute("membercount")%></b>
                                </h5>
                                </br>
                                <a href="member_admin_servlet" class="btn btn-dark">View</a>
                            </div>
                        </div>
                    </div>
                </div>
        </body>
    </html>