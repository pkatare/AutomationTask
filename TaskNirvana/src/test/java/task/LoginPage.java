package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPage extends BaseClass {
	@Test
	public void valid() {
		ExtentTest test=extent.createTest("verify the page valid data").assignAuthor("priyanka").assignCategory("functional test cases")
				.assignDevice("Windows");
		
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html"); 
        WebElement userProfile = driver.findElement(By.xpath("//div[contains(text(),\"Swag Labs\")]"));
        Assert.assertTrue(userProfile.getText().contains("Swag Labs"));
        test.pass("verify the user");
    }
@Test
//(dependsOnMethods="testEmptyFields")
public void invalid() {
	ExtentTest test=extent.createTest("verify the invalid data");

	
	//driver.get("https://www.saucedemo.com/");
	WebElement usernameField = driver.findElement(By.id("user-name")); 
    WebElement passwordField = driver.findElement(By.id("password")); 
    WebElement loginButton = driver.findElement(By.id("login-button")); 
    
    
    usernameField.sendKeys("wrong_user");
    passwordField.sendKeys("wrong_password");
    loginButton.click();

    WebElement errorMessage = driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]")); 
    String actualMessage = errorMessage.getText();
    test.fail("verify msg");

    Assert.assertEquals(actualMessage, "Epic sadface: Username and password do not match any user in this service"); 
}
@Test    
//(dependsOnMethods="valid")
public void testEmptyFields() {
    
	ExtentTest test=extent.createTest("verify the empty fields");

    WebElement usernameField = driver.findElement(By.id("username"));
    WebElement passwordField = driver.findElement(By.id("password"));
    WebElement loginButton = driver.findElement(By.id("loginButton"));

    usernameField.clear(); 
    passwordField.clear();
    loginButton.click();

    WebElement errorMessage = driver.findElement(By.className("error-button"));
    String actualMessage = errorMessage.getText();

    Assert.assertEquals(actualMessage, "Epic sadface: Username and password do not match any user in this service");
    test.info("Error msg is correct");
    };

}
	


