package Pages;

import config.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseTest {
    AndroidDriver driver;
    WebDriverWait wait;


    //locator
    By usernameField = AppiumBy.accessibilityId("test-Username");
    By passwordField = AppiumBy.accessibilityId("test-Password");
    By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    By errorMsg = By.xpath("//*[contains(text(), 'password do not match')]");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //action
    public void validateOnLoginPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
    }

    public void inputUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys();
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String displayedErrorMsg(){
       return driver.findElement(errorMsg).getText();
    }

    public void stayInTheLoginPage() {
        driver.findElement(loginButton).isDisplayed();
    }
}
