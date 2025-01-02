package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;


public class Tc3_LoginDDT extends BaseClass {
	
	@Test(dataProvider="logindata", dataProviderClass=DataProviders.class, groups="Datadriven")  //getting data provider from different class
	public void Verify_loginDDT(String email, String pwd, String exp)
	{
	HomePage hp= new HomePage(driver);   // Home Page
	hp.clickMyAccount();
	hp.clickLogin();
	
	LoginPage lp= new LoginPage(driver);    // Login Page
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.clickLogin();
	
	 MyAccountPage map= new MyAccountPage(driver);// My Account
	 boolean targetPage = map.isMyAccountPageExists();
	 
	 /* 
	   Data is valid -- login success - test pass-- logout
	   Data is valid -- login failed -- test fail 
	   
	   Data is invalid -- login success -- test fail
	   Data is invalid - login failed --test pass
	    */
	 
	 
	 if(exp.equalsIgnoreCase("Valid"))
	 {
		 if(targetPage=true) {
			 Assert.assertTrue(true);
			 map.clickLogout();
			 }
		 else
		 {
			 Assert.assertTrue(false); 
		 }
		 
		 if (exp.equalsIgnoreCase("Invalid"))
		 {
			 if(targetPage=true) {
				 Assert.assertTrue(false);
				 map.clickLogout();
				 }
			 else{
				 Assert.assertTrue(true);  
			 }
		 }
		 
		 }
	}
}