package Annotations;


import org.testng.annotations.*;


public class AnnotationsExamp01 {

	@BeforeSuite
	public void m1() {
		System.out.println("M1,Before suite has executed");
	}
	 @AfterSuite	
	public void m2() {
		System.out.println("M2,After suite has executed");
	}
	@BeforeTest
	public void m3() {
		System.out.println("M3,Before Test has executed");
	}
	@AfterTest
	public void m4() {
		System.out.println("M4,After Test has executed");
	}
	
	@BeforeClass
	public void m5() {
		System.out.println("M5,Before class has executed");
	}
	@AfterClass
	public void m6() {
		System.out.println("M6,After class has executed");
	}
	
	@BeforeMethod
	public void m7() {
		System.out.println("M7,Before Method has executed");
	}
	
	@AfterMethod
	public void m8() {
		System.out.println("M8,After Method has executed");
	}
	
	@Test
	public void m9() {
		System.out.println("M9,Test has executed");
	}
}