package Pages;

import config.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverview extends BaseTest {
    AndroidDriver driver;
    WebDriverWait wait;

    public CheckoutOverview(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //LOCATOR
    By titlePage = By.xpath("//*[@text='CHECKOUT: OVERVIEW']");
    By paymentInformation = By.xpath("//*[@text='SauceCard #31337']");
    By shippingInformation = By.xpath("//*[@text='FREE PONY EXPRESS DELIVERY!']");
    By itemTotal = By.xpath("//*[@text='Item total: $39.98']");
    By cancelButton = AppiumBy.accessibilityId("test-CANCEL");
    By finishButton = AppiumBy.accessibilityId("test-FINISH");

    //ACTION

    public void scrollCheckoutOverviewPage(String text) {
        driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        String.format("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))",text)));

    }
    public void validationOnCheckoutOverview(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(titlePage)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInformation)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingInformation)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemTotal)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelButton)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton)).isDisplayed();
    }

    public String getTitlePage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titlePage)).getText();
    }

    public void paymentInfoValueIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInformation)).isDisplayed();
    }

    public void shippingInformationValueIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingInformation)).isDisplayed();
    }

    public void clickCancelButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelButton)).click();
    }

    public void clickFinishButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton)).click();
    }
}
