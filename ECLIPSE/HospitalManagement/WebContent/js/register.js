/**
 * 
 */

$(document).ready(function(){
	
	ClassicEditor.create(document.querySelector('#qualifications'))
	.then(editor => {
		console.log(editor);
	})
	.catch(error => {
		console.error(error);
	});
	
	ClassicEditor.create(document.querySelector('#cures'))
	.then(editor => {
		console.log(editor);
	})
	.catch(error => {
		console.error(error);
	});
	
	$("#doctor_signup_check").change(function(){
		if(this.checked){
			document.getElementById("qual").style.display = "block";
			document.getElementById("cure").style.display = "block";
		}else{
			document.getElementById("qual").style.display = "none";
			document.getElementById("cure").style.display = "none";
		}
	});
});