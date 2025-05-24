package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

public class TC01_LaunchApplication extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC01_LaunchApplication.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = utilities.RetryAnalyzer.class)
    void testLaunchApplication() {
        logger.info("Starting test: testLaunchApplication");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created");

            String title = getDriver().getTitle();
            logger.debug("Fetched page title: " + title);

            Assert.assertEquals(title, "Your store of fun");
            logger.info("Assertion passed: Title is as expected.");

        } catch (AssertionError e) {
            logger.error("Assertion failed: Page title did not match", e);
            Assert.fail("Test failed due to assertion error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception occurred during test execution", e);
            Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
        }
    }
}
