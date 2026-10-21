@Checkout
Feature: Complete Checkout Flow

  Background:
    Given User is on dashboard
    When I click on the Add to Cart button
    Then the product should be added to the cart

  @CheckoutFlow
  Scenario Outline: Successfully complete checkout with various shipping details
    When I navigate to the shopping cart page
    And I click on the Checkout button
    And I enter valid shipping details with First Name "<FirstName>", Last Name "<LastName>", and Postal Code "<PostalCode>"
    And I click on the Continue button
    And I click on the Finish button
    Then the order should be successfully placed with confirmation message "<ExpectedMessage>"

    Examples:
      | FirstName | LastName | PostalCode | ExpectedMessage           |
      | Sohan     | Singh    | 110001     | Thank you for your order! |
      | Ram       | Ratan    | 201304     | Thank you for your order! |
      | Simmi     | Kumari   | 201310     | Thank you for your order! |