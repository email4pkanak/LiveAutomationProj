package tutorialsNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {
	
	@Test
	public void verifyRegisterWithMandatoryFields() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Priyanka");
		driver.findElement(By.id("input-lastname")).sendKeys("Kanak");
		driver.findElement(By.id("input-email")).sendKeys(genarateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("test12345");
		driver.findElement(By.id("input-confirm")).sendKeys("test12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(),expectedHeading);
		
		String expectedDetailsOne = "Congratulations! Your new account has been successfully created!";
		String expectedDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedDetailsFour = "contact us";
		String actualDetails = driver.findElement(By.id("content")).getText();
		Assert.assertTrue(actualDetails.contains(expectedDetailsOne));
		Assert.assertTrue(actualDetails.contains(expectedDetailsTwo));
		Assert.assertTrue(actualDetails.contains(expectedDetailsThree));
		Assert.assertTrue(actualDetails.contains(expectedDetailsFour));
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).isDisplayed());
		
		driver.quit();
	}
	
	public String genarateEmail( ) {
		String dateString = new Date().toString();
		String noSpace = dateString.replaceAll("\\s", "");
		String finalDate = noSpace.replaceAll("\\:","");
		String email = finalDate+"@gmail.com";
		return email;
	}

}
