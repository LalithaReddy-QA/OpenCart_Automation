package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import pageObjects.WishlistPage;
import testBase.BaseClass;

public class TC007_Wishlist extends BaseClass 
{

	@Test()
	public void verify_Wishlistproduct()
	{
	try
	{
	logger.info("****Started TC007 Wishlist****");
	
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
    sp.Searchtext("MacBook");
    logger.info("Entered product name...");
    sp.searchbtn();
    sp.wishlisticon();
    
    WishlistPage wp=new WishlistPage(driver);
	logger.info("Wishlist Page displayed");

    boolean productfound=wp.wishlistprdt();
    if(productfound)
    {
    	logger.info("Product added to wishlist..");
    }
    else
    {
    	logger.info("Product not added to wishlist..");
    }
	}
	catch(Exception e)
	{
		Assert.fail(e.getMessage());
	}
	logger.info("****Finished TC007_Wishlist****");

}
}
