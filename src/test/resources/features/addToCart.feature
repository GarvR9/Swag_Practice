@Cart
Feature: Add Products to Shopping Cart

  Background:
    Given User is on dashboard

  @Cart
  Scenario Outline: Add products to the cart and verify badge count
    When I click on the "<ButtonText>" button for multiple products
    Then all selected products should be added to the cart
    And the cart count should increase by <ExpectedCount>

    Examples:
      | ButtonText  | ExpectedCount |
      | Add to Cart | 2             |

  @Cart
  Scenario: Add multiple products to the cart
    When I click on the "Add to Cart" button for multiple products
    Then all selected products should be added to the cart
    And the cart count should reflect the total number of products added

  @CartManagement
  Scenario: Remove a product from the shopping cart
    When I click on the "Add to Cart" button
    And I navigate to the shopping cart page
    And I click on the "Remove" button for the product
    Then the product should be removed from the cart
    And the cart count should decrease accordingly