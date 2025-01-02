package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);    // TODO Auto-generated constructor stub
	}

	@FindBy(name="email")
	WebElement txtEmai;
	
	@FindBy(xpath= "//*[@id=\"input-password\"]")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement txtlogin;
	
	
	public void setEmail(String email) {
		
		txtEmai.sendKeys(email);
	}
	
public void setPassword(String pwd) {
		
	txtPassword.sendKeys(pwd);
	}

public void clickLogin() {
	
	txtlogin.click();
}

}
