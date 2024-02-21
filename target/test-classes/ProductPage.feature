Feature: Valid Product Search
@tag2
Scenario Outline: Product Search and View
    Given the user is logged in using "<browser>"
    When the user searches for an animal
    And selects a product from the search results
    And choose an animal 
    Then the user should be able to view the animal details
    
    Examples: 
      | browser |
      | chrome  |
      | firefox |


     