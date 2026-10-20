package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class base {
    public static Properties pro;
    public static long timeout;
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config/env.properties");
            pro = new Properties();
            pro.load(file);
            timeout = Long.parseLong(pro.getProperty("timeout"));
        } catch (Exception e) {
            throw new RuntimeException("CRITICAL: env.properties not found! Check src/test/resources/config/");
        }
    }

    @Before
    public void setUp() {
        String browserName = pro.getProperty("browser", "Chrome");
        boolean isHeadless = Boolean.parseBoolean(pro.getProperty("headless", "false"));

        WebDriver driverInstance = null;

        if (browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions chOption = new ChromeOptions();
            chOption.addArguments("--incognito");
            if (isHeadless) {
                chOption.addArguments("--headless=new");
                chOption.addArguments("--window-size=1920,1080");
            }
            driverInstance = new ChromeDriver(chOption);

        } else if (browserName.equalsIgnoreCase("Firefox")) {
            FirefoxOptions ffOption = new FirefoxOptions();
            ffOption.addArguments("-private");
            if (isHeadless) {
                ffOption.addArguments("-headless");
            }
            driverInstance = new FirefoxDriver(ffOption);

        } else {
            throw new RuntimeException("CRITICAL: Unsupported browser specified in env.properties: " + browserName);
        }

        // Set the thread-local driver instance
        threadLocalDriver.set(driverInstance);

        String appUrl = pro.getProperty("url", "https://www.saucedemo.com/");
        getDriver().get(appUrl);
        getDriver().manage().window().maximize();

        // Optional navigation history actions
        getDriver().navigate().refresh();
        getDriver().navigate().back();
        getDriver().navigate().forward();

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    // --- Thread-Safe Driver Getter ---
    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    // --- Utility Methods ---

    public void SelectByValue(WebElement ele, String value) {
        new Select(ele).selectByValue(value);
    }

    public void SelectByVisibleText(WebElement ele, String text) {
        new Select(ele).selectByVisibleText(text);
    }

    public void ClearAndEnter(By locator, String text) {
        WebElement element = WaitForExpectedElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void ClickOnElement(By locator) {
        WaitForExpectedElement(locator).click();
    }

    public void BootStrapDropDown(List<WebElement> dropDownList, String text) {
        for (WebElement w : dropDownList) {
            if (w.getText().equals(text)) {
                w.click();
                break;
            }
        }
    }

    public void WindowHandleById() {
        String parentId = getDriver().getWindowHandle();
        Set<String> allWindows = getDriver().getWindowHandles();
        for (String s : allWindows) {
            if (!parentId.equals(s)) getDriver().switchTo().window(s);
        }
    }

    public WebElement WaitForExpectedElement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void javascriptExecutorElement(WebElement ele) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", ele);
    }

    public void javaScriptExecutorByLocator(By locator){
        WebElement ele = WaitForExpectedElement(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", ele);
    }

    public void javaScriptExecutorScrollIntoView(WebElement ele) {
        JavascriptExecutor hs = (JavascriptExecutor) getDriver();
        hs.executeScript("arguments[0].scrollIntoView(true);", ele);
    }

    public void validateText(By locator, String expectedText) {
        String actualText = WaitForExpectedElement(locator).getText();
        org.junit.jupiter.api.Assertions.assertEquals(expectedText, actualText);
    }

    public void clickOnCheckBox(List<WebElement> allCheckBoxes, String Id, String value1, String value2) {
        for (WebElement w : allCheckBoxes) {
            String value = w.getDomAttribute(Id);
            if (value1.equals(value) || value2.equals(value)) {
                if (!w.isSelected()) {
                    w.click();
                }
            }
        }
    }

    public void accept() {
        getDriver().switchTo().alert().accept();
    }

    public void dismiss() {
        getDriver().switchTo().alert().dismiss();
    }

    public String getText() {
        return getDriver().switchTo().alert().getText();
    }

    public void sendKeys(String text) {
        getDriver().switchTo().alert().sendKeys(text);
    }

    public void frameSwitching(String id) {
        getDriver().switchTo().frame(id);
    }

    public void switchBackFromFrame() {
        getDriver().switchTo().defaultContent();
    }

    public void actionClass() {
        Actions d = new Actions(getDriver());
        d.sendKeys(Keys.ENTER).build().perform();
    }

    public void AuthenticationsPopUp() {
        getDriver().get("https://username:password@www.abc.com");
    }

    public void validateErrorHeading(By locator) {
        WaitForExpectedElement(locator).isDisplayed();
    }

    @After
    public void TearDown(Scenario status) {
        if (status.isFailed()) {
            try {
                TakesScreenshot as = (TakesScreenshot) getDriver();
                File src = as.getScreenshotAs(OutputType.FILE);
                File screenshotDir = new File(System.getProperty("user.dir") + "/ScreenShots/");

                if (!screenshotDir.exists()) screenshotDir.mkdirs();

                String name = status.getName().replaceAll(" ", "_") + "_" + System.currentTimeMillis();
                File targetFile = new File(screenshotDir, name + ".png");
                FileHandler.copy(src, targetFile);
                System.out.println("Screenshot captured: " + targetFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        }

        if (getDriver() != null) {
            getDriver().quit();
            threadLocalDriver.remove();
        }
    }
}