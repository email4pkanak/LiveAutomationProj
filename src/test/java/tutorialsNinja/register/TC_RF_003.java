package tutorialsNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class TC_RF_003 {

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
			driver.findElement(By.id("input-email")).sendKeys(CommonMethods.generateNewEmail());
			driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
			driver.findElement(By.id("input-password")).sendKeys("test12345");
			driver.findElement(By.id("input-confirm")).sendKeys("test12345");
			driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
			driver.findElement(By.name("agree")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();

	}

}
