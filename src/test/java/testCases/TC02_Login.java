package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

public class TC02_Login extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC02_Login.class);

    @Test(groups = {"sanity", "regression", "datadriven"}, 
          dataProvider = "LoginData", 
          dataProviderClass = DataProviders.class,
          retryAnalyzer = RetryAnalyzer.class)
    void testLogin(String email, String pwd) {
        logger.info("Starting testLogin with email: " + email);

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage initialized");
            hp.clickMyAccount();
            logger.debug("Clicked MyAccount");
            hp.clickLogin();
            logger.debug("Clicked Login");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail(email);
            logger.debug("Entered email");
            lp.setPwd(pwd);
            logger.debug("Entered password");
            lp.clickLogin1();
            logger.debug("Clicked login button");

            AccountPage ap = new AccountPage(getDriver());
            boolean status = ap.getLoginMsg().isDisplayed();
            logger.debug("Login message displayed: " + status);

            if (status) {
                logger.info("Login successful for: " + email);
                ap.clickMyAccountDropDown();
                ap.clickLogout();
            } else {
                logger.warn("Login failed for: " + email);
            }

            Assert.assertTrue(status, "Login status was false.");

        } catch (AssertionError e) {
            logger.error("Assertion failed during login test", e);
            Assert.fail("Test failed due to assertion error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception occurred during login test", e);
            Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
        }
    }
}
