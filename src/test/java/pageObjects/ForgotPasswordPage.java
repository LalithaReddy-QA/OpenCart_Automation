package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage
{

	public ForgotPasswordPage(WebDriver driver) 
	{
	super(driver);
	PageFactory.initElements(driver, this);
	}

@FindBy(xpath= "//input[@id='input-email']")
WebElement registeredemail;

@FindBy(xpath= "//input[@value='Continue']")
WebElement continuebtn;

@FindBy(xpath= "//div[@class='alert alert-danger alert-dismissible']")
WebElement emailnotfound;

public void setregisteredemail(String email)
{
	registeredemail.sendKeys(email);
}

public void clickcontinuebtn()
{
	continuebtn.click();
}

public boolean isemailnotfound()
{
	try
	{
		return emailnotfound.isDisplayed();
	}
	catch(Exception e)
	{
		return false;
	}
}
}
