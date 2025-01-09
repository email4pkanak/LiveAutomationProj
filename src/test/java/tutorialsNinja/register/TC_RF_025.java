package tutorialsNinja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_025 {
	
	@Test
	public void verifyPageDetails() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		
		String expectedHeading = "Register Account";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='col-sm-9']//h1[text()='Register Account']")).getText(), expectedHeading);
		
		String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/register";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		
		String expectedTitle = "Register Account";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		
		driver.quit();
	}

}
