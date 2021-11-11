        <%@include file="includes/header.jsp" %>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/register.css" />
    </head>
    <body>
        <%
            String resp = request.getParameter("response");
            if(resp != null){
        %>
                <%
                    if(resp.compareTo("user_exists") == 0){
                        
                %>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Failed!</strong> Customer Already Exists.
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                <% }else if(resp.compareTo("email_invalid") == 0){%>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Failed!</strong> Invalid Email Provided.
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                <% }else if(resp.compareTo("phone_invalid") == 0){%>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Failed!</strong> Invalid Phone Provided. The Phone must be 11 or 12 characters long.
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                <% }else if(resp.compareTo("password_unmatched") == 0){%>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Failed!</strong> Password unmatched.
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                <% }%>
            <% }%>
	<body>
		<div class="container">
			<h1>REGISTRATION</h1>
                        <form action="Register" method="POST">
				<div class="user-details">
					<div class="input-box">
						<span class="details">Full Name</span>
						<input name="name" type="text" placeholder="Enter your name" required />
					</div>
					<div class="input-box">
						<span class="details">Username</span>
						<input name="username" type="text" placeholder="Enter your username" required />
					</div>
					<div class="input-box">
						<span class="details">Email</span>
						<input name="email" type="text" placeholder="Enter your email" required />
					</div>
					<div class="input-box">
						<span class="details">AMKA</span>
						<input name="number" type="text" placeholder="AMKA" required />
					</div>
					<div class="input-box">
						<span class="details">Password</span>
						<input name="password" type="password" placeholder="Enter your password" required />
					</div>
					<div class="input-box">
						<span class="details">Confirm Password</span>
						<input name="confirm_password" type="password" placeholder="Confirm your password" required />
					</div>
				</div>
				<div class="button">
					<input type="submit" value="Register" />
				</div>
			</form>
		</div>
<%@include file="includes/footer.jsp"%>
