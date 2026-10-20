package stepDefinitions.common;

import io.cucumber.java.en.Given;
import pageObjects.LoginPage;

import static utils.base.pro;

public class CommonLoginSteps {
    LoginPage page = new LoginPage();

    @Given("User is on dashboard")
    public void User_is_on_dashboard() {
        String user = pro.getProperty("valid_user");
        String pass = pro.getProperty("valid_pass");
        String result = pro.getProperty("valid_result");
        page.userEntersURL();
        page.enterUsername(user);
        page.enterPassword(pass);
        page.clickLoginButton();
        page.validateText(result);
    }
}

