package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class, groups="DataDriven")
	public void Verify_loginDDT(String Email, String pwd, String exprslt)
	{
		try
		{
		logger.info("*****Starting TC003_LoginDDT*****");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAcc();
		logger.info("clicked on My account");
		hp.clickLogin();
		logger.info("clicked on login button");
		
		LoginPage lp=new LoginPage(driver);	
		logger.info("login Page opened");
		lp.setEmail(Email);
		lp.setpassword(pwd);
		lp.clickloginbtn();
		logger.info("login Success");

		DashboardPage dp=new DashboardPage(driver);
		logger.info("Dashboard page opened");
        boolean targetpage = dp.ismyaccountDisplayed();
        
        if(exprslt.equalsIgnoreCase("Valid"))
        {
        	if(targetpage==true)
        	{
        	dp.logoutbtn();
        	Assert.assertTrue(true);
        	}
        	else
        	{
        		Assert.assertTrue(false);
        	}
        }
        
        if(exprslt.equalsIgnoreCase("Invalid"))
        {
        	if(targetpage==true)
        	{
        		dp.logoutbtn();
        		Assert.assertTrue(false);
        	}
        	else
        	{
        		Assert.assertTrue(true);
        	}
        }
		}
        catch(Exception e)
        {
        	Assert.fail();
        }
		logger.info("*****Finished TC003_LoginDDT*****");
	}
	
}
