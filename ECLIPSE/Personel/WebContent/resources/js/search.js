/**
 * Java Script Datei für die Suchfunktion als Manager
   In den Funktionen wird die Eingabe mit dem Inhalt der Tabelle verglichen und wenn diese übereinstimmen, 
   werden diese Elemente bzw. Zeilen eingeblendet ansonsten ausgeblendet.
 */

function search_data_by_id(){
	var input = document.getElementById("search_input_by_id");	// Gibt das Element im Dokument zurück, mit der angegebenen ID...
	var filter = input.value.toUpperCase();						// ...stellt auf Großschreibung. (hier unnötig)
	
	var table = document.getElementById("table_body");			// Gehe zum Table-Body...                      //gibt das Element im Dokument zurück, mit der angegebenen ID -> damit wir auch im Table-Body sind & nicht im Table-Head
	var tr = table.getElementsByTagName("tr");					// ... & gebe da alle Table-Zeilen zurück.     //gibt alle Elemente im Dokument zurück, mit dem angegebenen Tag-Namen
	
																
	for(let i=0; i < tr.length; i++){							// Iteriere durch die Tabellen-Zeilen-Werte...
		var td = tr[i].getElementsByTagName("td")[0];			// ... & speicher die Werte (td) in var "td". (0=id, 1=f_name,...)
		
		if(td){
			var textValue = td.textContent || td.innerHTML;		// Hol den Text-Inhalt des Elements... oder lies & speicher den Inhalt eines HTML-Elements (je nach Version des Browsers)
			
			if(textValue.toUpperCase().indexOf(filter) > -1){	// ... wenn dieser Inhalt (aus der Tabelle) mit dem aus der Suche übereinstimmt...   //indexOf = gibt den Index zurück, an dem das Element "filter" im Array zum ersten Mal auftritt oder -1 wenn nicht
				tr[i].style.display = "";						// ... dann lasse das Element eingeblendet...
			}else{
				tr[i].style.display = "none";					// ... ansonsten blende es aus.
			}
		}
	}
}


function search_data_by_firstname(){
	var input = document.getElementById("search_input_by_first_name");
	var filter = input.value.toUpperCase();
	var table = document.getElementById("table_body");
	var tr = table.getElementsByTagName("tr");
	
	for(let i=0; i < tr.length; i++){
		var td = tr[i].getElementsByTagName("td")[1];
		if(td){
			var textValue = td.textContent || td.innerHTML;
			if(textValue.toUpperCase().indexOf(filter) > -1){
				tr[i].style.display = "";
			}else{
				tr[i].style.display = "none";
			}
		}
	}
}

function search_data_by_lastname(){
	var input = document.getElementById("search_input_by_last_name");
	var filter = input.value.toUpperCase();
	var table = document.getElementById("table_body");
	var tr = table.getElementsByTagName("tr");
	
	for(let i=0; i < tr.length; i++){
		var td = tr[i].getElementsByTagName("td")[2];
		if(td){
			var textValue = td.textContent || td.innerHTML;
			if(textValue.toUpperCase().indexOf(filter) > -1){
				tr[i].style.display = "";
			}else{
				tr[i].style.display = "none";
			}
		}
	}
}


function search_data_by_dateofbirth(){
	var input = document.getElementById("search_input_by_dateofbirth");
	var filter = input.value.toUpperCase();
	var table = document.getElementById("table_body");
	var tr = table.getElementsByTagName("tr");
	
	for(let i=0; i < tr.length; i++){
		var td = tr[i].getElementsByTagName("td")[3];
		if(td){
			var textValue = td.textContent || td.innerHTML;
			if(textValue.toUpperCase().indexOf(filter) > -1){
				tr[i].style.display = "";
			}else{
				tr[i].style.display = "none";
			}
		}
	}
}

