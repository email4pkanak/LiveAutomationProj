package tutorialsNinja.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_RF_027 {
	
	@Test(dataProvider = "environmentSupplier")
	public void verifyRegisterAccountInAllBrowser(String env) {
		
		String browserName = env;
		WebDriver driver = null;
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();	
		
		driver.quit();
		
	}
	@DataProvider(name="environmentSupplier")
	public Object[][] passBrowsers() {
		Object[][] env = {{"chrome"},{"firefox"},{"edge"}};
		return env;
		
	}
	

}
