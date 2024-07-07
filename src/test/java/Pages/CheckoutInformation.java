package Pages;

import config.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutInformation extends BaseTest {
    AndroidDriver driver;
    WebDriverWait wait;

    public CheckoutInformation(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //LOCATOR
    By titlePage = By.xpath("//*[@text='CHECKOUT: INFORMATION']");
    By firstNameField = AppiumBy.accessibilityId("test-First Name");
    By lastNameField = AppiumBy.accessibilityId("test-Last Name");
    By postalCodeField = AppiumBy.accessibilityId("test-Zip/Postal Code");
    By cancelButton = AppiumBy.accessibilityId("test-CANCEL");
    By continueButton = AppiumBy.accessibilityId("test-CONTINUE");

    //ACTION
    public void validationOnCheckoutInformation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(titlePage)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelButton)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).isDisplayed();
    }
    public String getTitlePage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titlePage)).getText();
    }
    public void inputFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode){
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }
    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }


}
