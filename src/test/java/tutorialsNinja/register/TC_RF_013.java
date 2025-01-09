package tutorialsNinja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_RF_013 {
	
	@SuppressWarnings("deprecation")
	@Test
	public void verifyPlaceholdersRegisterPage() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String expectedFNamePlaceHolder = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getDomAttribute("placeholder"),expectedFNamePlaceHolder);
		
		String expectedLNamePlaceholder = "Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"),expectedLNamePlaceholder);
		
		String expectedEmailPlaceholoder = "E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"),expectedEmailPlaceholoder);
		
		String expectedPhonePlaceholder = "Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"),expectedPhonePlaceholder);
		
		String expectedPasswordPlaceholder = "Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"),expectedPasswordPlaceholder);
		
		String expectedConfirmPasswordPlaceholder = "Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"),expectedConfirmPasswordPlaceholder);
		
		driver.quit();
	}

}
