Feature: FreeCRM application Test 

Scenario: Create loginpage Test with valid credentials 
Given Launch the browser and open url
Then user is on login page 
When user enter the username "rvkadam25@gmail.com" and password "Ravikant@25"
And Click on login button 
Then user should on the homepage 


Scenario Outline: Login Test with invalid creadentials
Given Launch the browser and open url
Then user is on login page 
When user enter the username "<username>" and password "<Password>"
And Click on login button 
Then user should on the homepage 


Examples:

|username|Password|
|rvkadam25@gmail.com|Ravikant123|
|Vishwatech@gmail.com|Ravikant@25|




