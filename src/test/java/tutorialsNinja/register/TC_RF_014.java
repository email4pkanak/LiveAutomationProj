package tutorialsNinja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class TC_RF_014 {
	
	@Test
	public void verifyAsterikRedColor( ) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";
		
		WebElement firstnameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		String fNContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", firstnameLabel);
		System.out.println(fNContent);
		
		String fNColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", firstnameLabel);
		System.out.println(fNColor);
		
		Assert.assertEquals(fNContent, expectedContent);
		Assert.assertEquals(fNColor, expectedColor);
		
		driver.quit();
		
		
	}

}
