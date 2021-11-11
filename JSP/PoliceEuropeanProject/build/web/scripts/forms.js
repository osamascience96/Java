const forms = {
	"form-add" : {
		elements : {
			"add_date_incident"		: {validValue : false, events : ["change"]},
		},
		submit : "add-submit",
		triggers : [
			{
				src : "add_pdq_nb",
				action : {
					event :"change",
					data : emplacementsPDQ,
					dest :"add_pdq_place"
				}
			},{
				src : "add_cat_intervention",
				action : {
					event :"change",
					data : catInterventions,
					dest : "add_desc_intervention"
				}
			}
		]
	},
	"form-modify-search" : {
		elements : {
			"modify_no_intervention": {validValue : false, events : ["input"]},
		},
		submit : "modify-search-submit"
	},
	"form-modify-alter" : {
		elements : {
			"modify_date_incident"  : {validValue : false, events : ["change"]},
		},
		submit : "modify-alter-submit",
		triggers : [
			{
				src : "modify_pdq_nb",
				action : {
					event :"change",
					data : emplacementsPDQ,
					dest :"modify_pdq_place"
				}
			},{
				src : "modify_cat_intervention",
				action : {
					event :"change",
					data : catInterventions,
					dest : "modify_desc_intervention"
				}
			}
		]
	},
	"form-remove-search" : {
		elements : {
			"remove_no_intervention": {validValue : false, events : ["input"]},
		},
		submit : "remove-search-submit"
	},
	"form-remove" : {
		submit : "remove-submit"
	},

}	

const linkedForms = [
	{
		prerequisite_form : "form-modify-search",
		final_form        : "form-modify-alter",
		interventionValidationFlag :  validInterventionNbToModify
	}, {
		prerequisite_form : "form-remove-search",
		final_form        : "form-remove",
		interventionValidationFlag :  validInterventionNbToRemove
	}
]

const updateAfterChange = (e) => {
	for(trigger of forms[e.currentTarget.form.id].triggers) {
		if(trigger.src == e.currentTarget.id) {
			document.getElementById(trigger.action.dest).value = trigger.action.data[document.getElementById(e.currentTarget.id).options[document.getElementById(e.currentTarget.id).selectedIndex].value]; 
			break;
		}
	}
}

const toggleActivation = (buttonId, active) => {
	const btn = document.getElementById(buttonId)
	btn.disabled = !active;
	btn.style.cursor = active ? "pointer" : "default";
}

const revalidate = (e) => {
	const currentTarget   = e.currentTarget;
	const currentTargetId = currentTarget.id;
	const formId          = currentTarget.form.id;

	forms[formId].elements[currentTargetId].validValue = currentTarget.value != "";

	let allChecked = true;
	for (form_element in forms[formId].elements) {
		allChecked = allChecked && forms[formId].elements[form_element].validValue;
	}

	toggleActivation(forms[formId].submit, allChecked);
}

const getUrlParameter = (name) => {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
};

const modifyIntervention = (e) => {
	e.preventDefault();
	console.log(window.location.search);

	interventionToModify[1] = document.getElementById("modify_date_incident").value;
	interventionToModify[2] = document.getElementById("modify_cat_intervention").value;
	interventionToModify[3] = document.getElementById("modify_pdq_nb").value;
	interventionToModify[4] = quarts[document.getElementById("modify_quart").value];
	
	window.location.search = "?update-intervention=&modify_no_intervention=" + getUrlParameter("modify_no_intervention") + "&" + 
							 "modify_date_incident=" + interventionToModify[1] + "&" +
							 "modify_cat_intervention=" + interventionToModify[2] + "&" +
							 "modify_pdq_nb=" + interventionToModify[3] + "&" +
							 "modify_quart=" + interventionToModify[4];
}

const init = () => {
	//Lors de la déclaration d'un nouveau rapport d'intervention, mettre la date du jour comme date par défaut
	document.getElementById("add_date_incident").value = new Date().toISOString().substring(0, 10);
	
	document.getElementById("form-modify-alter").addEventListener("submit", modifyIntervention);
	
	let form;
	for (form_id in forms) {
		form = forms[form_id];

		if(form.elements)
			toggleActivation(form.submit, false);

		for (form_element in form.elements) {
			form.elements[form_element].events.forEach((eventName) => {
				document.getElementById(form_element).addEventListener(eventName, revalidate);
				document.getElementById(form_element).dispatchEvent(new Event(eventName));
			});
		}

		if(form.triggers) {
			for(trigger of form.triggers) {
				document.getElementById(trigger.src).addEventListener(trigger.action.event, updateAfterChange);
				document.getElementById(trigger.src).options.selectedIndex = 0;
				document.getElementById(trigger.src).dispatchEvent(new Event(trigger.action.event));
			}
		}
	}
	
	// Pour les pages-écrans de mise-à-jour et retrait de rapports d'interventions,
	// initialement désactiver les formulaires de modification / retrait.
	// suite à une recherche fructueuse, afficher les formulaires

	let prerequisiteForm, finalForm;
	
	for (linkedForm of linkedForms) {
		prerequisiteForm = document.getElementById(linkedForm.prerequisite_form);
		finalForm        = document.getElementById(linkedForm.final_form);
		if(!linkedForm.interventionValidationFlag)
			finalForm.classList.add("d-none");
		else
			finalForm.classList.remove("d-none");
	}
}


window.addEventListener("load", init);
