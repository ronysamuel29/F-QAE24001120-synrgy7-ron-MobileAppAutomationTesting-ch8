package stepDefenitions;

import Pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SortingSteps {
    AndroidDriver driver;
    HomePage homePage;

    public SortingSteps(AndroidDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
    }
    @Given("User click sorting items button")
    public void userClickSortingItemsButton() {
        homePage.clickSortButton();
    }

    @When("User choose low to high button")
    public void userChooseLowToHighButton() {
        homePage.clickLoHiSorting();
    }

    @Then("Items on home page will be sorted from low to high")
    public void ItemsOnHomePageWillBeSortedFromLowToHigh(){
        Assert.assertTrue(homePage.firstPrice() > homePage.secondPrice(), "Test failed: First price is not higher than the last price");

    }


}
