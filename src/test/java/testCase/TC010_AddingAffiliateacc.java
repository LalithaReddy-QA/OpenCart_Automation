package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.AffiliateAccountPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC010_AddingAffiliateacc extends BaseClass
{
	@Test()
	public void Verify_Affiliateaccount()
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
			String email=randomeString()+ "@gmail.com";
			accreg.setEmail(email);
			accreg.setTelephoneNo(randomeNumber());
			String Password=randomeAlphaNumeric();
			accreg.setpassword(Password);
			accreg.setconfpassword(Password);
			accreg.checkpolicy();
			accreg.clickcontinuebtn();
			logger.info("Provided Details to Register..");
			accreg.msgConfirmation();			
			logger.info("Account created succefully");
			
			DashboardPage dp=new DashboardPage(driver);
			logger.info("Dashboard opened");
			dp.logoutbtn();
			
			hp.clickMyAcc();
			logger.info("clicked on My Account");
			hp.clickLogin();
			logger.info("clicked on login");
			
			LoginPage lp=new LoginPage(driver);	
			logger.info("login Page opened");		
			lp.setEmail(email);
			lp.setpassword(Password);
			lp.clickloginbtn();
			logger.info("Login Successfull");
			
			dp.clickaffiliateacc();
			logger.info("clicked on affiliate account...");
			
			AffiliateAccountPage ap=new AffiliateAccountPage(driver);
			ap.setcompanyname(randomeNumber());
			ap.setwebsite(randomeNumber());
			ap.settaxID(randomeNumber());
			ap.paymenttype();
			ap.setpayeename(randomeString()+ "@gmail.com");
			ap.checkpolicy();
			ap.clickcontinue();
			
			boolean successmsg = dp.displayedsuccessmessage();

			logger.info("Affiliate success message status: " + successmsg);

			Assert.assertTrue(successmsg, "Affiliate account creation failed");

			logger.info("Affiliate account added successfully");
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}

}
