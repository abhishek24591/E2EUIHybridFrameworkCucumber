Feature: Accounts Page feature 
  I want to use this template for my feature file

Background:
  Given user has already logged in to application  
    | username | password |
    | dec2020secondbatch@gmail.com | Selenium@12345 |
   
  @tag1
  Scenario: Accounts Page title 	
    Given user is on accounts page 
    When user gets title of the page 
    Then page title should be "My account - My Store"

  @tag2
  Scenario Outline: Accounts section count 
    Given user is on accounts page
    Then user gets accounts section 
     | Order history and details | 
     | My credit slips | 
     | My addresses |
     | My personal information |
     | My wishlists | 
    And accounts section count should be 5 	  
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step
    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
