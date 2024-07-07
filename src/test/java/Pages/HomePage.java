package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    AndroidDriver driver;
    WebDriverWait wait;

    public HomePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //locator
    By titlePage = By.xpath("//*[contains(@text, 'PRODUCTS')]");

    //sorting element
    By sortButton = AppiumBy.accessibilityId("test-Modal Selector Button");
    By sortingLoHiButton = By.xpath("//*[contains(@text, 'Price (low to high)')]");
    By firstPrice = By.xpath("(//*[@content-desc='test-Price'])[1]");
    By secondPrice = By.xpath("(//*[@content-desc='test-Price'])[2]");

    //cart element
    By cartButton = AppiumBy.accessibilityId("test-Cart");
    By goCart1 = By.xpath("(//*[@content-desc='test-ADD TO CART'])[1]");
    By goCart2 = By.xpath("(//*[@content-desc='test-ADD TO CART'])[2]");
    By countProduct = By.xpath("//*[@content-desc='test-Cart']");


    //ACTION

    public void validateOnHomePage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("test-Cart")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(titlePage)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton)).isDisplayed();
    }

    public String productPageTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(titlePage));
        return driver.findElement(titlePage).getText();
    }

    public void clickSortButton(){
        driver.findElement(sortButton).click();
    }
    public void clickLoHiSorting(){
        driver.findElement(sortingLoHiButton).click();
    }
    public double firstPrice(){
        String firstPriceString = driver.findElement(firstPrice).getText().replace("$", "");
        return Double.parseDouble(firstPriceString);
    }
    public double secondPrice(){
        String secondPriceString = driver.findElement(secondPrice).getText().replace("$", "");
        return Double.parseDouble(secondPriceString);
    }

    public void clickGoCart1(){
        driver.findElement(goCart1).click();
    }
    public void clickGoCart2(){
        driver.findElement(goCart2).click();
    }
    public void clickCartButton(){
        driver.findElement(cartButton).click();
    }
    public String setCountProduct(){
        return driver.findElement(countProduct).getText();
    }

}
