
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtfrstname;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtlastname;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkbox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement btncontinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void setFirstname(String fname) {
        txtfrstname.sendKeys(fname);
    }

    public void setlname(String lname) {
        txtlastname.sendKeys(lname);
    }

    public void setEmail(String Email) {
        txtEmail.sendKeys(Email);
    }

    public void setTelephoneNo(String phnNo) {
        txtTelephone.sendKeys(phnNo);
    }

    public void setpassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void setconfpassword(String password) {
        txtConfirmPassword.sendKeys(password);
    }

    public void checkpolicy() {
        checkbox.click();
    }

    public void clickcontinuebtn() {
        btncontinue.click();
    }

    public String msgConfirmation() {
        return msgConfirmation.getText();
    }
}

