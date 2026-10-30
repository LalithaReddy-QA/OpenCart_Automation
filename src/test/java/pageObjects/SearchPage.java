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


}
