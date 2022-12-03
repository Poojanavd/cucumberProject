Feature: Top Deal page functionality

Background:
Given user is on Greenkart landing page
And Navigated to Top deals page


Scenario: verify the page size dropdown
When user clicks on Page size dropdown
Then he is able to see options
	|5|
	|10|
	|20|
	
Scenario: verify products displayed in table are equal to or less than the pagesize selected
When user selects "5" from dropdown
Then verify user is able to see equal to or less than "5" products in the table
When user selects "10" from dropdown
Then verify user is able to see equal to or less than "10" products in the table
When user selects "20" from dropdown
Then verify user is able to see equal to or less than "20" products in the table