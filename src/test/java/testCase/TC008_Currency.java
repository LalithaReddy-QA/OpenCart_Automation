package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Currency;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC008_Currency extends BaseClass{
	
	@Test()
	public void verify_Currency()
	{
		try
		{
			logger.info("****Started TC008_Currency****");		
			
			Currency cp=new Currency(driver);
			cp.clickcurrency();
			logger.info("Clicking on currency..");

			cp.selectusdollar();
			logger.info("Selected usdollar currency");		

			HomePage hp=new HomePage(driver);
			hp.clickMyAcc();
			logger.info("clicked on My Account");
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
	        sp.Searchtext("iphone");
	        logger.info("Entering product name...");
	        sp.searchbtn();
			boolean selcurdisp=sp.checkselected_currency();
			if(selcurdisp)
			{
				logger.info("Dollar currency applied..");
			}
			else
			{
				logger.info("Dollar currency not updated...");
			}
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
		
		logger.info("****Finished TC008_Currency****");		

	}

}
