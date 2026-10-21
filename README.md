# Swag Labs BDD Automation Framework

Hey there! This is a test automation framework built for SauceDemo (Swag Labs) using Java, Selenium WebDriver, Cucumber BDD, and JUnit 5.

# What's under the hood
* Language: Java (OpenJDK 24)
* Automation: Selenium WebDriver 4
* BDD: Cucumber 7 (Java)
* Runner: JUnit Platform Suite (JUnit 5)
* Build Tool: Maven

||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

# Project Layout

Here is how everything is organized inside the project:

* src/test/java/runner/
  * TestRunner.java - JUnit 5 suite setup
* src/test/java/stepDefinitions/
  * CommonLoginSteps.java - Shared login stuff
  * CartSteps.java - Shopping cart steps
  * CheckoutSteps.java - Order checkout flow steps
* src/test/java/utils/
  * ConfigReader.java - Handles property files
* src/test/resources/features/
  * login.feature - Login scenarios (@Login)
  * addToCart.feature - Cart scenarios (@Cart)
  * checkout.feature - Checkout scenarios (@Checkout)
* src/test/resources/
  * env.properties - Environment configurations

||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

# How to Run the Tests

1. Tag Filtering
The tests run dynamically using JUnit 5 config parameters inside TestRunner.java. You can mix and match modules like this:

java
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@Login or @Cart or @Checkout")

2. Execution
IntelliJ IDEA: Just right-click TestRunner.java and hit Run 'TestRunner'.
Terminal/Command Line:
Bash
mvn clean test

Reports
HTML reports are generated automatically right after execution at:Reports/cucumber-report.html


Author/-
Gaurav Rawat
