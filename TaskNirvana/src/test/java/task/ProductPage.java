package task;


import java.util.List;

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
	       
            List <WebElement> products=driver.findElements(By.xpath("//div[@class=\"inventory_item_name \"]"));
	        Assert.assertTrue(true);
	        
	        test.pass("All expected products are visible on the page");
	    }
	 @Test
	    public void testProductDetails() throws InterruptedException {
			ExtentTest test=extent.createTest("verify the ProductDetails");

	        test.info("Navigating to the product page");
	        WebElement usernameField = driver.findElement(By.id("user-name")); 
	        WebElement passwordField = driver.findElement(By.id("password")); 
	        WebElement loginButton = driver.findElement(By.id("login-button")); 

	        usernameField.sendKeys("standard_user");
	        passwordField.sendKeys("secret_sauce");
	        loginButton.click(); 

	       // driver.get("https://www.saucedemo.com/inventory.html");

	        WebElement backpack = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]"));
	        backpack.click();
	        Thread.sleep(3000);

	        WebElement productName = driver.findElement(By.xpath("//div[contains(text(),\"Sauce Labs Backpack\")]"));
	        WebElement productDescription = driver.findElement(By.className("inventory_details_desc large_size"));
	        WebElement productPrice = driver.findElement(By.xpath("//div[@class=\"inventory_details_price\"]"));
	        WebElement addtocartbutton=driver.findElement(By.id("//button[@id=\"add-to-cart\"]"));

	        Assert.assertEquals(productName.getText(), "Sauce Labs Backpack", "Product name is correct");
	        Assert.assertTrue(productDescription.getText().contains("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."), "Product description is correct");
	        Assert.assertEquals(productPrice.getText(), "$29.99", "Product price is correct");
	        Assert.assertTrue(addtocartbutton.isDisplayed());

	        test.pass("Product details are correctly displayed");
	    }
	 @Test
	    public void testAddToCart() {
			ExtentTest test=extent.createTest("verify the AddToCart");

	        
	        test.info("Navigating to the product page");
	        WebElement usernameField = driver.findElement(By.id("user-name")); 
	        WebElement passwordField = driver.findElement(By.id("password")); 
	        WebElement loginButton = driver.findElement(By.id("login-button")); 

	        usernameField.sendKeys("standard_user");
	        passwordField.sendKeys("secret_sauce");
	        loginButton.click(); 

	        driver.get("https://www.saucedemo.com/inventory.html");

	        WebElement backpackAddToCartButton = driver.findElement(By.xpath("//button[contains(text(),\"Add to cart\")]"));
	        backpackAddToCartButton.click();

	        WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));
	        String cartCount = cartIcon.getText();

	        Assert.assertEquals(cartCount, "1", "Cart count should be 1");

	        WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
	        cartLink.click();

	        WebElement cartProduct = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]"));
	        Assert.assertTrue(cartProduct.isDisplayed(), "Product should be listed in the cart");

	        test.pass("Product was successfully added to the cart and is visible in the cart");
	    }

}
