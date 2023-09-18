Feature: Search Functionality

Scenario: User searches the valid product
Given user opens the application
When User has enters the valid products "HP" in the search box field
And User has click on search button
Then User should get the searched product that is displayed in the search result

Scenario: User searches the invalid product
Given user opens the application
When User has enters the invalid products "Honda" in the search box field
And User has click on search button
Then User should not get the searched product in the search result

Scenario: User searches any product
Given user opens the application
When User has nothing enters in the search box field
And User has click on search button
Then User should not get the searched product in the search result