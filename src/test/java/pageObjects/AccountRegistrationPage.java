package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	//constructor 
	public AccountRegistrationPage(WebDriver driver)
	{
	super(driver);
	}
	 
	// locators 
@FindBy(xpath= "//*[@id=\"input-firstname\"]")
WebElement txtFirstName;

@FindBy(xpath="//*[@id=\"input-lastname\"]")
WebElement txtLastName;

@FindBy(xpath="//*[@id=\"input-email\"]")
WebElement txtEmail;

@FindBy(xpath="//*[@id=\"input-telephone\"]")
WebElement txtTelephone;

@FindBy(xpath="//*[@id=\"input-password\"]")
WebElement txtPassword;

@FindBy(xpath="//*[@id=\"input-confirm\"]")
WebElement txtPasswordConfirm;

@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
WebElement txtAgree;

@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
WebElement Continue;


	//Action Methods
 public void setFirstName(String fname)
{
	txtFirstName.sendKeys(fname);
}
	
 public void setLastName(String lname)
 {
	 txtLastName.sendKeys(lname);
 }
 public void setEmail(String email)
 {
	 txtEmail.sendKeys(email);
 }
 
 public void setTelephone(String tel)
 {
	 txtTelephone.sendKeys(tel);
 }
 
 public void setPassword(String pwd)
 {
	 txtPassword.sendKeys(pwd);
	 
 }
 
 public void setConfirmPassword(String pwd)
 {
	 txtPasswordConfirm.sendKeys(pwd);
	 
 }
 
 public void setAgree()
 {
	 txtAgree.click();
 }
 
 public void setContinue()
 {
	 Continue.click();
 }
	}


