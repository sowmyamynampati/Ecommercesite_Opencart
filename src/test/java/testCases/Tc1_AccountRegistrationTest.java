package testCases;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.AccountRegistrationPage;


public class Tc1_AccountRegistrationTest extends BaseClass {
	public	WebDriver driver;
	public Logger logger;
	@Test (groups={"Regression", "Master"})
public void verify_account_registration() {
		try {
		
		logger.info("starting tc_AccountRegistrationTest");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
	logger.info("Clicked on MyAccount Link"); 
	hp.clickRegister();
	logger.info("Clicked on Register Link");
	
	AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
	
	logger.info("Providing customer details");
	 regpage.setFirstName(randomeString().toUpperCase()); 
	 regpage.setLastName(randomeString().toUpperCase());
	 regpage.setEmail(randomeString()+"@gmail.com");  // we have to provide new email on every execution 
	 regpage.setTelephone(randomeNumber());
	 
	 String password= randomeAlphaNumberic();
	 regpage.setPassword(password); 
	 regpage.setConfirmPassword(password);
	 regpage.setAgree();
	 regpage.setContinue();
		}
		catch (Exception e) {
			logger.info("Test failed..");
		
			Assert.fail();
		}
		logger.info("Finished AccountRegistertaionTest");
		}
	

}
