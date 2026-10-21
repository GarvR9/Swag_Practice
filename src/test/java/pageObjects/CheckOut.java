package pageObjects;

import org.openqa.selenium.By;
import utils.base;

public class CheckOut extends base {

    private By cartLink = By.className("shopping_cart_link");
    private By checkoutButton = By.id("checkout");
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By completeHeader = By.className("complete-header");

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
}