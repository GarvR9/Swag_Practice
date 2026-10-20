@Cart
Feature: Add Products to Shopping Cart

  Background:
    Given User is on dashboard

  @Cart
  Scenario: Add a single product to the cart
    When I click on the "Add to Cart" button
    Then the product should be added to the cart
    And the cart count should increase by 1

  @Cart
  Scenario: Add multiple products to the cart
    When I click on the "Add to Cart" button for multiple products
    Then all selected products should be added to the cart
    And the cart count should reflect the total number of products added