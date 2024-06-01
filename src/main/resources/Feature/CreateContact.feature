Feature: FreeCRM application Test 

Scenario: Create Conatct Test  
Given Launch the browser and open url
Then user is on login page 
When user enter the username "rvkadam25@gmail.com" and password "Ravikant@25"
And Click on login button 
Then user should on the homepage 
When user move and click on the contact tab 
Then user is on contact page 
Then Click on Create button 
Then Enter the following details and click on save Button 
|Prmila|Ajinky|Sutar|pramila1235@gmail.com|
