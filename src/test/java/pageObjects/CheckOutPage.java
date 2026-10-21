package pageObjects;

import org.openqa.selenium.By;
import utils.base;

public class CheckOutPage extends base {

    private By cartLink = By.xpath("//a[@class='shopping_cart_link']");
    private By checkoutButton = By.xpath("//button[@id='checkout']");
    private By firstNameInput = By.xpath("//input[@id='first-name']");
    private By lastNameInput = By.xpath("//input[@id='last-name']");
    private By postalCodeInput = By.xpath("//input[@id='postal-code']");
    private By continueButton = By.xpath("//input[@id='continue']"); // or //button[@id='continue']
    private By finishButton = By.xpath("//button[@id='finish']");
    private By completeHeader = By.xpath("//h2[@class='complete-header']");
    private By errorMessageContainer = By.xpath("//h3[@data-test='error']");

    public void navigateToCart() {
        ClickOnElement(cartLink);
    }

    public void clickCheckoutButton() {
        ClickOnElement(checkoutButton);
    }

    public void enterShippingDetails(String firstName, String lastName, String postalCode) {
        ClearAndEnter(firstNameInput, firstName);
        ClearAndEnter(lastNameInput, lastName);
        ClearAndEnter(postalCodeInput, postalCode);
    }

    public void clickContinueButton() {
        ClickOnElement(continueButton);
    }

    public void clickFinishButton() {
        ClickOnElement(finishButton);
    }

    public String getCompleteHeaderMessage() {
        return WaitForExpectedElement(completeHeader).getText();
    }

    public String getErrorMessage() {
        return WaitForExpectedElement(errorMessageContainer).getText();
    }
}