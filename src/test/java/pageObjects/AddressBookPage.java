package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressBookPage extends BasePage{

	public AddressBookPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath= "//a[normalize-space()='New Address']")
WebElement newaddres;

@FindBy(xpath= "//input[@id='input-firstname']")
WebElement addr_lnkfname;

@FindBy(xpath= "//input[@id='input-lastname']")
WebElement addr_lnklname;

@FindBy(xpath="//input[@id='input-address-1']")
WebElement addr_lnkaddress1;

@FindBy(xpath= "//input[@id='input-city']")
WebElement addr_lnkcity;

@FindBy(xpath= "//input[@id='input-postcode']")
WebElement addr_postcode;

@FindBy(xpath= "//select[@id='input-country']")
WebElement addr_selectcntry;

@FindBy(xpath= "//select[@id='input-zone']")
WebElement addr_selectregion;

@FindBy(xpath= "//input[@value='1']")
WebElement addr_defaultaddress;

@FindBy(xpath= "//input[@value='Continue']")
WebElement addr_continue;

@FindBy(xpath = "//h2[normalize-space()='Address Book Entries']/following-sibling::div//table//tbody/tr")
List<WebElement> addressDetails;

public void clicknewadd()
{
	newaddres.click();
}

public void setfirstname_add(String ad_fname)
{
	addr_lnkfname.sendKeys(ad_fname);
}

public void setlastname_add(String ad_lname)
{
	addr_lnklname.sendKeys(ad_lname);
}

public void setaddress1_add(String ad_address1)
{
	addr_lnkaddress1.sendKeys(ad_address1);
}

public void setcityname_add(String ad_city)
{
	addr_lnkcity.sendKeys(ad_city);
}

public void setpostalcode_add(String ad_postcode)
{
	addr_postcode.sendKeys(ad_postcode);
}

public void setcuntry_add(String selectcountryname)
{
	Select countryname=new Select(addr_selectcntry);
	countryname.selectByVisibleText(selectcountryname);
}

public void setregiron_add(String selectregironname)
{
	Select regionname=new Select(addr_selectregion);
	regionname.selectByVisibleText(selectregironname);
}

public void selectdefaultadd()
{
	addr_defaultaddress.click();
}

public void btncontinue()
{
	addr_continue.click();
}

public String getAddressDetails()
{
    String details = "";

    for(WebElement address : addressDetails)
    {
        details = details + address.getText() + " ";
    }

    return details;
}
}
