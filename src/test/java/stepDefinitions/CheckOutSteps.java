package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageObjects.AddToCartPage;
import pageObjects.CheckOutPage;

public class CheckOutSteps {

    CheckOutPage checkOut = new CheckOutPage();
    AddToCartPage addToCartPage = new AddToCartPage();

    @When("I click on the Add to Cart button")
    public void i_click_on_the_add_to_cart_button() {
        addToCartPage.clickFirstAddToCartButton();
    }

    @When("I click on the Checkout button")
    public void i_click_on_the_checkout_button() {
        checkOut.clickCheckoutButton();
    }

    @When("I click on the Continue button")
    public void i_click_on_the_continue_button() {
        checkOut.clickContinueButton();
    }

    @When("I click on the Finish button")
    public void i_click_on_the_finish_button() {
        checkOut.clickFinishButton();
    }

    @When("I navigate to the shopping cart page")
    public void i_navigate_to_the_shopping_cart_page() {
        checkOut.navigateToCart();
    }

    @When("I enter valid shipping details with First Name {string}, Last Name {string}, and Postal Code {string}")
    public void i_enter_valid_shipping_details(String firstName, String lastName, String postalCode) {
        checkOut.enterShippingDetails(firstName, lastName, postalCode);
    }

    @Then("the order should be successfully placed with confirmation message {string}")
    public void the_order_should_be_successfully_placed_with_confirmation_message(String expectedMessage) {
        String actualMessage = checkOut.getCompleteHeaderMessage();
        Assertions.assertEquals(expectedMessage, actualMessage, "Checkout confirmation message mismatch!");
    }
}