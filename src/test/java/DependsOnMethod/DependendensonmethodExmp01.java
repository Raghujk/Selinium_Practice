package DependsOnMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

public class DependendensonmethodExmp01 {
	
	public static WebDriver driver;
	public Select  sc;
	@BeforeSuite
	public void OpenApplication() {
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void loginFunctionality() {
		driver.findElement(By.id("username")).sendKeys("anwesh26");
		driver.findElement(By.id("password")).sendKeys("anwesh26#");
		driver.findElement(By.id("login")).click();
	}
	
	@Test(dependsOnMethods= {"loginFunctionality"})
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
	
	@Test(dependsOnMethods= {"searchHotel"})
	public void selectHotel() {
		driver.findElement(By.id("radiobutton_2")).click();
		driver.findElement(By.id("continue")).click();
	}
	
	@AfterSuite
	public void closeapllication() {
		driver.close();
	}

}