package stepDefenitions;

import Pages.*;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutSteps {
    AndroidDriver driver;
    HomePage homePage;
    CartPage cartPage;
    CheckoutOverview checkoutOverview;
    CheckoutInformation checkoutInformation;
    CheckoutComplete checkoutComplete;

    public CheckoutSteps(AndroidDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutOverview = new CheckoutOverview(driver);
        this.checkoutInformation = new CheckoutInformation(driver);
        this.checkoutComplete = new CheckoutComplete(driver);
    }

        @Given("User add products to cart")
        public void userAddProductsToCart(){
        homePage.clickGoCart1();
        homePage.clickGoCart2();
        }

        @When("User click cart button")
        public void userClickCartButton(){
            homePage.clickCartButton();
            cartPage.validateOnYourCartPage();
            Assert.assertEquals(cartPage.setCartTitle(), "YOUR CART");

        }
        @And ("User scrolls to element with {string} on cart page")
        public void UserScrollsOnCartPage(String checkout){
            cartPage.scrollCartPage(checkout);
        }

        @And ("User click on checkout button")
        public void userClickOnCheckoutButton(){
            cartPage.clickCheckoutButton();
        }

        @And ("User fills checkout information with first name {string}, last name {string}, and zip postal {string}")
        public void userFillsCheckoutInformation(String firstName, String lastName, String postalCode){
            checkoutInformation.validationOnCheckoutInformation();
            Assert.assertEquals(checkoutInformation.getTitlePage(), "CHECKOUT: INFORMATION");
            checkoutInformation.inputFirstName(firstName);
            checkoutInformation.inputLastName(lastName);
            checkoutInformation.inputPostalCode(postalCode);
        }

        @And ("User Click continue button")
        public void userClickContinueButton(){
            checkoutInformation.clickContinueButton();
            checkoutOverview.validationOnCheckoutOverview();
            Assert.assertEquals(checkoutOverview.getTitlePage(), "CHECKOUT: OVERVIEW");
            checkoutOverview.paymentInfoValueIsDisplayed();
            checkoutOverview.shippingInformationValueIsDisplayed();
        }

        @And("User scrolls to element with text {string} on Checkout Overview Page")
        public void  UserScrollsOnCheckoutOverviewPage(String finishText){
            checkoutOverview.scrollCheckoutOverviewPage(finishText);
        }

        @And ("User click finish button")
        public void userClickFinishButton(){
            checkoutOverview.clickFinishButton();
        }


        @Then ("User successfully checkout product")
        public void userSuccessfullyCheckout(){
            checkoutComplete.validateOnCheckoutComplete();
            checkoutComplete.completeLogoIsDisplayed();
            checkoutComplete.backHomeButtonIsDisplayed();
            Assert.assertEquals(checkoutComplete.getPageTitle(), "CHECKOUT: COMPLETE!");
            Assert.assertEquals(checkoutComplete.getCompleteText(), "THANK YOU FOR YOU ORDER");
            Assert.assertEquals(checkoutComplete.getDescCompleteText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");

        }
}
