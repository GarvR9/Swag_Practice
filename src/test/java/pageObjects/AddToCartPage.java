package pageObjects;

import org.openqa.selenium.By;
import utils.base;

public class AddToCartPage extends base {

    private By firstAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By secondAddToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By firstRemoveButton = By.id("remove-sauce-labs-backpack");
    private By secondRemoveButton = By.id("remove-sauce-labs-bike-light");
    private By cartBadge = By.className("shopping_cart_badge");

    public void clickFirstAddToCartButton() {
        ClickOnElement(firstAddToCartButton);
    }

    public boolean isFirstRemoveButtonDisplayed() {
        return WaitForExpectedElement(firstRemoveButton).isDisplayed();
    }

    public String getCartBadgeText() {
        return WaitForExpectedElement(cartBadge).getText();
    }

    public void clickMultipleAddToCartButtons() {
        ClickOnElement(firstAddToCartButton);
        ClickOnElement(secondAddToCartButton);
    }

    public boolean areMultipleRemoveButtonsDisplayed() {
        boolean firstVisible = WaitForExpectedElement(firstRemoveButton).isDisplayed();
        boolean secondVisible = WaitForExpectedElement(secondRemoveButton).isDisplayed();
        return firstVisible && secondVisible;
    }
}