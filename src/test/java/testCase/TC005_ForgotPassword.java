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
		logger.info("****Started TC002_LoginTest****");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAcc();
		hp.clickLogin();
		logger.info("Login Page displayed");
		
		LoginPage lp=new LoginPage(driver);
		lp.clickforgotpassword();
		
		logger.info("ForgotPasswordPage is opened..");
		ForgotPasswordPage fp=new ForgotPasswordPage(driver);
		fp.setregisteredemail(randomeString()+ "@gmail.com");
		fp.clickcontinuebtn();
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
	}
}
