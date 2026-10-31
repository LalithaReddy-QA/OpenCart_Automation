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
		logger.info("Registration page opened..");
		accreg.setFirstname(randomeString());
		accreg.setlname(randomeString());
		accreg.setEmail(randomeString()+ "@gmail.com");
		accreg.setTelephoneNo(randomeNumber());
		String Password=randomeAlphaNumeric();
		accreg.setpassword(Password);
		accreg.setconfpassword(Password);
		accreg.checkpolicy();
		accreg.clickcontinuebtn();
		logger.info("Provided Details to Register..");
		String conf=accreg.msgConfirmation();
		if (conf.equals("Your Account Has Been Created!"))
		{
			logger.info("Account created..");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Account creation failed");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****Finished TC001_AccountRegistrationTest****");
	}
	
}
