function formValidation()
{
    
    var uid = document.login-form.userid;
    var pid = document.login-form.passid;

    if(userid_validation(uid))
    {
        if(passid_validation(passid))
            {

                alert("Log-in is successful!");
            }

            
     }

     return false;
}

/* Function for validating username */
function userid_validation(uid)
{
    var uid_len = uid.value.length;

    if (uid_len == 0)
    {
    alert("User Id should not be empty");
    uid.focus();
    return false;
    }
    return true;
}


/* Function for validating password */
function passid_validation(passid)
{
var passid_len = passid.value.length;
if (passid_len == 0)
{
alert("Password should not be empty");
passid.focus();
return false;
}
return true;
}



