<%@include file="includes/head.jsp" %>
    <%
        String servResp = request.getParameter("response");
    %>
	<p class="invisibile"><a id="contenuto" name="contenuto"></a></p>
	<hr class="invisibile">
	<div id="contenuti">
            <h1>AUTENTICAZIONE</h1>
            <fieldset id="messaggi">
                <legend>Messaggi</legend>
                <br><br>
            </fieldset>
            <br/>	
            <form method=POST action="loginservlet" autocomplete="off">
                <div id="login">
                    <fieldset>
                        <legend>Per accedere al sistema inserire le credenziali</legend>
                        <br><br>
                        <% if(servResp != null){%>
                            <% if(servResp.compareTo("cred_not_provided") == 0){%>
                                <h3 style="color:red;">User Login Credentials not provided</h3>
                            <% }else if(servResp.compareTo("loggedout") == 0){%>
                                <h3 style="color:green;">User Logged Out Successfully</h3>
                            <% }%>
                        <% }%>
                        <label for="j_username">Codice Identificativo</label>
                        <input name="j_username" id="j_username" maxlength="16" required>
                        <br>
                        <label for="j_password">Parola chiave</label>
                        <input type="password" name="j_password" id="j_password" required>
                        <br><br>
                        <input type="submit" name="conferma" value="CONFERMA"  class="button" />
                        <input type="reset" name="ripulisci" value="RIPULISCI"   class="button" />
                        <br><br>
                        <a href="#"><b>Parola chiave dimenticata?</b></a>
                        <br>
                    </fieldset>
                </div>
            </form> 
            <br/><br/>
            <fieldset>
                <legend>Informazioni</legend> 
                Per chiarimenti in merito alla login rivolgersi al numero verde
            </fieldset>
	</div>
	<hr class="invisibile">		
<%@include file="includes/footer.jsp" %>