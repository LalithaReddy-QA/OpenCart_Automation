package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration()
	{
		try
		{
		logger.info("*****Starting TC001_AccountRegistrationTest*****");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAcc();
		logger.info("clicked on My Account");

		hp.clickRegister();
		logger.info("clicked on Registration");

		
		AccountRegistrationPage accreg=new AccountRegistrationPage(driver);
		
		logger.info("Providing Details to Register");

		accreg.setFirstname(randomeString());
		accreg.setlname(randomeString());
		accreg.setEmail(randomeString()+ "@gmail.com");
		accreg.setTelephoneNo(randomeNumber());
		String Password=randomeAlphaNumeric();
		accreg.setpassword(Password);
		accreg.setconfpassword(Password);
		accreg.checkpolicy();
		accreg.clickcontinuebtn();
		String conf=accreg.msgConfirmation();
		
		if (conf.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed.....");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Registration Success");
	}
	
}
