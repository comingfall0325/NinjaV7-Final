package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageObjects.AccountPage;
import pageObjects.AffiliatePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC06_AddAffiliate extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC06_AddAffiliate.class);

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void testAddAffiliate() throws InterruptedException {
        logger.info("=== Starting testAddAffiliate ===");

        try {
            // Step 1: Navigate to Affiliate Page
            HomePage hp = new HomePage(getDriver());
            logger.debug("Navigated to HomePage");

            hp.clickAffiliate();
            logger.debug("Clicked on Affiliate link");

            // Step 2: Login
            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("zhouyijun@gmail.com");
            logger.debug("Entered email");

            lp.setPwd("qwer9870");
            logger.debug("Entered password");

            lp.clickLogin1();
            logger.debug("Clicked login button");

            // Step 3: Fill Affiliate Form
            AffiliatePage ap = new AffiliatePage(getDriver());
            ap.inputCompany("Ruggie");
            logger.debug("Entered company name");

            ap.inputWebsite("https://cloudberry.store");
            logger.debug("Entered website URL");

            ap.inputTaxID("654321");
            logger.debug("Entered Tax ID");

            ap.inputCheque("Mable");
            logger.debug("Entered cheque name");

            ap.clickContinue();
            logger.debug("Clicked Continue button");

            // Step 4: Validate success message
            AccountPage accP = new AccountPage(getDriver());
            boolean success = accP.msgAddAffiliate();
            logger.debug("Affiliate success message visibility: " + success);

            Assert.assertTrue(success, "Affiliate registration message not displayed");
            logger.info("Affiliate successfully added");

        } catch (AssertionError e) {
            logger.error("Assertion failed in testAddAffiliate", e);
            Assert.fail("Assertion failed: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception in testAddAffiliate", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
