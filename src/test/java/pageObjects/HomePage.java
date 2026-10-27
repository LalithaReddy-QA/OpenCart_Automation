package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyAcc;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkRegister;
    
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement lnkLogin;

    public void clickMyAcc() {
        lnkMyAcc.click();
    }

    public void clickRegister() {
        lnkRegister.click();
    }
    
    public void clickLogin() {
    	lnkLogin.click();
    }
}

