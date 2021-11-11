const highlightTimeoutSec = 1;

const calculerStatistiques = (data) => {
  let min = Number.MAX_VALUE;
  let max = 0;

  nb_interventions = [];
  let nb;
  for(let pdq in data) {
	  nb = Number.parseInt(data[pdq]);
	if(nb > max)
      max = nb;
    if(nb < min)
      min = nb;

    nb_interventions.push(nb);
  }
  const mid = Math.floor(nb_interventions.length / 2),
  sorted = [...nb_interventions].sort((a, b) => a - b);

  return {
    "min" : min,
    "max" : max,
    "medianes" : nb_interventions.length % 2 !== 0 ? [sorted[mid]] : [sorted[mid - 1], sorted[mid]]
  }
}

window.addEventListener("load", () => {
	window.setTimeout(() => {
		const stats = calculerStatistiques(nbInterventionsParPDQ);
		const tds = document.getElementsByTagName("td");
		  
		let spanMax;
		for(td of tds) {
			if(td.textContent == stats["max"]) {
				td.parentNode.className += " bg-danger text-light font-weight-bold";

				badge = document.createElement("span");
				badge.className = "badge badge-light";
				badge.textContent = "région la plus touchée";
		      
				td.previousElementSibling.textContent += " ";
				td.previousElementSibling.appendChild(badge);
			} else if(td.textContent == stats["min"]) {
				td.parentNode.className += " bg-success text-light font-weight-bold";

				badge = document.createElement("span");
				badge.className = "badge badge-light";
				badge.textContent = "région la moins touchée";
				
				td.previousElementSibling.textContent += " ";
				td.previousElementSibling.appendChild(badge);
			} else if(stats["medianes"].indexOf(parseInt(td.textContent)) != -1) {
				td.parentNode.className += " bg-warning text-dark font-weight-bold";

				badge = document.createElement("span");
				badge.className = "badge badge-light";
				badge.textContent = "région la moins touchée";
		      
				td.previousElementSibling.textContent += " ";
				td.previousElementSibling.appendChild(badge);
			}
		}
	}, highlightTimeoutSec*1000);
});


window.addEventListener("load", () => {
  document.getElementById("derniere-mise-a-jour").textContent += "* "+ dateMin +" à aujourd'hui, dernière mise à jour des données : " + dateMax;
});
