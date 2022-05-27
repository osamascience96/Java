/**
 * Java Script Datei für die Suchfunktion als Employee (analog zu Manager, nur ohne password & salary)
   In den Funktionen wird die Eingabe mit dem Inhalt der Tabelle verglichen und wenn diese übereinstimmen, 
   werden diese Elemente bzw. Zeilen eingeblendet ansonsten ausgeblendet.
 */

function search_data_by_id(){
	var input = document.getElementById("search_input_by_id");
	var filter = input.value.toUpperCase();
	var table = document.getElementById("table_body");
	var tr = table.getElementsByTagName("tr");
	
	for(let i=0; i < tr.length; i++){
		var td = tr[i].getElementsByTagName("td")[0];
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
		var td = tr[i].getElementsByTagName("td")[5];
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

Hide_input_fields();
function Hide_input_fields(){
	document.getElementById("search_input_by_id").style.display = "none";
	document.getElementById("search_input_by_first_name").style.display = "none";
	document.getElementById("search_input_by_last_name").style.display = "none";
	document.getElementById("search_input_by_dateofbirth").style.display = "none";
	document.getElementById("search_input_by_email").style.display = "none";
	document.getElementById("search_input_by_phone").style.display = "none";
	document.getElementById("search_input_by_weeklyhrs").style.display = "none";
}

function select_search_type_function(){
	let search_type = document.getElementById("select_search_type").value;
	Hide_input_fields();
	if(search_type === "id"){
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
	}else if(search_type === "date_of_birth"){
		document.getElementById("search_input_by_dateofbirth").style.display = "";
	}
}
