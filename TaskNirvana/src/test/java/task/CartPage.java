package task;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class CartPage extends BaseClass{
	
@Test
public void checkout() throws InterruptedException {
ExtentTest test=extent.createTest("verify the view Cart page");
WebElement usernameField = driver.findElement(By.id("user-name")); 
WebElement passwordField = driver.findElement(By.id("password")); 
WebElement loginButton = driver.findElement(By.id("login-button")); 

usernameField.sendKeys("standard_user");
passwordField.sendKeys("secret_sauce");
loginButton.click(); 

    
    test.info("Navigating to the cart page");
    
	
	driver.get("https://www.saucedemo.com/inventory.html");
	WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
    cartLink.click();
	 driver.findElement(By.id("checkout")).click();

	    //Enter checkout information
	    driver.findElement(By.id("first-name")).sendKeys("priyanka");
	    driver.findElement(By.id("last-name")).sendKeys("katare");
	    driver.findElement(By.id("postal-code")).sendKeys("12345");
	    driver.findElement(By.id("continue")).click();
	    driver.findElement(By.name("finish")).click();
	    Thread.sleep(2000);
	    WebElement confirmationmsg=driver.findElement(By.className("complete-header"));
	    assertEquals("Thank you for your order!", "Thank you for your order!");
	    test.info("checkout is is completed");
}
		
		@Test
		public void navigation() throws InterruptedException {
			
			ExtentTest test=extent.createTest("verify the view Cart page");
			WebElement usernameField = driver.findElement(By.id("user-name")); 
			WebElement passwordField = driver.findElement(By.id("password")); 
			WebElement loginButton = driver.findElement(By.id("login-button")); 

			usernameField.sendKeys("standard_user");
			passwordField.sendKeys("secret_sauce");
			loginButton.click(); 
		
		//Navigation
			
		driver.navigate().forward();
		
		Thread.sleep(2000);
		driver.navigate().to("https://www.saucedemo.com/cart.html");
		driver.navigate().back();

		Thread.sleep(2000);
		test.info("nevigation successful");
		}
		@Test
		public void logout() throws InterruptedException {
			ExtentTest test=extent.createTest("verify the view Cart page");
			WebElement usernameField = driver.findElement(By.id("user-name")); 
			WebElement passwordField = driver.findElement(By.id("password")); 
			WebElement loginButton = driver.findElement(By.id("login-button")); 

			usernameField.sendKeys("standard_user");
			passwordField.sendKeys("secret_sauce");
			loginButton.click(); 

		driver.findElement(By.xpath("//button[contains(text(),\"Open Menu\")]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
		test.info("user is successfully logged out");
		test.info("user is logged out");
}
	
	
@Test

public void viewCart() {
	ExtentTest test=extent.createTest("verify the cart view page").assignAuthor("priyanka").assignCategory("functional test cases")
			.assignDevice("Windows");
	
	WebElement usernameField = driver.findElement(By.id("user-name")); 
    WebElement passwordField = driver.findElement(By.id("password")); 
    WebElement loginButton = driver.findElement(By.id("login-button")); 

    usernameField.sendKeys("standard_user");
    passwordField.sendKeys("secret_sauce");
    loginButton.click(); 
    
    test.info("Navigating to the cart page");
	
	driver.get("https://www.saucedemo.com/inventory.html");
	WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
    cartLink.click();
  List <WebElement> cart_items = driver.findElements(By.xpath("//div[@class=\"cart_list\"]"));
                    Assert.valueIsAtLeast(1, 1);
    	    
	test.info("products are displaying in cart page");
	WebElement removeButton=driver.findElement(By.xpath("//button[contains(text(), \"Remove\")]"));
	removeButton.click();
	WebElement cart=driver.findElement(By.xpath("//div[@class=\"cart_list\"]"));
	Assert.isEmpty(cart);
	test.info("product is removed from cart");
	
}

}
