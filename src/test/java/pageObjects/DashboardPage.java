package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{

	public DashboardPage(WebDriver driver) {
		super(driver);
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//h2[text()='My Account']")
	WebElement MsgHeading;
	
	@FindBy(xpath= "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnklogout;

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
	
	public void logoutbtn()
	{
		lnklogout.click();
	}
	
}
