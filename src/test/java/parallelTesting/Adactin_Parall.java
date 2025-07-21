package parallelTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;


public class Adactin_Parall {
	
public static WebDriver driver;
	public Select sc;
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
	public void LoginFunctionality() {
		driver.findElement(By.id("username")).sendKeys("anwesh26");
		driver.findElement(By.id("password")).sendKeys("anwesh26#");
		driver.findElement(By.id("login")).click();
		
	}
	
	@Test(priority=2)
	public void searchHotel() throws InterruptedException {
		WebElement location = driver.findElement(By.id("location"));
		sc = new Select(location);
		sc.selectByIndex(3);
		
		WebElement noofrooms = driver.findElement(By.id("room_nos"));
		sc = new Select(noofrooms);
		sc.selectByIndex(2);
		
		
		driver.findElement(By.xpath("//*[@id='datepick_in']")).sendKeys("28/06/2025");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='datepick_out']")).sendKeys("30/06/2025");
		
		driver.findElement(By.xpath("//*[@id='Submit']")).click();
	}
	
	@AfterTest
	public void closeApplication()
	{
		driver.close();
	}
	
}