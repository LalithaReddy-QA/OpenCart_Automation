package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCartPage extends BasePage{

	public AddCartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath= "//div[@class='alert alert-danger alert-dismissible']")
WebElement productavailability;
	
public boolean outofstockmessage()
{
	try
	{
		return productavailability.isDisplayed();
	}
	catch(Exception e)
	{
		return false;
	}
}

}
