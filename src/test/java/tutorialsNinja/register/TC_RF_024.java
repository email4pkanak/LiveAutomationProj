package tutorialsNinja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_024 {
	
	@Test
	public void verifyEveryLinkOnRegisterPage() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
		driver.findElement(By.linkText("Qafox.com")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.navigate().back();
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Search']")).isDisplayed());
		driver.navigate().back();
		
		driver.findElement(By.xpath("//a[@class='agree']//b[text()='Privacy Policy']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement xOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']")));
		Assert.assertTrue(xOption.isDisplayed());
		xOption.click();
		
		driver.quit();
	
	}

}
