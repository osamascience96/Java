const nav = {
	//href			: id
	"#nav-report"	: {tab : "nav-report-tab"	,	div  : "nav-report"	},
	"#nav-add"		: {tab : "nav-add-tab"		,	div  : "nav-add"	},
	"#nav-modify"	: {tab : "nav-modify-tab"	,	div  : "nav-modify"	},
	"#nav-remove"	: {tab : "nav-remove-tab"	,	div  : "nav-remove"	},
	"#nav-chart"	: {tab : "nav-chart-tab"	,	div  : "nav-chart"	},
};

const updateTabPane = () => {
	const defaultTab  = "#nav-report";
	let tabPaneToActivate = (nav.hasOwnProperty(window.location.hash))
							 ? nav[window.location.hash]
							 : nav[defaultTab];
	let divId, anchorId;
	for(let element in nav) {
		divId    = nav[element].div;
		anchorId = nav[element].tab;
		
		if(divId == tabPaneToActivate.div) {
			document.getElementById(anchorId).classList.add("active");
			document.getElementById(divId).classList.add("show","active");
			//document.getElementById(divId).classList.remove("d-none");
		} else {
			document.getElementById(anchorId).classList.remove("active");
			document.getElementById(divId).classList.remove("show", "active");
			//document.getElementById(divId).classList.add("d-none");
		}
	}

	if(["nav-add","nav-modify","nav-remove"].includes(tabPaneToActivate.div))
		document.querySelector("a.dropdown-toggle").classList.add("active");
	else
		document.querySelector("a.dropdown-toggle").classList.remove("active");
}

const updateURL = () => {
	for(let element in nav) {
		document.getElementById(nav[element].tab).addEventListener("click", (me)=> {
			window.location.href = me.currentTarget.href;
		})
	}
}

window.addEventListener("load", updateURL);
window.addEventListener("load", updateTabPane);
window.addEventListener("hashchange", updateTabPane);
