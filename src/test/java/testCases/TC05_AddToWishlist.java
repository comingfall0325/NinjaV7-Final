package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LP3065Page;
import pageObjects.LaptopsPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC05_AddToWishlist extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC05_AddToWishlist.class);

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
    void testAddToWishlist() throws InterruptedException {
        logger.info("=== Starting testAddToWishlist ===");

        try {
            // Step 1: Login
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage loaded");

            hp.clickMyAccount();
            logger.debug("Clicked 'My Account'");

            hp.clickLogin();
            logger.debug("Clicked 'Login'");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("zhouyijun@gmail.com");
            logger.debug("Entered email");

            lp.setPwd("qwer9870");
            logger.debug("Entered password");

            lp.clickLogin1();
            logger.debug("Clicked login button");

            // Step 2: Navigate to Product Page
            AccountPage ap = new AccountPage(getDriver());
            ap.clickHomePage();
            logger.debug("Navigated to Home Page after login");

            hp.clickLaptops();
            logger.debug("Clicked 'Laptops'");

            hp.clickShowAllLaptops();
            logger.debug("Clicked 'Show All Laptops'");

            LaptopsPage lapPage = new LaptopsPage(getDriver());
            lapPage.clickHP3065();
            logger.debug("Selected HP LP3065 product");

            // Step 3: Add to Wishlist
            LP3065Page lp3065Page = new LP3065Page(getDriver());
            lp3065Page.clickAddToWishlist();
            logger.debug("Clicked 'Add to Wishlist'");

            String actualMessage = lp3065Page.getAddToWishlistMsg();
            logger.debug("Wishlist message: " + actualMessage);

            // Step 4: Assertion
            if (actualMessage.contains("Success")) {
                logger.info("Wishlist success message displayed");
                Assert.assertTrue(true);
            } else {
                logger.warn("Wishlist message did not contain 'Success'");
                Assert.assertTrue(false, "Expected success message not found in: " + actualMessage);
            }

        } catch (AssertionError e) {
            logger.error("Assertion failed in testAddToWishlist", e);
            Assert.fail("Assertion failed: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception in testAddToWishlist", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
