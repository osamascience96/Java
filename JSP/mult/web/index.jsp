<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html><head><meta content="text/html; charset=ISO-8859-1" http-equiv="content-type"><title>Home</title></head><body>
<table style="text-align: left; width: 1626px; height: 419px;" border="0" cellpadding="2" cellspacing="2">
  <%
      String responseS = request.getParameter("response");
      int data = responseS != null && responseS.compareTo("success_reterived") == 0 ? Integer.parseInt(request.getParameter("data")) : 0;
  %>
  <tbody>
    <tr>
      <td style="vertical-align: top; width: 229px;"><br>
      </td>
      <td style="vertical-align: top; width: 311px;"><br>
      </td>
      <td style="vertical-align: top; width: 419px;"><br>
      </td>
      <td style="vertical-align: top; width: 269px;"><br>
      </td>
      <td style="vertical-align: top; width: 355px;"><br>
      </td>
    </tr>
    <tr>
      <td style="vertical-align: top; width: 229px; height: 56px;"><br>
      </td>
      <td colspan="3" rowspan="1" style="vertical-align: top; text-align: center; font-family: Arial; width: 269px; height: 56px;"><big style="color: rgb(0, 0, 153);"><big><big>Multiply 2 Numbers by Cobol Program running in TK4-MVS</big></big></big><br>
      </td>
      <td style="vertical-align: top; width: 355px; height: 56px;"><br>
      </td>
    </tr>
    <tr>
      <td style="vertical-align: top; width: 229px; height: 60px;"><br>
      </td>
      <td style="vertical-align: top; width: 311px; text-align: center; height: 60px;">
        <big style="text-decoration: underline;">
            <big>
                <big>
                    <span style="font-family: Arial; color: rgb(153, 0, 0);">First Number</span>
                </big>
            </big>
        </big>
        <br>
      </td>
      <td style="vertical-align: top; width: 419px; text-align: center; height: 60px;"><big style="text-decoration: underline;"><big><big><span style="font-family: Arial; color: rgb(153, 0, 0);">Second Number</span></big></big></big><br>
      </td>
      <td style="vertical-align: top; width: 269px; text-align: center; height: 60px;"><big style="text-decoration: underline;"><big><big><span style="font-family: Arial; color: rgb(153, 0, 0);">Product </span></big></big></big><br>
      </td>
      <td style="vertical-align: top; width: 355px; height: 60px;"><br>
      </td>
    </tr>
    <tr>
      <td style="vertical-align: top; width: 229px; height: 67px;"><br>
      </td>
      <td style="vertical-align: top; width: 311px; height: 67px; text-align: center;"><big><big><big><big><big><span style="font-family: Arial;"><input type="number" id="fn" placeholder="Enter First Number" /></span></big></big></big></big></big><br>
      </td>
      <td style="vertical-align: top; width: 419px; height: 67px; text-align: center;"><big><big style="font-family: Arial;"><big><big><big><input type="number" id="ln" placeholder="Enter the Second Number" /></big></big></big></big></big><br>
      </td>
      <td style="vertical-align: top; width: 269px; height: 67px; text-align: center;"><big><big><big><big><big>
            <span style="font-family: Arial;">                
                <%=data%>
            </span>
        </big></big></big></big></big><br>
      </td>
      <td style="vertical-align: top; width: 355px; height: 67px;"><br>
      </td>
    </tr>
    <tr>
      <td style="vertical-align: top; width: 229px; height: 128px;"><br>
      </td>
      <td style="vertical-align: top; width: 311px; height: 128px;"><span style="font-family: Arial;"><span style="color: rgb(153, 0, 0); font-weight: bold;">1. Enter first number.</span><br style="color: rgb(153, 0, 0); font-weight: bold;">
      <span style="color: rgb(153, 0, 0); font-weight: bold;">2. Enter second number.</span><br style="color: rgb(153, 0, 0); font-weight: bold;">
      <span style="color: rgb(153, 0, 0); font-weight: bold;">3. Press the multiply sign.</span><br style="color: rgb(153, 0, 0); font-weight: bold;">
      <span style="color: rgb(153, 0, 0); font-weight: bold;">4. Press the equals sign.<br>
5. The product should appear.<br>
      </span></span></td>
      <td style="vertical-align: top; width: 419px; height: 128px; text-align: center;">
          <form id="inputservlet" action="input_servlet" method="post">
              <input type="hidden" id="mult_fn" name="fn">
              <input type="hidden" id="mult_ln" name="ln">
              <img style="width: 109px; height: 109px;" alt="multi-button" src="img/mult.jpg" onclick="submit_input_form()">
          </form>
        <br>
      </td>
      <td style="vertical-align: top; width: 269px; height: 128px; text-align: center;"><a href="output_servlet"><img style="width: 157px; height: 122px;" alt="equals" src="img/equals.jpg"></a><br>
      </td>
      <td style="vertical-align: top; width: 355px; height: 128px;"><br>
      </td>
    </tr>
  </tbody>
</table>

  <br>
  
  <script>
      function submit_input_form(){
        var firstnum = document.getElementById("fn").value;
        var secondnum = document.getElementById("ln").value;
      
        if(firstnum !== "" || secondnum !== ""){
            // set the values to the hidden field
            document.getElementById("mult_fn").value = firstnum;
            document.getElementById("mult_ln").value = secondnum;

            // submit the form
            document.getElementById("inputservlet").submit();
        }
      }
  </script>

</body></html>