package pageObjects;

import org.openqa.selenium.By;
import utils.base;


public class LoginPage extends base {
    private final By usernameField = By.xpath("//input[@id='user-name']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");
    private final By expectedText = By.xpath("//div[@class='app_logo' and normalize-space()='Swag Labs']");


    public void userEntersURL() {
        try {
            String appUrl = pro.getProperty("url");
            ;
            getDriver().get(appUrl);
            System.out.println("✅ Navigated to URL: " + appUrl);
        } catch (Exception e) {
            System.err.println("❌ Failed to navigate to URL: " + e.getMessage());
            throw new RuntimeException("Failed to navigate to login URL", e);
        }
    }

    public void enterUsername(String username) {
        ClearAndEnter(usernameField, username);

    }

    public void enterPassword(String password) {

        ClearAndEnter(passwordField, password);
    }

    public void clickLoginButton() {

        ClickOnElement(loginButton);
    }

    public void validateText(String message) {
        validateText(expectedText, message);


    }
}

