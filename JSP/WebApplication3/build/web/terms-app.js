function myFunction(event) {
    var x = event.key;
    document.getElementById("demo").innerHTML = "Signature: " + x;
  }

  function checkFunction() {
    var checkBox = document.getElementById("tc");
    
    if (checkBox.checked == true){
        alert("Welcome to Horizon Online Banking!");
    } else {
       return false;
    }
  }

  var myWindow;

function openDOM() {
    myWindow = window.open("dom.html", "_blank", "width=700, height=300");
  }
  