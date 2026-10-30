package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC001_Search extends BaseClass {
	
	@Test()
	public void Verify_Search() {
	try
	{
		logger.info("****Started TC002_LoginTest****");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAcc();
		hp.clickLogin();
		logger.info("Login Page displayed");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clickloginbtn();
		logger.info("Login Sucessfull");
		
		DashboardPage dp=new DashboardPage(driver);
        boolean targetpage = dp.ismyaccountDisplayed();
        Assert.assertTrue(targetpage, "My Account heading is not displayed");
        logger.info("Login Successful and My Account is displayed");
        
        SearchPage sp=new SearchPage(driver);
        
        sp.Searchtext("text");
        logger.info("Entering product name...");
        sp.searchbtn();
        boolean noProductMessage = sp.isNoProductMessageDisplayed();       
        if(noProductMessage)
        {
        logger.info("No products available for the search criteria.");
        captureScreen("Verify_Search");
        }
        else
        {
        	logger.info("Products are available for the search criteria.");
        }
        }
	catch(Exception e)
	{
		Assert.fail();
	}
}
}
