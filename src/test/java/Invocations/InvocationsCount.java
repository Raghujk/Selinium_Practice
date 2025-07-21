package Invocations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class InvocationsCount {
	public static WebDriver driver;
	public Select  sc;
	
	@BeforeSuite
	@Parameters({"browser","URL"})
	public void OpenApplication(String br, String url) {
		
		if(br.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else if(br.equals("FireFox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
	
	@Test(invocationCount=3)
	public void loginFunctionality() {
		driver.findElement(By.id("username")).sendKeys("anwesh26");
		driver.findElement(By.id("password")).sendKeys("anwesh26#");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.findElement(By.linkText("Click here to login again")).click();
	}
	
	@AfterSuite
	public void close() {
		driver.close();
	}

}