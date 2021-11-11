<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emirates Project</title>
    </head>
    <body>
        <h1>Update Last and First Names</h1>
        <form id="user_form" action="#" method="post">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" placeholder="Enter Username" required/>
            
            <br/>
            <br/>
            
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter Password" required/>
            
            <br/>
            <br/>
            
            <label for="last_name">New Last Name</label>
            <input type="text" id="last_name" name="last_name" placeholder="Enter Last Name" required/>
            &nbsp;
            <label for="first_name">New First Name</label>
            <input type="text" id="first_name" name="first_name" placeholder="Enter First Name" required/>
            
            <br />
            <br />
            <input type="submit" value="Update" onclick="submitform('update')"/>
            &nbsp;
            <input type="submit" value="Reset" onclick="submitform('reset')"/>
        </form>
        
        <script>
            var formobj = document.getElementById("user_form");
            
            function submitform(submit_type){
                event.preventDefault();
                // define the action
                formobj.action = submit_type === "update" ? "update_servlet" : "reset_servlet";
                // submit the form
                formobj.submit();
            }
        </script>
    </body>
</html>
