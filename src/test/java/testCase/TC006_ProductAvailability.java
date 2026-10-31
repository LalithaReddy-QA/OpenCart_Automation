package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddCartPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC006_ProductAvailability extends BaseClass {
	
	@Test()
	public void verify_productavailability()
	{
		try
		{
		logger.info("****Started TC006_ProductAvailability****");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAcc();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Login Page displayed");
		
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
        sp.btnaddcart();
        logger.info("Added to cart");
        
        sp.clickonshoppingcart();
        logger.info("clicked on shopping cart");
        
        AddCartPage ac=new AddCartPage(driver);
        logger.info("Shopping cart page opened");
        boolean prdctoutofstock=ac.outofstockmessage();
        
        if(prdctoutofstock)
        {
        	logger.info("selected product is outofstock");
        }
        else
        {
        	logger.info("Product is available");
        }
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
		logger.info("****Finished TC006_ProductAvailability****");

	}
	
}
