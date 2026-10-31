package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//input[@placeholder='Search']")
WebElement lnkSearch;
	
@FindBy(xpath= "//button[@class='btn btn-default btn-lg']")
WebElement search;

@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
WebElement searchresult;

@FindBy(xpath= "//span[normalize-space()='Add to Cart']")
WebElement addcart;

@FindBy(xpath= "//span[normalize-space()='Shopping Cart']")
WebElement shoppingcart;

@FindBy(css= "div[id='content'] div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(2) button:nth-child(2)")
WebElement btnwishlist;

@FindBy(xpath= "//p[@class='price'][starts-with(text(),'$')]")
WebElement usdollar;

public void Searchtext(String product)
{
	lnkSearch.sendKeys(product);
}

public void searchbtn()
{
	search.click();
}

public boolean isNoProductMessageDisplayed()
{
	try
	{
	return searchresult.isDisplayed();
	}
	catch(Exception e)
	{
		return false;
	}
}

public void btnaddcart()
{
	addcart.click();
}

public void clickonshoppingcart()
{
	shoppingcart.click();
}

public void wishlisticon()
{
	btnwishlist.click();
}

public boolean checkselected_currency()
{
	try
	{
		return usdollar.isDisplayed();
	}
	catch(Exception e)
	{
		return false;
	}
}

}
