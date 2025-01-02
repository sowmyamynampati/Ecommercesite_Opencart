package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;



import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class Tc2_LoginTest extends BaseClass{

	
	@Test(groups={"Sanity", "Master"})
	public void verifyLogin() {
		logger.info("starting login test");
		try {
		
		HomePage hp= new HomePage(driver);   // Home Page
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);    // Login Page
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		 MyAccountPage map= new MyAccountPage(driver);// My Account
		 
		boolean targetPage = map.isMyAccountPageExists();
		Assert.assertTrue(targetPage);
		}
		catch(Exception e) {
			Assert.fail();		}
	}
	
}

