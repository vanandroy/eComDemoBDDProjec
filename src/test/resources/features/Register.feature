Feature: Register Functionality

Scenario: User Create Account in the application with mandatory fields only
Given user navigate to Register Account button
When user has enters the details below
|firstName                        |vivek                |
|lastName                         |kumar                |
|telephone                        |12345678             |
|password                         |admin                |
|cnfPassword                      |admin                |
And user should click on continue button
Then User account should get created successfully

Scenario: User Create Account in the application with all fields 
Given user navigate to Register Account button
When user has enters the details below
|firstName                        |vivek                |
|lastName                         |kumar                |
|telephone                        |12345678             |
|password                         |admin                |
|cnfPassword                      |admin                |
And user should select newsletter
And user should select Privacy Policy
And user should click on continue button
Then User account should get created successfully

Scenario: User Create Duplicate Account in the application 
Given user navigate to Register Account button
When user has enters the details to verify duplicate account below
|firstName                        |vivek                |
|lastName                         |kumar                |
|email                            |kvivekanand965@gmail.com|
|telephone                        |12345678             |
|password                         |admin                |
|cnfPassword                      |admin                |
And user should select newsletter
And user should select Privacy Policy
And user should click on continue button
Then User should get proper warning message about email is already exit

Scenario: User Create Account in the application without filling any details
Given user navigate to Register Account button
When user has not enters any details
And user should click on continue button
Then User should get proper warning message about all mandatory fields

