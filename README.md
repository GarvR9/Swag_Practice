"A personal portfolio project exploring modular BDD test automation with Selenium, Cucumber, and JUnit 5."

Tech Stack
Language: Java (OpenJDK 24)

Automation: Selenium WebDriver 4

BDD: Cucumber 7 (Java)

Runner: JUnit Platform Suite (JUnit 5)

Build Tool: Maven

Project Structure
Plaintext
src/
└── test/
    ├── java/                               
    │   ├── runner/                        
    │   │   └── TestRunner.java             # JUnit 5 suite configuration
    │   ├── stepDefinitions/               
    │   │   ├── CommonLoginSteps.java       # Shared login logic
    │   │   └── CartSteps.java              # Shopping cart steps
    │   └── utils/                          
    │       └── ConfigReader.java           # Property management
    │
    └── resources/                          
        ├── features/                       
        │   ├── login.feature               # @Login scenarios
        │   └── addToCart.feature           # @Cart scenarios
        └── env.properties                  # Environment configs
Running the Tests
1. Tag Filtering
Tests are executed dynamically using JUnit 5 configuration parameters in TestRunner.java. You can combine modules using logical operators:

Java
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@Login or @Cart")
2. Execution
IntelliJ IDEA: Right-click TestRunner.java -> Run 'TestRunner'

Command Line:

Bash
mvn clean test
Reports
HTML test execution reports are automatically generated at:
Reports/cucumber-report.html

Author
Gaurav Rawat
