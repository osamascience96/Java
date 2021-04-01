

function formValidation()
{
var uid = document.registration.userid;
var uemail = document.registration.email;


var passid = document.registration.passid;
var passid2 = document.registration.passid2;


var ufname = document.registration.fname;
var ulname = document.registration.lname;
var umobile = document.registration.mobile;
var uadd = document.registration.address;
var udob = document.registration.dob;
var ucountry = document.registration.country;



if(userid_validation(uid,5,12))
{
if(ValidateEmail(uemail))
{
    if(passid_validation(passid,7,12))
    {
       
        if(matchPassword(passid,passid2))
        {
            if(allFLetter(ufname))
            {
                if(allLLetter(ulname))
                {
                    if(allNumber(umobile))
                    {
                        if(alphanumeric(uadd))
                        {
                            if(dob_validation(udob))
                            {
                                if(countryselect(ucountry))
                                {
                                    alert("Account successfully created.")
                                }
                            }
                        }
                    }
    
                }
    
            } 
        }
         
    }
}
}
    return false;
}

/* Function for validating username */
function userid_validation(uid,mx,my)
{
var uid_len = uid.value.length;
if (uid_len == 0 || uid_len >= my || uid_len < mx)
{
alert("User Id should not be empty / length be between "+mx+" to "+my);
uid.focus();
return false;
}
return true;
}

/* Function for validating email */
function ValidateEmail(uemail)
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(uemail.value.match(mailformat))
{
return true;
}
else
{
alert("You have entered an invalid email address!");
uemail.focus();
return false;
}
}

/* Function for validating password */
function passid_validation(passid,mx,my)
{
var passid_len = passid.value.length;
if (passid_len == 0 ||passid_len >= my || passid_len < mx)
{
alert("Password should not be empty / length be between "+mx+" to "+my);
passid.focus();
return false;
}
return true;
}

/* Function for confirming matching passwords */
function matchPassword(passid, passid2) 
{  
    if(passid2.value.match(passid)) 
  {   
    return true;
        
  } else {  
    alert("Password did not match"); 
    return false; 
  }  
}

/* Function for validating first name */
function allFLetter(ufname)
{ 
var letters = /^[A-Za-z]+$/;
if(ufname.value.match(letters))
{
return true;
}
else
{
alert('First name must have alphabet characters only');
ufname.focus();
return false;
}
}

/* Function for validating last name */
function allLLetter(ulname)
{ 
var letters = /^[A-Za-z]+$/;
if(ulname.value.match(letters))
{
return true;
}
else
{
alert('Last Name must have alphabet characters only');
ulname.focus();
return false;
}
}

/* Function for validating mobile number */
function allNumber(umobile)
{ 
var numbers = /^[0-9]+$/;
if(umobile.value.match(numbers))
{
return true;
}
else
{
alert('Mobile number must have a minimum of 7 numbers');
umobile.focus();
return false;
}
}

/* Function for validating zip code */
function alphanumeric(uadd)
{ 
var letters = /^[0-9a-zA-Z]+$/;
if(uadd.value.match(letters))
{
return true;
}
else
{
alert('Zip code must have alphanumeric characters only');
uadd.focus();
return false;
}
}


/* Function for validating date of birth */
function dob_validation(udob)
{ 
    if(!udob.value)
    {
    alert('Please enter a date of birth.');
    udob.focus();
    return false;
    }
    else
    {
    return true;
    }
}

/* Function for validating country */
function countryselect(ucountry)
{
if(ucountry.value == "Default")
{
alert('Select your country from the list');
ucountry.focus();
return false;
}
else
{
return true;
}
}


/* Popup table */

function myFunction() {
    var popup = document.getElementById("myPopup");
    popup.classList.toggle("show");
    
  }
  
  /* Function to add responses to tabular column */
  function addRow()
  {
    
    var userid = document.getElementById("userid");
    var email = document.getElementById("email");
     var fname = document.getElementById("fname");
    var lname = document.getElementById("lname");
    var mobile = document.getElementById("mobile");
    var address = document.getElementById("address");
    var dob = document.getElementById("dob");


      var table = document.getElementById("myTableData");
   
      var rowCount = table.rows.length;
      var row = table.insertRow(rowCount);
   
      row.insertCell(0).innerHTML= '<input type="reset" class="reset" value = "Delete" onClick="deleteRow(this)">';
      row.insertCell(1).innerHTML= userid.value;
      row.insertCell(2).innerHTML= email.value;
      row.insertCell(3).innerHTML= fname.value;
      row.insertCell(4).innerHTML= lname.value;
      row.insertCell(5).innerHTML= mobile.value;
      row.insertCell(6).innerHTML= address.value;
      row.insertCell(7).innerHTML= dob.value;

  }
  
  
  /* Function to delete a row of responses */
  function deleteRow(obj) {
        
        var index = obj.parentNode.parentNode.rowIndex;
        var table = document.getElementById("myTableData");
        table.deleteRow(index);
        
    }

