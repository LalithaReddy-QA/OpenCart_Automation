package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
        PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement lnkEmail;
	
	@FindBy(xpath= "//input[@id='input-password']")
	WebElement lnkPassword;
	
	@FindBy(xpath= "//input[@value='Login']")
	WebElement Loginbtn;
	
	@FindBy(xpath= "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	WebElement forgotpassword;
	
	public void setEmail(String email)
	{
		lnkEmail.sendKeys(email);
	}
	
	public void setpassword(String pwd)
	{
		lnkPassword.sendKeys(pwd);
	}
	
	public void clickloginbtn()
	{
		Loginbtn.click();
	}
	
	public void clickforgotpassword()
	{
		forgotpassword.click();
	}
}
