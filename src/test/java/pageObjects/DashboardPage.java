package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage{

	public DashboardPage(WebDriver driver) {
		super(driver);
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//h2[text()='My Account']")
	WebElement MsgHeading;
	
	@FindBy(xpath= "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnklogout;
	
	@FindBy(xpath= "//a[normalize-space()='Address Book']")
	WebElement lnkaddressbook;
	
	@FindBy(xpath= "//a[normalize-space()='Register for an affiliate account']")
	WebElement lnkaffilicateacc;
	
	@FindBy(xpath= "//div[contains(@class,'alert-success')]")
	WebElement successmsg;

	public boolean ismyaccountDisplayed()
	{
	    try
	    {
	        return MsgHeading.isDisplayed();
	    }
	    catch(Exception e)
	    {
	        System.out.println("My Account element not found: " + e.getMessage());
	        return false;
	    }
	
	}
	
	public void addressbookbtn()
	{
		lnkaddressbook.click();
	}
	
	public void logoutbtn()
	{
		lnklogout.click();
	}
	
	public void clickaffiliateacc()
	{
		lnkaffilicateacc.click();
	}
	
	public boolean displayedsuccessmessage()
	{
	    try
	    {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(successmsg));
	        return true;
	    }
	    catch(Exception e)
	    {
	        return false;
	    }
	}
	
}
