package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage extends BasePage {

	public WishlistPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath= "//a[normalize-space()='MacBook']")
WebElement wishlist;

	public boolean wishlistprdt()
	{
		try
		{
		return wishlist.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
}



