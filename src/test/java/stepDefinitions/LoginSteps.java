package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps {
    LoginPage page = new LoginPage();

    @Given("the user enters URL")
    public void the_user_enters_url() {
        page.userEntersURL();

    }

    @When("the user enters username {string}")
    public void the_user_enters_username(String username) {
        page.enterUsername(username);
    }

    @And("the user enters password {string}")
    public void the_user_enters_password(String password) {

        page.enterPassword(password);
    }

    @And("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {

        page.clickLoginButton();
    }

    @Then("the user should see the expected result {string}")
    public void the_user_should_see_the_expected_result(String message) {

        page.validateText(message);
    }
}
