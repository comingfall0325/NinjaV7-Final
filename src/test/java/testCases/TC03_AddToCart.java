package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageObjects.HomePage;
import pageObjects.LP3065Page;
import pageObjects.LaptopsPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC03_AddToCart extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC03_AddToCart.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = RetryAnalyzer.class)
    void testAddToCart() throws InterruptedException {
        logger.info("Starting test: testAddToCart");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage loaded");
            hp.clickLaptops();
            logger.debug("Clicked on Laptops");
            hp.clickShowAllLaptops();
            logger.debug("Clicked on Show All Laptops");

            LaptopsPage lp = new LaptopsPage(getDriver());
            lp.clickHP3065();
            logger.debug("Clicked on HP LP3065 product");

            LP3065Page productPage = new LP3065Page(getDriver());
            productPage.inputDeliveryDate();
            logger.debug("Entered delivery date");

            productPage.clickAddToCart();
            logger.debug("Clicked on Add to Cart");

            String actualMessage = productPage.getAddToCartMsg();
            logger.debug("Add to Cart message: " + actualMessage);

            Assert.assertEquals(actualMessage, "Success: You have added HP LP3065 to your shopping cart!");
            logger.info("Add to Cart assertion passed");

        } catch (AssertionError e) {
            logger.error("Assertion failed: Add to Cart message mismatch", e);
            Assert.fail("Assertion failed: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception during Add to Cart test", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
