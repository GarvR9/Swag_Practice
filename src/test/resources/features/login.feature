@Login
Feature: Swag Labs Login Functionality
  As a user of SauceDemo
  I want to log into the application



  Scenario Outline: Verify login behavior with different credential combinations
    Given the user enters URL
    When the user enters username "<username>"
    And the user enters password "<password>"
    And the user clicks on the login button
    Then the user should see the expected result "<message>"

    Examples:
      | username                | password     | message                                                                   |
      | standard_user           | secret_sauce | Swag Labs                                                                 |
      | locked_out_user         | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | problem_user            | secret_sauce | Swag Labs                                                                 |
      | performance_glitch_user | secret_sauce | Swag Labs                                                                 |
      | invalid_user            | wrong_pass   | Epic sadface: Username and password do not match any user in this service |