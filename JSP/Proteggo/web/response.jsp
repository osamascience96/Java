<%@include file="includes/head.jsp" %>
    <%
        String servResp = request.getParameter("response");
    %>
    </head>
	<p class="invisibile"><a id="contenuto" name="contenuto"></a></p>
	<hr class="invisibile">
	<div id="contenuti">
            <h1>AUTENTICAZIONE</h1>
            <fieldset id="messaggi">
                <legend>Messaggi</legend>
                <br><br>
            </fieldset>
            <br/>	
            <div id="login">
                <fieldset>
                    <legend>Per accedere al sistema inserire le credenziali</legend>
                    <br><br>
                    <% if(servResp != null){ %>
                        <% if(servResp.compareTo("login_success") == 0){%>
                            <h1 style="color: green;">Login Successful</h1>
                        <% }else if(servResp.compareTo("login_failed") == 0){%>
                            <h1 style="color: red;">Login Failed</h1>
                        <% }else if(servResp.compareTo("user_not_exists") == 0){%>
                            <h1 style="color: red;">User does not exists</h1>
                        <% }%>
                    <% }%>
                </fieldset>
            </div>
            <br/><br/>
            <fieldset>
                <legend>Informazioni</legend> 
                Per chiarimenti in merito alla login rivolgersi al numero verde
            </fieldset>
	</div>
	<hr class="invisibile">		
<%@include file="includes/footer.jsp" %>