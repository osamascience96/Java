<%-- 
    Document   : Assignment 1
    Created on : 04/02/2021
    Author     : Jaykishan Jethva
--%>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="org.nbcc.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    ArrayList errorList = new ArrayList();
    public static double TAX = 15;
    public static double DISCOUNT = 10;
    public boolean processed = false;

    public String checkRequiredField(String value, String fieldName) {
        if (value.trim().length() == 0) {
            errorList.add(fieldName + " is required.");
            return "";
        } else {
            return value;
        }
    }

    public double getDoubleValue(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }

    public int getIntegerValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public boolean isNumeric(String value, String fieldName) {
        try {
            double d = Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            errorList.add(fieldName + " should be numeric.");
            return false;
        }
        return true;
    }

    public String currencyFormatter(double value) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(value);
    }

%>

<%
    // disable the cache to page to disable any page content in the cache
    // clearing the cache
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Http 1.1
    response.setHeader("Pragma", "no-cache"); // Http 1.0
    
    // check if the username and password are set in the session
    if(session.getAttribute("username") == null){
        response.sendRedirect("/SCProject/");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
              crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
                integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
        <script>

        </script>
        <style>
            .pointer {
                cursor: pointer;
            }
        </style>
    </head>
    <body class="p-4">
        <h1>Java EE Assignment 1</h1>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">WMAD Java EE</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarNav" aria-controls="navbarNav"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active"><a class="nav-link" href="index.jsp">Books <span class="sr-only">(current)</span></a></li>
                </ul>
            </div>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active"><a class="nav-link" href="logout">Logout <span class="sr-only">(current)</span></a></li>
                </ul>
            </div>
        </nav>
        <main>
            <%
                ArrayList campusList = new ArrayList();
                campusList.add("NBCC Moncton");
                campusList.add("NBCC Fredericton");
                campusList.add("NBCC Saint John");
                campusList.add("NBCC Woodstock");
                campusList.add("NBCC MIramichi");
                campusList.add("NBCC St. Andrews");
            %>
            <div class="container-fluid py-4">
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12">
                        <form action="#" method="post" enctype="plain/text">
                            <div class="form-group row">
                                <label for="bookName" class="col-sm-2 col-form-label">Book Name</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="bookName" name="bookName" value="${param.bookName}">
                                </div>
                            </div>
                            <hr>
                            <div class="form-group row">
                                <label for="subject" class="col-sm-2 col-form-label">Subject</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="subject" name="subject" value="${param.subject}">
                                </div>
                            </div>
                            <hr>
                            <div class="form-group row">
                                <label for="campus" class="col-sm-2 col-form-label">Campus</label>
                                <div class="col-sm-10">
                                    <select id="campus" class="form-control" name="campus">
                                        <%  for (int i = 0; i < campusList.size(); i++) {
                                                String option = (String) campusList.get(i);
                                                if (session.getAttribute("campusIndex") != null && (int) session.getAttribute("campusIndex") == i) {
                                        %>
                                        <option value="<%= i%>" selected="selected"><%= option%></option>
                                        <%
                                        } else {
                                        %>
                                        <option value="<%= i%>"><%= option%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                            <hr>
                            <div class="form-group row">
                                <label for="price" class="col-sm-2 col-form-label">Price</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" id="price" name="price" value="${param.price}">
                                </div>
                            </div>
                            <hr>
                            <div class="form-group row">
                                <label for="qty" class="col-sm-2 col-form-label">Qty</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" id="qty" name="qty" value="${param.qty}">
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <label for="term" class="col-sm-2 col-form-label">Term</label>
                                <div class="col-sm-10">
                                    <%  for (int i = 1; i < 7; i++) {
                                            if (session.getAttribute("termIndex") != null && (int) session.getAttribute("termIndex") == i) {
                                    %>
                                    <div class="form-check-inline">
                                        <input class="form-check-input" type="radio" name="term"
                                               id="Term<%= i%>" value="<%= i%>" checked="checked"> <label
                                               class="form-check-label" for="Term<%= i%>"> Term
                                            <%= i%> </label>

                                    </div>
                                    <%
                                    } else {
                                    %>
                                    <div class="form-check-inline">
                                        <input class="form-check-input" type="radio" name="term"
                                               id="Term<%= i%>" value="<%= i%>"> <label
                                               class="form-check-label" for="Term<%= i%>"> Term
                                            <%= i%> </label>

                                    </div>
                                    <% }

                                        } %>
                                </div>
                            </div>
                            <div class="form-group row">
                                <button type="submit" value="submit" name="submit" id="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                    <% if (errorList.size() == 0 && processed == true) { %>
                    <div class="col-xl-12 col-lg-12 col-md-12">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Source Campus</th>
                                    <th scope="col">Book Name</th>
                                    <th scope="col">Subject</th>
                                    <th scope="col">Qty</th>
                                    <th scope="col">Subtotal</th>
                                        <%
                                            if (String.valueOf(request.getSession().getAttribute("discountApplicable")) == "true") {
                                        %>
                                    <th scope="col">Discount</th>
                                        <%
                                            }
                                        %>
                                    <th scope="col">Tax</th>
                                    <th scope="col">Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="pointer">
                                    <td data-toggle="modal" data-target="#exampleModal">${order.campus}
                                        </th>
                                    <td>${order.bookName}</td>
                                    <td>${order.subject}</td>
                                    <td>${order.qty}</td>
                                    <td>${order.subtotal}</td>
                                    <%
                                        if (String.valueOf(request.getSession().getAttribute("discountApplicable")) == "true") {
                                    %>
                                    <td>${order.discount}</td>
                                    <%
                                        }
                                    %>
                                    <td>${order.tax}</td>
                                    <td>${order.total}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <%}%>
                </div>
                <% if (errorList.size() > 0) { %>
                <div class="col-xl-12 col-lg-12 col-md-12">
                    <div id="errors" class="alert alert-danger">
                        <ul class="list-group">
                            <%  for (int i = 0; i < errorList.size(); i++) {
                            %>
                            <li><%= errorList.get(i)%></li>
                                <%
                                    }
                                %>
                        </ul>
                    </div>
                </div>
                <% } %>
            </div>

        </main>
    </body>
</html>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Order Details</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h3>Book Ordering Details</h3>
                <table>
                    <tr>
                        <td>Source Campus:</td>
                        <td>${order.campus}</td>
                    </tr>
                    <tr>
                        <td>Book Name:</td>
                        <td>${order.bookName}</td>
                    </tr>
                    <tr>
                        <td>Subject:</td>
                        <td>${order.subject}</td>
                    </tr>
                    <tr>
                        <td>Quantity:</td>
                        <td>${order.qty}</td>
                    </tr>
                    <tr>
                        <td>Order for Term:</td>
                        <td>${order.term}</td>
                    </tr>
                    <tr>
                        <td>Subtotal:</td>
                        <td>${order.subtotal}</td>
                    </tr>
                    <%
                        if (String.valueOf(request.getSession().getAttribute("discountApplicable")) == "true") {
                    %>
                    <tr>
                        <td>Discount</td>
                        <td>${order.discount}</td>
                    </tr>
                    <%
                        }
                    %>
                    <tr>
                        <td>Tax</td>
                        <td>${order.tax}</td>
                    </tr>
                    <tr>
                        <td>Total:</td>
                        <td>${order.total}</td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<%
    if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submit") != null) {
        errorList.clear();
        String bookName = checkRequiredField(request.getParameter("bookName"), "bookName");
        String subject = checkRequiredField(request.getParameter("subject"), "subject");
        String priceAsString = checkRequiredField(request.getParameter("price"), "price");
        String qtyAsString = checkRequiredField(request.getParameter("qty"), "qty");
        int campus = Integer.parseInt(request.getParameter("campus"));
        int term = 0;
        if (request.getParameterMap().containsKey("term")) {
            String termAsString = checkRequiredField(request.getParameter("term"), "term");
            term = isNumeric(termAsString, "term") ? getIntegerValue(request.getParameter("term")) : getIntegerValue("0");
        }
        double price = 0.0;
        if (priceAsString != "") {
            price = isNumeric(priceAsString, "price") ? getDoubleValue(request.getParameter("price")) : getDoubleValue("0");
        }
        int qty = 0;
        if (qtyAsString != "") {
            qty = isNumeric(qtyAsString, "qty") ? getIntegerValue(request.getParameter("qty")) : getIntegerValue("0");
        }
        double subtotal = price * qty;
        double caculatedTax = (TAX / 100) * price;

        double discount = 0.0;
        double total = 0.0;
        boolean discountApplicable = false;
        if (campus == 0 && qty >= 3 && term == 3) {
            discountApplicable = true;
            discount = (DISCOUNT / 100) * subtotal;
            total = (subtotal - discount) + caculatedTax;
        } else {
            total = subtotal + caculatedTax;
        }
        System.out.println("errorList.size()" + errorList.size());
        if (errorList.size() > 0) {
            request.getSession().setAttribute("param", new Order(bookName, subject, campusList.get(0).toString(), qty, price, term, currencyFormatter(discount), currencyFormatter(total), currencyFormatter(subtotal), currencyFormatter(caculatedTax)));
            request.getSession().setAttribute("termIndex", term);
            request.getSession().setAttribute("campusIndex", campus);
        } else {
            request.getSession().removeAttribute("param");
            request.getSession().removeAttribute("termIndex");
            request.getSession().removeAttribute("campusIndex");
        }
        request.getSession().setAttribute("order", new Order(bookName, subject, campusList.get(0).toString(), qty, price, term, currencyFormatter(discount), currencyFormatter(total), currencyFormatter(subtotal), currencyFormatter(caculatedTax)));
        request.getSession().setAttribute("errorList", errorList);
        request.getSession().setAttribute("discountApplicable", discountApplicable);
        processed = true;
        request.getSession().setAttribute("processed", processed);
        processed = false;
        response.sendRedirect(request.getHeader("Referer"));
    }
%>