Feature: Login Functionality

Scenario Outline: Login with valid credentials
Given User should navigate the login page on home Page
When User has enter valid username <username> in the login field
And User has enter valid password <password> in the password field
And User has click on login button
Then User should logged in successfully in the app
And User should logout the app
Examples:
|username                       |password      |
|kvivekanand965@gmail.com       |admin         |

Scenario Outline: Login with invalid username
Given User should navigate the login page on home Page
When User has enter invalid username <username> in the login field
And User has enter valid password <password> in the password field
And User has click on login button
Then User should get warning message to entered credentials are missmatched
Examples:
|username                       |password      |
|kvivekanand5@gmail.com         |admin         |

Scenario: Login with invalid password
Given User should navigate the login page on home Page
When User has enters valid username "kvivekanand965@gmail.com" in the login field
And User has enters invalid password "admi" in the password field
And User has click on login button
Then User should get warning message to entered credentials are missmatched

Scenario: Login with invalid username and password
Given User should navigate the login page on home Page
When User has enters invalid username "kvivekanand965@gmail.com" in the login field
And User has enters invalid password "admi" in the password field
And User has click on login button
Then User should get warning message to entered credentials are missmatched

Scenario: User Try to Login without entering username and password
Given User should navigate the login page on home Page
When User has dont enters username " " in the login field
And User has dont enters password " " in the password field
And User has click on login button
Then User should get warning message to entered credentials are missmatched
