package Assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class Hard_Assertion {
	public static WebDriver driver;
	public Select sc;
	@BeforeClass
	@Parameters({"browser", "URL"})
	public void openApp(String br, String url) {
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
		driver.findElement(By.id("username")).sendKeys("anwesh26");
		driver.findElement(By.id("password")).sendKeys("anwesh26#");
		driver.findElement(By.id("login")).click();
	}
	@Test(priority=2)
	public void SearchHotel() throws InterruptedException {
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
	@Test(priority=3)
	public void verifySelectHotel() {
		String Expected_Title = "Adactin.com - Select Hotel12";
		String Actual_Title = driver.getTitle();
		
		if(Expected_Title.equals(Actual_Title)) {
			Assert.assertTrue(true);
			System.out.println("TestCase is passed");
		}else {
			System.out.println("The TestCase is failed");
			Assert.assertTrue(false);	//break
			
		}
		
		driver.findElement(By.id("radiobutton_2")).click();
		driver.findElement(By.id("continue")).click();
	
	}
	@Test(priority=4)
	public void BookAHotel() {
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Anil");
		driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//*[@id='address']")).sendKeys("f.no:-090,road no:-1, Hyd,500123");
		driver.findElement(By.xpath("//*[@id='cc_num']")).sendKeys("1234567891234568");
		
		WebElement CCType = driver.findElement(By.xpath("//*[@id='cc_type']"));
		sc = new Select(CCType);
		
		sc.selectByIndex(2);
		
		WebElement ExpDatestart = driver.findElement(By.xpath("//*[@id='cc_exp_month']"));
		sc = new Select(ExpDatestart);
		sc.selectByValue("3");
		
		WebElement ExpDateEnd =  driver.findElement(By.xpath("//*[@id='cc_exp_year']"));
		sc = new Select(ExpDateEnd);
		sc.selectByIndex(2);
		
		WebElement cvvnum = driver.findElement(By.xpath("//*[@id='cc_cvv']"));
		cvvnum.sendKeys("123");
		
		driver.findElement(By.id("book_now")).click();
		
	}
}