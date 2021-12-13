# Anatomy of the Structure of the Selected Item from the Drpdown
  You can see the line number 40 in main.java
  
  1. The first method calls the choicebox that selects the current selected model of the choicebox dropdown
     Note: Keep in mind that there are different kinds of selection models for everykind of dropdown where we can
           can select more than one item
  2. The second method calls the selecte item property that selects the properties of the currently selected itme
  3. The 3rd method calls the addListener that listen to the selection event of the dropdown when the option is 
     selected and on selection of any item the callback is passed
  
     Note: The Callback has 3 params
           1) Observation Object
           2) OldValue: String
           3) NewValue: String
     When it is called, it calls the ShowChoiceboxValue function that displays both the old and the new value

  Please refer more to the documentation to get more and accurate information. Please do keep in mind that this
  is taken from the newboston youtube channel of JavaFX
