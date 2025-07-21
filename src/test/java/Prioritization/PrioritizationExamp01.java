package Prioritization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class PrioritizationExamp01 {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void OpenApplication() {
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=2)
	public void loginFunctionality() {
		driver.findElement(By.id("username")).sendKeys("anwesh26");
		driver.findElement(By.id("password")).sendKeys("anwesh26#");
		driver.findElement(By.id("login")).click();
	}
	
	@Test(priority=1)
	public void Registration() {
		driver.findElement(By.xpath("//*[text()='New User Register Here']")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Anil");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("anil01");
		
		driver.navigate().back();
	}
	
	@AfterSuite
	public void closeApplication() {
		driver.close();
	}
	
	@Test(priority=3)
	public void searchHotel() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='datepick_in']")).sendKeys("28/06/2025");
		Thread.sleep(3000);
	}

}