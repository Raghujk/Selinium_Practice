package parallelTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.*;

public class LumaApp {
	public static WebDriver driver;
	@BeforeTest
	@Parameters({"browser", "URL"})
	public void openApplication(String br, String url) {
		if(br.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("Edge")) {
			driver = new EdgeDriver();
		}
		
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}
	@Test(priority=1)
	public void loginFunctionality() {
		driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
		driver.findElement(By.id("email")).sendKeys("Anwesh123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("anwesh@123");
		driver.findElement(By.id("send2")).click();
	}
	@Test(priority=2)
	public void LogoutFunctionality()
	{
		driver.findElement(By.xpath("(//*[@class='action switch'])[1]")).click();
		driver.findElement(By.xpath("(//*[@class='authorization-link'])[1]")).click();
	}
	@Test(priority=3)
	public void reloginFunctionality() {
		driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
		driver.findElement(By.id("email")).sendKeys("Anwesh123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("anwesh123");
		driver.findElement(By.id("send2")).click();
	}
	@AfterTest
	public void closeApplication() {
		driver.close();
	}
}