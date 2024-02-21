Feature: Valid User Registration and Login
 @tag1
Scenario Outline: User Registration
    Given I am on the registration page using "<browser>"
    When the user is on the registration page
    And the user enters valid registration details
    And save account information 
    Then the user should be successfully registered and logged in
     
    Examples: 
      | browser |
      | chrome |
      | firefox|
      
     
      