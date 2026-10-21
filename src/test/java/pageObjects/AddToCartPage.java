package pageObjects;

import org.openqa.selenium.By;
import utils.base;

public class AddToCartPage extends base {

    private By firstAddToCartButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private By secondAddToCartButton = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    private By firstRemoveButton = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    private By secondRemoveButton = By.xpath("//button[@id='remove-sauce-labs-bike-light']");
    private By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");
    private By removeButtonInCart = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    private By cartBadge1 = By.xpath("//span[@class='shopping_cart_badge']");

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

    public void clickRemoveButton() {
        ClickOnElement(removeButtonInCart);
    }

    public boolean isCartBadgeDisplayed() {
        try {

            return WaitForExpectedElement(cartBadge1).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}