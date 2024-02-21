Feature: Add to Cart
@tag3
Scenario Outline: Adding Item to the Shopping Cart and Checkout
    Given the user is on the animal details page using "<browser>"
    When the user clicks on the "Add to Cart" button
    Then the item should be added to the shopping cart
    And proceed to checkout successfully

Examples: 
      | browser |
      | chrome  |
      | firefox |
     