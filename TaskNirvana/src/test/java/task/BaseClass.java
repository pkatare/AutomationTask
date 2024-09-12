package task;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.utility;


public class BaseClass {
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	 
        public WebDriver driver;
        
	
		@BeforeTest
	    public void setUp() {
			
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("MyReport");
	        extent.attachReporter(spark);
            WebDriverManager.chromedriver().setup();
	        //System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe"); 
	        driver = new ChromeDriver(); 
	        driver.get("https://www.saucedemo.com/");
	    }
		
		@AfterMethod
		
		public void getscreenshot(ITestResult result) throws IOException {
			if(ITestResult.FAILURE==result.getStatus()){
				utility.TakeScreenshots(driver,result.getTestName());
			}	
		}

	    @AfterTest
	    public void tearDown() {
	    	extent.flush();
	          driver.quit();
	        }
}
	    


