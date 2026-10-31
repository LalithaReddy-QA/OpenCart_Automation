package testCase;

import testBase.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_LoginTest extends BaseClass {

	@Test(groups ={"sanity", "Master"})
	public void verify_login()
	{
		try
		{
			logger.info("****Started TC002_LoginTest****");
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAcc();
			logger.info("clicked on My Account");
			hp.clickLogin();
			logger.info("clicked on login");
			
			LoginPage lp=new LoginPage(driver);
			logger.info("login page opened");
			lp.setEmail(p.getProperty("email"));
			lp.setpassword(p.getProperty("password"));
			lp.clickloginbtn();
			logger.info("Login Sucessfull");
			
			DashboardPage dp=new DashboardPage(driver);
			logger.info("Dashboard opened");
	        boolean targetpage = dp.ismyaccountDisplayed();
	        Assert.assertTrue(targetpage, "My Account heading is not displayed");
		    logger.info("Login Successful and My Account is displayed");
		}
	    catch(Exception e)
	    {
	        logger.error("Test failed: " + e.getMessage());
	        Assert.fail("Test failed due to exception: " + e.getMessage());
	    }

			logger.info("****Finished TC002_LoginTest****");
	}

}
