package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageObjects.AddToCartPage;

public class AddToCartSteps {

    AddToCartPage productsPage = new AddToCartPage();

    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonText) {
        if (buttonText.equals("Add to Cart")) {
            productsPage.clickFirstAddToCartButton();
        }
    }

    @Then("the product should be added to the cart")
    public void the_product_should_be_added_to_cart() {
        boolean isDisplayed = productsPage.isFirstRemoveButtonDisplayed();
        Assertions.assertTrue(isDisplayed, "Product was not added (Remove button not visible)");
    }

    @Then("the cart count should increase by {int}")
    public void the_cart_count_should_increase_by(Integer expectedCount) {
        String actualCount = productsPage.getCartBadgeText();
        Assertions.assertEquals(String.valueOf(expectedCount), actualCount, "Cart count mismatch!");
    }

    @When("I click on the {string} button for multiple products")
    public void i_click_on_the_add_to_cart_button_for_multiple_products(String buttonText) {
        if (buttonText.equals("Add to Cart")) {
            productsPage.clickMultipleAddToCartButtons();
        }
    }

    @Then("all selected products should be added to the cart")
    public void all_selected_products_should_be_added_to_the_cart() {
        boolean areMultipleDisplayed = productsPage.areMultipleRemoveButtonsDisplayed();
        Assertions.assertTrue(areMultipleDisplayed, "One or more product remove buttons are missing");
    }

    @Then("the cart count should reflect the total number of products added")
    public void the_cart_count_should_reflect_the_total_number_of_products_added() {
        String actualCount = productsPage.getCartBadgeText();
        Assertions.assertEquals("2", actualCount, "Cart count does not match the total added products!");
    }

    @When("I click on the {string} button for a product")
    public void i_click_on_the_button_for_a_product(String buttonText) {
        if (buttonText.equals("Remove")) {
            productsPage.clickRemoveButton();
        }
    }

    @When("I click on the {string} button for the product")
    public void i_click_on_the_button_for_the_product(String buttonName) {
        if (buttonName.equals("Remove")) {
            productsPage.clickRemoveButton();
        }
    }

    @Then("the product should be removed from the cart")
    public void the_product_should_be_removed_from_the_cart() {
        boolean isBadgeVisible = productsPage.isCartBadgeDisplayed();
        Assertions.assertFalse(isBadgeVisible, "Product was not removed from the cart (cart badge is still present)");
    }

    @Then("the cart count should decrease accordingly")
    public void the_cart_count_should_decrease_accordingly() {
        boolean isBadgeVisible = productsPage.isCartBadgeDisplayed();
        Assertions.assertFalse(isBadgeVisible, "Cart count did not decrease to zero!");
    }
}