package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	public	WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@Parameters({"os", "browser"})
		@BeforeClass(groups={"Sanity", "Regression", "Master"})
		
		public void setup(String os, String br) throws IOException{
			//Loading config.proerties
			FileReader file= new FileReader("./src//test//resources//config.properties");
			p= new Properties();
			p.load(file);
			
			logger= LogManager.getLogger(this.getClass());  //log4j2
			switch(br.toLowerCase()){
			case "chrome": driver= new ChromeDriver(); break;
			case "edge": driver= new EdgeDriver(); break;
			case "firefox": driver= new FirefoxDriver(); break; 
			default: System.out.println("Invalid browser name"); return;
				
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("appURL"));  //reading URL from properties file
			driver.manage().window().maximize();
		} 
		
		 @AfterClass (groups={"Sanity", "Regression", "Master"})
			public void teardown() {
				driver.quit();
				}
		 public String randomeString() {
				
				String generatedstring= RandomStringUtils.randomAlphabetic(5);
					return generatedstring;
				}
			public String randomeNumber() {
				
					String generatednumber= RandomStringUtils.randomNumeric(10);
						return generatednumber;
					}
			public String randomeAlphaNumberic() {
					
					String generatedstring= RandomStringUtils.randomAlphabetic(3);
			       
					String generatednumber= RandomStringUtils.randomNumeric(3);
						return (generatedstring+"@"+generatednumber);
					}
			
	  }
