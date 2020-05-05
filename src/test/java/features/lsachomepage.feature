Feature: Verify search feature on home page

Scenario: Verify search is clickable

Given user is on home page
And user can see search on home page
When user clicks on search
Then search screen should be presented to user

Scenario Outline: Verify search result

Given user is on search screen
And user types "<search_text>"
When user clicks on search button
Then all results matching "<search_text>" should be displayed

Examples:
   |search_text|
   |prepTest   |