function search_data_by_email(){
	var input = document.getElementById("search_input_by_email");
	var filter = input.value.toUpperCase();
	var table = document.getElementById("table_body");
	var tr = table.getElementsByTagName("tr");
	
	for(let i=0; i < tr.length; i++){
		var td = tr[i].getElementsByTagName("td")[4];
		if(td){
			var textValue = td.textContent || td.innerHTML;
			if(textValue.toUpperCase().indexOf(filter) > -1){
				tr[i].style.display = "";
			}else{
				tr[i].style.display = "none";
			}
		}
	}
}

function search_data_by_phone(){
	var input = document.getElementById("search_input_by_phone");
	var filter = input.value.toUpperCase();
	var table = document.getElementById("table_body");
	var tr = table.getElementsByTagName("tr");
	
	for(let i=0; i < tr.length; i++){
		var td = tr[i].getElementsByTagName("td")[6];
		if(td){
			var textValue = td.textContent || td.innerHTML;
			if(textValue.toUpperCase().indexOf(filter) > -1){
				tr[i].style.display = "";
			}else{
				tr[i].style.display = "none";
			}
		}
	}
}

function search_data_by_salary(){
	var input = document.getElementById("search_input_by_salary");
	var filter = input.value.toUpperCase();
	var table = document.getElementById("table_body");
	var tr = table.getElementsByTagName("tr");
	
	for(let i=0; i < tr.length; i++){
		var td = tr[i].getElementsByTagName("td")[7];
		if(td){
			var textValue = td.textContent || td.innerHTML;
			if(textValue.toUpperCase().indexOf(filter) > -1){
				tr[i].style.display = "";
			}else{
				tr[i].style.display = "none";
			}
		}
	}
}

function search_data_by_weeklyhrs(){
	var input = document.getElementById("search_input_by_weeklyhrs");
	var filter = input.value.toUpperCase();
	var table = document.getElementById("table_body");
	var tr = table.getElementsByTagName("tr");
	
	for(let i=0; i < tr.length; i++){
		var td = tr[i].getElementsByTagName("td")[8];
		if(td){
			var textValue = td.textContent || td.innerHTML;
			if(textValue.toUpperCase().indexOf(filter) > -1){
				tr[i].style.display = "";
			}else{
				tr[i].style.display = "none";
			}
		}
	}
}

Hide_input_fields();			// Sodass keine leeren Zeilen am Anfang stehen

function Hide_input_fields(){														// Blende alle Eingabe-Felder aus.
	document.getElementById("search_input_by_id").style.display = "none";
	document.getElementById("search_input_by_first_name").style.display = "none";
	document.getElementById("search_input_by_last_name").style.display = "none";
	document.getElementById("search_input_by_dateofbirth").style.display = "none";
	document.getElementById("search_input_by_email").style.display = "none";
	document.getElementById("search_input_by_phone").style.display = "none";
	document.getElementById("search_input_by_salary").style.display = "none";
	document.getElementById("search_input_by_weeklyhrs").style.display = "none";
}

function select_search_type_function(){
	let search_type = document.getElementById("select_search_type").value;			// Der Wert des Elements wird in die Variable "search_type" gespeichert   // let: deklariert eine Variable im Gültigkeitsbereich des lokalen Blocks. (nicht global oder funktionsweit)
	Hide_input_fields();															// Blende alle Eingabe-Felder aus.
	
	if(search_type === "id"){														// Je nachdem welches Element gewählt wurde, wird dieses angezeigt.
		document.getElementById("search_input_by_id").style.display = "";
	}else if(search_type === "first_name"){
		document.getElementById("search_input_by_first_name").style.display = "";
	}else if(search_type === "last_name"){
		document.getElementById("search_input_by_last_name").style.display = "";
	}else if(search_type === "email"){
		document.getElementById("search_input_by_email").style.display = "";
	}else if(search_type === "weekly_working_hours"){
		document.getElementById("search_input_by_weeklyhrs").style.display = "";
	}else if(search_type === "phone"){
		document.getElementById("search_input_by_phone").style.display = "";
	}else if(search_type === "salary"){
		document.getElementById("search_input_by_salary").style.display = "";
	}else if(search_type === "date_of_birth"){
		document.getElementById("search_input_by_dateofbirth").style.display = "";
	}
}
