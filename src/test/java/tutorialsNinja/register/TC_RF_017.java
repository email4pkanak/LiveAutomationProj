package tutorialsNinja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class TC_RF_017 {
	
	WebDriver driver;
	
	@AfterMethod
	public void tearDown() {
			driver.quit();
		}
	
	@Test(dataProvider = "passwordSupplier")
	public void verifyPasswordComplexitySTandards(String passwordText) {
		
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		driver.findElement(By.id("input-firstname")).sendKeys("priyanka");
		driver.findElement(By.id("input-lastname")).sendKeys("kanak");
		driver.findElement(By.id("input-email")).sendKeys(CommonMethods.generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("09878987890");
		driver.findElement(By.id("input-password")).sendKeys(passwordText);
		driver.findElement(By.id("input-confirm")).sendKeys(passwordText);
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedWarning = "Password must be between 4 and 20 characters!";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText(), expectedWarning);
				
	
	}
	
	@DataProvider(name="passwordSupplier")
	public Object[][] supplyPassword() {
		Object[][] data = {{"12345"},{"abcdefghjiuy"},{"abcd1234"},{"ABCD1234#"}};
		return data;
		
		
	}

}
