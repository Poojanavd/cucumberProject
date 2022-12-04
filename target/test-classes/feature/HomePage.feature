Feature: Homepage functionality

Background:
Given user is on Greenkart landing page

	 Scenario: verify product images are not broken on the hompage
 	Then product images are not broken
 	
 	Scenario Outline: search functionality
 	When user enter <productName> in the search bar
 	Then <productName> is displayed in the search result
 	Examples:
 |productName|
 |Cucumber|
 |Brocolli|
 	

 
