package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.HomePage;
import pageObjects.LP3065Page;
import pageObjects.LaptopsPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC04_CompletePurchase extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC04_CompletePurchase.class);

    @Test(groups = {"sanity", "regression"}, priority = 1, retryAnalyzer = RetryAnalyzer.class)
    void testAddToCart() throws InterruptedException {
        logger.info("Step 1: Starting testAddToCart");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("Navigated to HomePage");

            hp.clickLaptops();
            logger.debug("Clicked on 'Laptops'");

            hp.clickShowAllLaptops();
            logger.debug("Clicked on 'Show All Laptops'");

            LaptopsPage lp = new LaptopsPage(getDriver());
            lp.clickHP3065();
            logger.debug("Selected HP LP3065");

            LP3065Page productPage = new LP3065Page(getDriver());
            productPage.inputDeliveryDate();
            logger.debug("Entered delivery date");

            productPage.clickAddToCart();
            logger.debug("Clicked on 'Add to Cart'");

            productPage.clickCheckout();
            logger.debug("Clicked on 'Checkout'");

        } catch (Exception e) {
            logger.error("Exception in testAddToCart", e);
            Assert.fail("Test step failed in testAddToCart: " + e.getMessage());
        }
    }

    @Test(priority = 2, dependsOnMethods = {"testAddToCart"}, retryAnalyzer = RetryAnalyzer.class)
    void testLogin() {
        logger.info("Step 2: Starting testLogin");

        try {
            CheckoutPage cp = new CheckoutPage(getDriver());
            cp.clickLogin();
            logger.debug("Clicked login on Checkout page");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("zhouyijun@gmail.com");
            logger.debug("Entered email");

            lp.setPwd("qwer9870");
            logger.debug("Entered password");

            lp.clickLogin1();
            logger.debug("Clicked login button");

        } catch (Exception e) {
            logger.error("Exception in testLogin", e);
            Assert.fail("Test step failed in testLogin: " + e.getMessage());
        }
    }

    @Test(priority = 3, dependsOnMethods = {"testAddToCart", "testLogin"}, retryAnalyzer = RetryAnalyzer.class)
    void testCheckout() throws InterruptedException {
        logger.info("Step 3: Starting testCheckout");

        try {
            CheckoutPage cp = new CheckoutPage(getDriver());

            cp.selectAddress();
            logger.debug("Selected billing/shipping address");

            cp.selectShippingMethod();
            logger.debug("Selected shipping method");

            cp.selectPaymentMethod();
            logger.debug("Selected payment method");

            cp.comfirmOrder();
            logger.debug("Confirmed the order");

            ConfirmationPage confirmP = new ConfirmationPage(getDriver());
            boolean orderStatus = confirmP.isOrderPlaced();
            logger.debug("Order placement result: " + orderStatus);

            Assert.assertTrue(orderStatus, "Order placement failed!");
            logger.info("Order was placed successfully");

        } catch (AssertionError e) {
            logger.error("Assertion failed in testCheckout", e);
            Assert.fail("Assertion failed: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception in testCheckout", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
