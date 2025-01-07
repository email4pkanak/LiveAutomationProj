package tutorialsNinja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class TC_RF_011 {
	
	WebDriver driver = new ChromeDriver();
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void verifyInvalidPhone() {
		
		
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Priyanka");
		driver.findElement(By.id("input-lastname")).sendKeys("Kanak");
		driver.findElement(By.id("input-email")).sendKeys(CommonMethods.generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1");
		driver.findElement(By.id("input-password")).sendKeys("test12345");
		driver.findElement(By.id("input-confirm")).sendKeys("test12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='text-danger']")).isDisplayed());
	}

}
