function validateForm() {
  // window.location.href =
  // 'mailto:user@example.com?subject=Subject&body=message%20goes%20here'

  var name = document.forms['purchaseForm']['fname'].value;
  var address = document.forms['purchaseForm']['address'].value;
  var phone = document.forms['purchaseForm']['phone'].value;
  var email = document.forms['purchaseForm']['email'].value;
  var cc = document.forms['purchaseForm']['cc'].value;

  if (
    name === '' ||
    address === '' ||
    phone === '' ||
    email === '' ||
    cc === ''
  ) {
    return alert('All fields must be filled out')
  }

  if (phone.length < 10) {
    return alert('Please enter a valid phone number')
  }

  //REGEX FOUND ON STACKOVERFLOW:
  //https://stackoverflow.com/questions/46155/how-to-validate-an-email-address-in-javascript
  if (
    !email.match(
      /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    )
  ) {
    return alert('Please enter a valid email')
  }
  
  document.getElementById("purchaseForm").submit();
}
