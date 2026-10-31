package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC005_ForgotPassword extends BaseClass{

	@Test(groups ={"sanity", "Master"})
	public void verify_forgotpassword() 
	{
		try
		{
		logger.info("****Started TC005_ForgotPassword****");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAcc();
		logger.info("clicked on My Account");
		hp.clickLogin();
		logger.info("clicked on login");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Login Page displayed");
		
		lp.clickforgotpassword();
		logger.info("ForgotPasswordPage is opened..");
		
		ForgotPasswordPage fp=new ForgotPasswordPage(driver);
		logger.info("Forgotpassword page opened");
		
		fp.setregisteredemail(randomeString()+ "@gmail.com");
		logger.info("Email entered");

		fp.clickcontinuebtn();
		logger.info("Clicked on continue button");

		boolean emailnotfound=fp.isemailnotfound();
		if(emailnotfound)
		{
			logger.info("Email not found...");
			captureScreen("verify_forgotpassword");
		}
		else
		{
			logger.info("Email found.. login page opened");
		}
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
		
		logger.info("****Finished TC005_ForgotPassword****");

	}
}
