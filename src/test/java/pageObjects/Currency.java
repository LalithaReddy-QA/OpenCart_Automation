package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Currency extends BasePage{

	public Currency(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath= "//span[normalize-space()='Currency']")
WebElement currency;

@FindBy(xpath= "//button[normalize-space()='$US Dollar']")
WebElement usdollar;

public void clickcurrency()
{
	currency.click();
}

public void selectusdollar()
{
	usdollar.click();
}

}
