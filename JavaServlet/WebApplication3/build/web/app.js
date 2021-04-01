

const menu=document.querySelector('#mobile-menu');
const menuLinks = document.querySelector('.nav-menu');
    
menu.addEventListener('click', function() {
    menu.classList.toggle('is-active');
    menuLinks.classList.toggle('active');

})


var myWindow;

function openWin() {
    myWindow = window.open("help.html", "_blank", "width=700, height=300");
  }
  