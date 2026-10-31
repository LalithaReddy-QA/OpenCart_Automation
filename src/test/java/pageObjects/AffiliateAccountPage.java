package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AffiliateAccountPage extends BasePage{

	public AffiliateAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//input[@id='input-company']")
	WebElement lnkcompany;

	@FindBy(xpath= "//input[@id='input-website']")
	WebElement lnkwebsite;
	
	@FindBy(xpath= "//input[@id='input-tax']")
	WebElement lnktax;
	
	@FindBy(xpath= "//input[@value='paypal']")
	WebElement btnpaypal;
	
	@FindBy(xpath= "//input[@id='input-paypal']")
	WebElement lnkpayeename;
	
	@FindBy(xpath= "//input[@name='agree']")
	WebElement policybtn;
	
	@FindBy(xpath= "//input[@value='Continue']")
	WebElement btncontinue;
	
	public void setcompanyname(String cmpname)
	{
		lnkcompany.sendKeys(cmpname);
	}
	
	public void setwebsite(String websitename)
	{
		lnkwebsite.sendKeys(websitename);
	}
	
	public void settaxID(String taxID)
	{
		lnktax.sendKeys(taxID);
	}
	
	public void paymenttype()
	{
		btnpaypal.click();
	}
	
	public void setpayeename(String payeename)
	{
		lnkpayeename.sendKeys(payeename);
	}
	
	public void clickcontinue()
	{
		btncontinue.click();
	}
	
	public void checkpolicy()
	{
		policybtn.click();
	}
	

}
