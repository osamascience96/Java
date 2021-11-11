<%
    // check if the request is send 
    if(request.getParameter("add_intervention") != null){
        String add_intervention = request.getParameter("add_intervention");
        if(add_intervention.compareTo("true") == 0){
            // dispatch to servlet
            RequestDispatcher rd = request.getRequestDispatcher("file_servlet");
            rd.forward(request, response);
        }
    }
%>
<%@page import="java.io.File"%>
<%@page import="FileHandling.ReadFile"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<html lang="fr">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <title>SPVM - Interventions</title>
  </head>
  <body>
	<script>
		//Généré dynamiquement en Java et utilisé par scripts/forms.js
		const emplacementsPDQ= {
		};
		//Généré dynamiquement en Java et utilisé par scripts/forms.js
		const catInterventions= {};
		//Généré dynamiquement en Java et utilisé par scripts/forms.js
		const quarts				= {
			"3" : "nuit",
			"2" : "soir",
			"1" : "jour"
		};
		//Généré dynamiquement en Java et utilisé par scripts/rapport.js
		var nbInterventionsParPDQ = {};
                // Make the date comparisons
                <%
                    String interventionspath = request.getServletContext().getRealPath("/").concat("/data/interventions.tsv");
                    ArrayList<String> DateList = new ReadFile().GetMinandMaxDate(new File(interventionspath));
                %>
		const dateMin               = "<%=DateList.get(1)%>";
		const dateMax               = "<%=DateList.get(DateList.size() - 1)%>";

		let validInterventionNbToRemove;
		let validInterventionNbToModify;
		let interventionToModify;
	</script>

    <div class="container">
   		<!-- Fenêtre modale -->
		<div class="modal fade" id="popup" tabindex="-1" role="dialog" aria-labelledby="popup-title" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="popup-title">Success</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div id="popup-message" class="modal-body">Data Added Successfully</div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
		      </div>
		    </div>
		  </div>
		</div>
      <header class="row bg-dark text-light align-items-center p-0">
        <h1 class="col-10">SPVM - Interventions</h1>
        <img class="col-2 my-2" src="./images/SPVM_badge.png" alt="Logo - Service de police de la ville de Montréal">
        <div class="col-12 bg-secondary text-light mb-0 p-2">
        	<div class="row m-0 p-0">
                    <h6 class="col-md-6 m-0 p-0"><span id="mindatetext"></span></h6>
	        	<h6 class="col-md-6 m-0 p-0 text-md-right"><span id="maxdatetext"></span></h6>
	        </div>
        </div>
      </header>
      <nav class="row mt-3">
		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a class="nav-link active" id="nav-report-tab" data-toggle="tab" href="#nav-report" role="tab" aria-controls="nav-report" aria-selected="true"><i class="bi bi-card-text"></i> Rapport</a>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><i class="bi bi-collection"></i> Intervention</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" id="nav-add-tab" data-toggle="tab" href="#nav-add" role="tab" aria-controls="nav-add" aria-selected="true"><i class="bi bi-plus-square"></i> Déclaration</a>
					<a class="dropdown-item" id="nav-modify-tab" data-toggle="tab" href="#nav-modify" role="tab" aria-controls="nav-modify" aria-selected="true"><i class="bi bi-toggle-off"></i> Mise-à-jour</a>
					<a class="dropdown-item" id="nav-remove-tab" data-toggle="tab" href="#nav-remove" role="tab" aria-controls="nav-remove" aria-selected="true"><i class="bi bi-dash-square"></i> Retrait</a>
				</div>
				<li class="nav-item">
					<a class="nav-link" id="nav-chart-tab" data-toggle="tab" href="#nav-chart" role="tab" aria-controls="nav-chart" aria-selected="true"><i class="bi bi-graph-up"></i> Visualisation</a>
				</li>
			</li>
		</ul>
	  </nav>
	  <div class="tab-content" id="nav-tabContent">
		<div class="tab-pane fade show active" id="nav-report" role="tabpanel" aria-labelledby="nav-report-tab">
	      <div class="bg-light p-3 row">
	        <h2><i class="bi bi-card-text"></i><span class="align-bottom"> | Rapport d'interventions</span><a class="text-dark" href="#derniere-mise-a-jour">*</a></h2>
	          <table class="table col-lg-11 col-md-12 table-striped table-hover mx-auto">
	            <thead class="thead-dark">
	              <tr>
	                <th class="text-left">Poste de quartier</th>
	                <th>Emplacement</th>
	                <th class="text-right"><a class="text-light" href="#derniere-mise-a-jour">*</a> Nombre d'interventions répertoriées</th>
	              </tr>
	            </thead>
	            <tbody id="interventions-par-poste">
                        <%
                            String path = request.getServletContext().getRealPath("/").concat("/data/pdq.csv");
                            ArrayList<String> AllPDQArrayList = new ReadFile(path).GetAllPDQ();
                            for(int i=0; i < AllPDQArrayList.size(); i++){
                        %>
                            <%
                                String data[] = AllPDQArrayList.get(i).split(";");
                            %>
                            <tr><td><%=data[0]%></td><td><%=data[1]%></td><td class="text-right"><%=data[2]%></td></tr>
                            <script>
                                nbInterventionsParPDQ["<%=data[0]%>"] = "<%=data[2]%>";
                                emplacementsPDQ["<%=data[0]%>"] = "<%=data[1]%>";
                            </script>
                        <% }%>
	            </tbody>
	          </table>
	      </div>
		</div>
		<div class="tab-pane fade" id="nav-add" role="tabpanel" aria-labelledby="nav-add-tab">
	      <div class="bg-light p-3 row">
	        <h2><i class="bi bi-plus-square"></i><span class="align-bottom"> | Rapport de déclaration d'une intervention</span></h2>
			<form id="form-add" class="form col-lg-11 col-md-12 mx-auto">
                            <input type="hidden" name="add_intervention" value="true"/>
				<div class="form-row">
					<div class="form-group col-md-3">
						<label for="add_pdq_nb"># Poste de quartier</label>
						<select class="form-control" id="add_pdq_nb" name="add_pdq_nb">
                                                    <%
                                                        for(int i=0; i < AllPDQArrayList.size(); i++){
                                                    %>
							<option value="<%=AllPDQArrayList.get(i).split(";")[0]%>"><%=AllPDQArrayList.get(i).split(";")[0]%></option>
                                                    <% }%>
						</select>
					</div>
					<div class="form-group col-md-9">
						<label for="add_pdq_place">Emplacement</label>
						<input	type="text" class="form-control" id="add_pdq_place" disabled>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="add_cat_intervention">Catégorie</label>
						<select class="form-control" id="add_cat_intervention" name="add_cat_intervention">
                                                    <%
                                                        String categoryListpath = request.getServletContext().getRealPath("/").concat("/data/cat�goriesInterventions.csv");
                                                        ArrayList<String> categoryArrayList = new ReadFile(categoryListpath).GetCategoryInterventionList();
                                                    %>
                                                    <%
                                                        for(int i=1; i < categoryArrayList.size(); i++){
                                                            String data[] = categoryArrayList.get(i).split(";");
                                                    %>
                                                        <option value="<%=data[0]%>"><%=data[0]%></option>
                                                        <script>
                                                            catInterventions["<%=data[0]%>"] = "<%=data[1]%>";
                                                        </script>
                                                    <% }%>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="add_desc_intervention">Description</label>
						<textarea class="form-control" id="add_desc_intervention" disabled style="height:82%; box-sizing: border-box;">Vol accompagné de violence de commerce, institution financière, personne, sac à main, véhicule blindé, véhicule, arme à feu, et tous autres types de vols qualifiés</textarea>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="add_date_incident">Date d'incident</label>
						<input type="date" class="form-control" name="add_date_incident" id="add_date_incident">
					</div>
					<div class="form-group col-md-6">
						<label for="add_quart">Quart</label>
						<select class="form-control form-select" id="add_quart" name="add_quart">
                                                    <%
                                                        String quarterListpath = request.getServletContext().getRealPath("/").concat("/data/quarts_travail.csv");
                                                        ArrayList<String> quarterArrayList = new ReadFile(quarterListpath).GetQuarterList();
                                                    %>
                                                    <%
                                                        for(int i=1; i < quarterArrayList.size(); i++){
                                                            String data[] = quarterArrayList.get(i).split(";");
                                                    %>
                                                        <option value="<%=data[1]%>" ><%=data[1]%></option>
                                                    <%}%>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-12">
						<button type="submit" id="add-submit" name="add-new-intervention" class="btn btn-warning col-lg-4 col-md-5 offset-lg-8 offset-md-7"><i class="bi bi-plus-square"></i> Soumettre le rapport</button>
					</div>
				</div>
			</form>
	      </div>
		</div>
		<div class="tab-pane fade" id="nav-modify" role="tabpanel" aria-labelledby="nav-modify-tab">
	      <div class="bg-light p-3 row">
	        <h2><i class="bi bi-toggle-off"></i><span class="align-bottom"> | Mise-à-jour d'un rapport d'intervention</span></h2>
 			<form id="form-modify-search" class="form col-lg-11 col-md-12 mx-auto">
				<div class="form-row">
					<div class="form-group col-md-11">
						<input type="text" class="form-control" id="modify_no_intervention" name="modify_no_intervention" placeholder="Inscrire le # du rapport d'intervention à mettre à jour"
								>
					</div>
					<div class="form-group col-md-1">
						<button type="submit" id="modify-search-submit" class="form-control btn btn-info"><i class="bi bi-search"></i></button>
					</div>
				</div>
			</form>
 			<form id="form-modify-alter" class="form col-lg-11 col-md-12 mx-auto d-none">
				<div class="form-row">
					<div class="form-group col-md-3">
						<label for="modify_pdq_nb"># Poste de quartier</label>
						<select class="form-control form-select" id="modify_pdq_nb" name="modify_pdq_nb">
                                                    <%
                                                        for(int i=0; i < AllPDQArrayList.size(); i++){
                                                    %>
							<option value="<%=AllPDQArrayList.get(i).split(";")[0]%>"><%=AllPDQArrayList.get(i).split(";")[0]%></option>
                                                    <% }%>
						</select>
					</div>
					<div class="form-group col-md-9">
						<label for="modify_pdq_place">Emplacement</label>
						<input type="text" class="form-control" id="modify_pdq_place" value="Ville-Marie Ouest, Westmount" disabled>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="modify_cat_intervention">Catégorie</label>
						<select class="form-control" id="modify_cat_intervention" name="modify_cat_intervention" size="6">
	            			<option value="Vols qualifiés">Vols qualifiés</option>
	            			<option value="Vol de véhicule à moteur">Vol de véhicule à moteur</option>
	            			<option value="Infractions entrainant la mort">Infractions entrainant la mort</option>
	            			<option value="Méfait">Méfait</option>
	            			<option value="Vol dans / sur véhicule à moteur">Vol dans / sur véhicule à moteur</option>
	            			<option value="Introduction">Introduction</option>
						</select>
					</div>
					<div class="form-group col-md-6">
						<label for="modify_desc_intervention">Description</label>
						<textarea class="form-control" id="modify_desc_intervention" disabled style="height:82%; box-sizing: border-box;">Vol accompagné de violence de commerce, institution financière, personne, sac à main, véhicule blindé, véhicule, arme à feu, et tous autres types de vols qualifiés</textarea>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="modify_date_incident">Date d'incident</label>
						<input type="date" class="form-control" id="modify_date_incident" name="modify_date_incident">
					</div>
					<div class="form-group col-md-6">
						<label for="modify_quart">Quart</label>
						<select class="form-control" id="modify_quart" name="modify_quart">
			            	<option value="3" >nuit</option>
			            	<option value="2" >soir</option>
			            	<option value="1" >jour</option>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-12">
						<button type="submit" id="modify-alter-submit" name="update-intervention" class="btn btn-warning col-lg-4 col-md-5 offset-lg-8 offset-md-7"><i class="bi bi-toggle-off"></i> Mise-à-jour du rapport</button>
					</div>
				</div>
			</form>
	      </div>
		</div>
		<div class="tab-pane fade" id="nav-remove" role="tabpanel" aria-labelledby="nav-remove-tab">
	      <div class="bg-light p-3 row">
	        <h2><i class="bi bi-dash-square"></i><span class="align-bottom"> | Retrait d'un rapport d'intervention</span></h2>
 			<form id="form-remove-search" class="form col-lg-11 col-md-12 mx-auto">
				<div class="form-row">
					<div class="form-group col-md-11">
						<input type="text" class="form-control" id="remove_no_intervention" name="remove_no_intervention" placeholder="Inscrire le # du rapport d'intervention à supprimer"
						>
					</div>
					<div class="form-group col-md-1">
						<button type="submit" id="remove-search-submit" class="form-control btn btn-info"><i class="bi bi-search"></i></button>
					</div>
				</div>
			</form>
 			<form id="form-remove" class="form col-lg-11 col-md-12 mx-auto d-none">
				<div class="form-row">
					<div class="form-group col-md-3">
						<label for="remove_pdq_nb"># Poste de quartier</label>
						<input type="text" class="form-control" id="remove_pdq_nb" value="" disabled>
						<input type="hidden" name="no_intervention_to_remove" value="0">
					</div>
					<div class="form-group col-md-9">
						<label for="remove_pdq_place">Emplacement</label>
						<input type="text" class="form-control" id="remove_pdq_place" value="" disabled>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="cat_intervention">Catégorie</label>
						<input type="text" class="form-control" id="remove_cat_intervention" value="" disabled>
					</div>
					<div class="form-group col-md-4">
						<label for="remove_date_incident">Date d'incident</label>
						<input type="date" class="form-control" id="remove_date_incident" value="" disabled>
					</div>
					<div class="form-group col-md-2">
						<label for="remove_quart">Quart</label>
						<input type="text" class="form-control" id="remove_quart" value="" disabled>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-12">
						<button type="submit" id="remove-submit" class="btn btn-warning col-lg-4 col-md-5 offset-lg-8 offset-md-7"><i class="bi bi-dash-square"></i> Retrait du rapport</button>
					</div>
				</div>
			</form>
	      </div>
		</div>
		<div class="tab-pane fade" id="nav-chart" role="tabpanel" aria-labelledby="nav-chart-tab">
	      <div class="bg-light p-3 row">
	        <h2><i class="bi bi-graph-up"></i><span class="align-bottom"> | Visualisation des données</span></h2>
	      </div>
		</div>
  	  </div>
      <footer class="bg-dark text-light p-3 row">
        <h6 id="derniere-mise-a-jour"></h6>
      </footer>

    </div>
                                                
            
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="./scripts/rapport.js"></script>
    <script src="./scripts/nav.js"></script>
    <script src="./scripts/forms.js"></script>
    <script>
        document.getElementById("mindatetext").innerHTML = dateMin;
        document.getElementById("maxdatetext").innerHTML = dateMax;
    </script>
    <script>
        <%
            if(request.getParameter("add_intervention_response") != null){
                if(request.getParameter("add_intervention_response").compareTo("success") == 0){
        %>
            $("#popup").modal("show");
        <%
            }
        }
        %>
    </script>
  </body>
</html>
