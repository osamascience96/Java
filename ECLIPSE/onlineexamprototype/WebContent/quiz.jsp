<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Quiz</title>
    <style>
    	body {
		    background-color: #eee
		}
		
		label.radio {
		    cursor: pointer
		}
		
		label.radio input {
		    position: absolute;
		    top: 0;
		    left: 0;
		    visibility: hidden;
		    pointer-events: none
		}
		
		label.radio span {
		    padding: 4px 0px;
		    border: 1px solid red;
		    display: inline-block;
		    color: orange;
		    width: 100px;
		    text-align: center;
		    border-radius: 3px;
		    margin-top: 7px;
		    text-transform: uppercase
		}
		
		label.radio input:checked+span {
		    border-color: green;
		    background-color: lightgreen;
		    color: #fff
		}
		
		.ans {
		    margin-left: 36px !important
		}
		
		.btn:focus {
		    outline: 0 !important;
		    box-shadow: none !important
		}
		
		.btn:active {
		    outline: 0 !important;
		    box-shadow: none !important
		}
    </style>
  </head>
  <body>
  	<%@include file="includes/navigation.jsp" %>
  	<div class="container mt-5">
  		<% if(session.getAttribute("is_login") != null){ %>
  			<div class="d-flex justify-content-center row">
        <div class="col-md-10 col-lg-10">
            <div class="border">
                <div class="question bg-white p-3 border-bottom">
                    <div class="d-flex flex-row justify-content-between align-items-center mcq">
                        <h4>MCQ Quiz</h4><span>(1 of 20)</span>
                    </div>
                </div>
                <div class="question bg-white p-3 border-bottom">
                    <div class="d-flex flex-row align-items-center question-title">
                        <h3 class="text-danger">Q.</h3>
                        <h5 class="mt-1 ml-2">Which of the following country has largest population?</h5>
                    </div>
                    <div class="ans ml-2">
                        <label class="radio"> <input type="radio" name="population_question" value="brazil"> <span>India</span>
                        </label>
                    </div>
                    <div class="ans ml-2">
                        <label class="radio"> <input type="radio" name="population_question" value="Germany"> <span>Pakistan</span>
                        </label>
                    </div>
                    <div class="ans ml-2">
                        <label class="radio"> <input type="radio" name="population_question" value="Indonesia"> <span>Bangladesh</span>
                        </label>
                    </div>
                    <div class="ans ml-2">
                        <label class="radio"> <input type="radio" name="population_question" value="Russia"> <span>Russia</span>
                        </label>
                    </div>
                </div>
                <div class="d-flex flex-row justify-content-between align-items-center p-3 bg-white"><button class="btn btn-primary d-flex align-items-center btn-danger" type="button"><i class="fa fa-angle-left mt-1 mr-1"></i>&nbsp;previous</button><button class="btn btn-primary border-success align-items-center btn-success" type="button">Next<i class="fa fa-angle-right ml-2"></i></button></div>
            </div>
        </div>
    </div>
  		<% }else{ %>
  			<h4>Kindly Login Before giving the quiz</h4>
  		<% } %>
  	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <%@include file="modal/login.jsp" %>
    <%@include file="modal/logout.jsp" %>
    <script src="js/home.js"></script>
  </body>
</html>