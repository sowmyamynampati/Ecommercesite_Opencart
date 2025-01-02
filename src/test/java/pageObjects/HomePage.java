package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
		
	public HomePage(WebDriver driver)
		{
			super(driver);
		}

	// locators 
		
		@FindBy(xpath="( //span[normalize-space()='My Account']")
		WebElement MyAccount;
		
		@FindBy(xpath="//a[normalize-space()='Register']")
		WebElement Register;
		
		@FindBy(linkText="Login")
		WebElement Login;
		
		// action methods 
		
		public void clickMyAccount()
		{
			MyAccount.click();
		}
		
		public void clickRegister()
		{
			Register.click();
		}
		
		public void clickLogin()
		{
			Login.click();
		}

}


