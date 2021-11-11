/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const toggle = () => {
    const nav = document.getElementById("topnav");
    nav.className === "topnav" ? nav.className += " responsive" : nav.className = "topnav";
};