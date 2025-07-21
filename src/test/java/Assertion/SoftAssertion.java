package Assertion;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
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
	@Test
	public void LoginApp() {
		driver.findElement(By.id("username")).sendKeys("anwesh26");
		driver.findElement(By.id("password")).sendKeys("anwesh26#");
		driver.findElement(By.id("login")).click();
	}
	
	@Test
	public void Searchhotel() throws InterruptedException {
		String Expexted_Title = "Adactin.com - Search Hotel12";
		String Actual_Title = driver.getTitle();
		
		SoftAssert sa = new SoftAssert();
		
		if(Actual_Title.equals(Expexted_Title)) {
			sa.assertTrue(true);
			System.out.println("Testcase is passed");
		}
		else {
			sa.assertTrue(false);  //continue
			System.out.println("TestCase is failed");
		}
		
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

}