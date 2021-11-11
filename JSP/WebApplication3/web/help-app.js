var myWindow;


        function validateForm() 
        {
            if (isEmpty(document.getElementById('data_2').value.trim()))
             {
                 alert('Reported by is required!');
                    return false;
            }
            if (isEmpty(document.getElementById('data_6').value.trim())) 
            {
                 alert('Summary is required!');
                 return false;
            }
        return true;
        }


        function isEmpty(str) 
        { 
            return (str.length === 0 || !str.trim()); 
        }


      


        function closeWin() 
        {
            window.opener = self;
          window.close();
        }