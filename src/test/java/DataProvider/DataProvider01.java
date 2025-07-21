package DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class DataProvider01 {
	public static WebDriver driver;
	
	@BeforeSuite
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
	@Test(dataProvider="data")
	public void loginFunctionality(String user, String Pass) {
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(Pass);
		driver.findElement(By.id("login")).click();
	}
	
	@org.testng.annotations.DataProvider(name="data", indices= {0,1,2,3,4})
	String [][] Logindata() {
		String data[][] = {
				{"Raghu","Raghu@123"},
				{"Anil","anwesh"},
				{"",""},
				{"Sai","Sai123"},
				{"anwesh26","anwesh26#"}
		};
		return data;
		
	}
	
	

}