Feature: Login page feature
  
  Scenario: Login page title
    Given User is on login page 
    When user gets title of the page 
    Then page title sbould be "Login - My Store"
    
  Scenario: Forgot password link  
    Given User is on login page 
    Then Forgot password link should be displayed 
   
  
  Scenario Outline: Login with correct credentials 
    Given User is on login page
    When user enters username "naveenanimation20@gmail.com"
    And user enters password "Selenium12345"
    And user clicks on login button
    Then user gets title of the page
    And page title should be "My Account"
   Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
