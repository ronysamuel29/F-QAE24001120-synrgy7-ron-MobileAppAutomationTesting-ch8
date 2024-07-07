package Pages;

import config.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BaseTest{
    AndroidDriver driver;
    WebDriverWait wait;

    public CartPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //locator
    //your cart
    By cartTitle = By.xpath("//*[@text='YOUR CART']");
    By checkoutButton = By.xpath("//*[@content-desc='test-CHECKOUT']");
    By contShoppingButton = By.xpath("//*[@content-desc='test-CONTINUE SHOPPING']");

    //cart information

    //ACTION
    public void scrollCartPage(String text) {
        // Scroll until the checkout button is visible
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))",text)));
    }

    public void validateOnYourCartPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(contShoppingButton)).isDisplayed();
    }
    public String setCartTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTitle));
        return driver.findElement(cartTitle).getText();
    }

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

}
