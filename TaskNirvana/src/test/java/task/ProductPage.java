package task;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class ProductPage extends BaseClass {
    
	
	 @Test
	    public void testProductVisibility() {
			ExtentTest test=extent.createTest("verify the ProductVisibility");

	        
	        test.info("Navigating to the product page after login");
	        WebElement usernameField = driver.findElement(By.id("user-name")); 
	        WebElement passwordField = driver.findElement(By.id("password")); 
	        WebElement loginButton = driver.findElement(By.id("login-button")); 

	        usernameField.sendKeys("standard_user");
	        passwordField.sendKeys("secret_sauce");
	        loginButton.click();

	        WebElement backpack = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]"));
	        WebElement bikeLight = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Bike Light')]"));

	        Assert.assertTrue(backpack.isDisplayed(), "Sauce Labs Backpack should be visible");
	        Assert.assertTrue(bikeLight.isDisplayed(), "Sauce Labs Bike Light should be visible");
	        
	        test.pass("All expected products are visible on the page");
	    }
	 @Test
	    public void testProductDetails() {
			ExtentTest test=extent.createTest("verify the ProductDetails");

			WebElement usernameField = driver.findElement(By.id("user-name")); 
	        WebElement passwordField = driver.findElement(By.id("password")); 
	        WebElement loginButton = driver.findElement(By.id("login-button")); 

	        usernameField.sendKeys("standard_user");
	        passwordField.sendKeys("secret_sauce");
	        loginButton.click();
	        test.info("Navigating to the product page");

	        driver.get("https://www.saucedemo.com/inventory.html");

	        WebElement backpack = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]"));
	        backpack.click();

	        WebElement productName = driver.findElement(By.className("product_name"));
	        WebElement productDescription = driver.findElement(By.className("product_description"));
	        WebElement productPrice = driver.findElement(By.className("product_price"));

	        Assert.assertEquals(productName.getText(), "Sauce Labs Backpack", "Product name is incorrect");
	        Assert.assertTrue(productDescription.getText().contains("A red backpack with a variety of features"), "Product description is incorrect");
	        Assert.assertEquals(productPrice.getText(), "$29.99", "Product price is incorrect");

	        test.pass("Product details are correctly displayed");
	    }
	 @Test
	    public void testAddToCart() {
			ExtentTest test=extent.createTest("verify the AddToCart");

	        
	        test.info("Navigating to the product page");

	        driver.get("https://www.saucedemo.com/inventory.html");

	        WebElement backpackAddToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
	        backpackAddToCartButton.click();

	        WebElement cartIcon = driver.findElement(By.className("shopping_cart_badge"));
	        String cartCount = cartIcon.getText();

	        Assert.assertEquals(cartCount, "1", "Cart count should be 1");

	        WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
	        cartLink.click();

	        WebElement cartProduct = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]"));
	        Assert.assertTrue(cartProduct.isDisplayed(), "Product should be listed in the cart");

	        test.pass("Product was successfully added to the cart and is visible in the cart");
	    }

}
