package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BaseClass {
	@Test
	public void lauch() {
		driver.get(baseUrl);
		
		WebElement usernameField = driver.findElement(By.id("user-name")); 
        WebElement passwordField = driver.findElement(By.id("password")); 
        WebElement loginButton = driver.findElement(By.id("login-button")); 

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click(); 
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html"); 
        WebElement userProfile = driver.findElement(By.className("//div[@class=\"app_logo\"]")); 
        Assert.assertTrue(userProfile.getText().contains("Swag Labs"));
    }

	}
	


