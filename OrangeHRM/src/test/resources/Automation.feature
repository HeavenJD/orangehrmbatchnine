@regressiontest
Feature: validate log in function and verified the total price with shipping in MyStore

Scenario: User able to login with valid credential and able to verify the dress price with shipping cost
Given user open web browser and navigate to MyStore log in screen
Then user Navigate to home Page and verify the Page Title is "MyStore"
And user click the sign in button on right the right
And user enter a valid Email address and password
And user click the sign in button
And user click on the upper left corner dresses and display show five dresses
Then user print all the dress price in decending order
And user select the second dress on the current list
Then user click on the next page to proceed checkout
When user click on the next page to verify the total price with shipping
Then user click on the sign out button and close the window
