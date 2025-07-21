package Annotations;

import org.testng.annotations.*;

public class AnnotationsExamp02 {
	
	
	@Test
	public void Login() {
		System.out.println("The Login is done");
	}
	
	@Test
	public void SearchF() {
		System.out.println("The search is done");
	}
	
	@BeforeTest
	public void OpenApp() {
		System.out.println("Application has opened successfully");
	}
	
	@Test
	public void Select() {
		System.out.println("The select is done");
	}
	@AfterTest
	public void Logout() {
		System.out.println("The Logout is done");
	}

}