package task;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	 public WebDriver driver;
	    public String baseUrl = "https://www.saucedemo.com";

	    @SuppressWarnings("deprecation")
		@BeforeClass
	    public void setUp() {
	        
	        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe"); 
	        driver = new ChromeDriver(); 
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get(baseUrl);
	    }

	    @AfterClass
	    public void tearDown() {
	        
	          driver.quit();
	        }}
	    


