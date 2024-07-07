package Pages;

import config.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutComplete extends BaseTest {
    AndroidDriver driver;
    WebDriverWait wait;

    public CheckoutComplete(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    //LOCATOR
    By titlePage = By.xpath("//*[@text='CHECKOUT: COMPLETE!']");
    By completeLogo = By.xpath("//*[@content-desc='test-CHECKOUT: COMPLETE!']/android.view.ViewGroup/android.widget.ImageView");
    By completeText = By.xpath("//*[@text='THANK YOU FOR YOU ORDER']");
    By descCompleteText = By.xpath("//*[@text='Your order has been dispatched, and will arrive just as fast as the pony can get there!']");
    By backHomeButton = AppiumBy.accessibilityId("test-BACK HOME");

    //ACTION
    public void validateOnCheckoutComplete(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(titlePage)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeLogo)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeText)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(descCompleteText)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(backHomeButton)).isDisplayed();
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titlePage)).getText();
    }

    public void completeLogoIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeLogo)).isDisplayed();
    }

    public String getCompleteText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(completeText)).getText();
    }

    public String getDescCompleteText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descCompleteText)).getText();
    }

    public void backHomeButtonIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(backHomeButton)).isDisplayed();
    }

}
