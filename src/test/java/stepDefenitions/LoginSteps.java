package stepDefenitions;

import Pages.HomePage;
import Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    AndroidDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    public LoginSteps(AndroidDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);

    }

    @Given("User already in login page")
    public void userAlreadyInLoginPage() {
        loginPage.validateOnLoginPage();
    }

    @And("User input username with {string}")
    public void user_input_username(String username){
        loginPage.inputUsername(username);
    }

    @And("User input password with {string}")
    public void userInputPasswordWith(String password) {
        loginPage.inputPassword(password);
    }
    @When("User click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User get Error message")
    public void error_message_appears(){
        Assert.assertEquals(loginPage.displayedErrorMsg(), "Username and password do not match any user in this service.");
    }

    @Then("User is on Home Page")
    public void userIsOnHomePage() {
        homePage.validateOnHomePage();
        Assert.assertEquals(homePage.productPageTitle(),"PRODUCTS");
    }

    @And("user stay in login page")
    public void userStayInLoginPage() {
        loginPage.stayInTheLoginPage();
    }
}
