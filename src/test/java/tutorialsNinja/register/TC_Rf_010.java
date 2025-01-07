package tutorialsNinja.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_Rf_010 {
	
	@Test
	public void verifyNotificationWarningMessage() throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Priyanka");
		driver.findElement(By.id("input-lastname")).sendKeys("Kanak");
		driver.findElement(By.id("input-email")).sendKeys("test");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("test12345");
		driver.findElement(By.id("input-confirm")).sendKeys("test12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		Thread.sleep(3000);
		
		//Taking screenshot
		File srcScreenshot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		//Copy Screenshot to screenshot folder in eclipse
		FileHandler.copy(srcScreenshot1, new File(System.getProperty("user.dir")+"\\Screenshots\\scActual.png"));
		
		Assert.assertFalse(compareScreenshots(System.getProperty("user.dir")+"\\Screenshots\\scActual.png",System.getProperty("user.dir")+"\\Screenshots\\scExpected.png"));
		
		driver.quit();
	}
	public boolean compareScreenshots(String actulaImagePath,String expectedImagePath) throws IOException {
		//Reading Image as buffer image
				BufferedImage actualBImg = ImageIO.read(new File(actulaImagePath));
				BufferedImage expectedBImg = ImageIO.read(new File(expectedImagePath));
				
				//Checking the difference
				ImageDiffer imgDiffer = new ImageDiffer();
				ImageDiff imgDifference = imgDiffer.makeDiff(expectedBImg, actualBImg);
				
				//Verify it is coming as false
				boolean b = imgDifference.hasDiff();
				System.out.println(b);
				
				//comparing the value
				return imgDifference.hasDiff();
				
	}

}
