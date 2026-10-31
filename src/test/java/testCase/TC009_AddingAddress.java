package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddressBookPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC009_AddingAddress extends BaseClass{
	
	@Test()
	public void Verify_AddAddress()
	{
		try {
		logger.info("****Started TC009_AddingAddress****");
		
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
	    
	    dp.addressbookbtn();
	    logger.info("clicked on Addressbook..");
	    
	    AddressBookPage abp=new AddressBookPage(driver);
	    
	    String fnameinadd = randomeString();
        String lnameinadd = randomeString();
        String addressinaddbook = randomeString();
        String cityinadd = randomeString();
        String postcodeinadd = randomSixDigitNumber();
        logger.info("Saved data successfully");
        
	    abp.clicknewadd();
	    abp.setfirstname_add(fnameinadd);
	    abp.setlastname_add(lnameinadd);
	    abp.setaddress1_add(addressinaddbook);
	    abp.setcityname_add(cityinadd);
	    abp.setpostalcode_add(postcodeinadd);
	    abp.setcuntry_add("India");
	    abp.setregiron_add("Andhra Pradesh");
	    abp.selectdefaultadd();
	    abp.btncontinue();
	    logger.info("Address added..");
	    
	    String actualaddress=abp.getAddressDetails();    
	    Assert.assertTrue(actualaddress.contains(fnameinadd), "First name is not displayed");
        Assert.assertTrue(actualaddress.contains(lnameinadd), "Last name is not displayed");
        Assert.assertTrue(actualaddress.contains(addressinaddbook), "Address is not displayed");
        Assert.assertTrue(actualaddress.contains(cityinadd), "City is not displayed");
        Assert.assertTrue(actualaddress.contains(postcodeinadd), "Postcode is not displayed");
        
        logger.info("Address saved successfully");
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}

		logger.info("****Finished TC009_AddingAddress****");

	}
}
