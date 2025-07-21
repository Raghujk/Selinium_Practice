package ExtentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Adactin_report implements ITestListener {
	
	public ExtentSparkReporter report;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext tr) {
		report =new ExtentSparkReporter("C:\\Users\\admin\\eclipse-workspace\\TeamTesting38\\Reportes\\Adactin_Report.html");
		report.config().setDocumentTitle("Adactin Report");
		report.config().setReportName("Adactin Login-Serach_Hotel Validation Test");
		report.config().setTheme(Theme.DARK);
		
		extent =new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("User Name", "Raghu Prasad D");
		extent.setSystemInfo("HostName", "Local Host");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA");
		
	}
	public void onTestSuccess(ITestResult tr) {
		test =extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		
	}
	public void onTestFailure(ITestResult tr) {
		test =extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
 
}
	public void onTestSkip(ITestResult tr) {
		test =extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREY));
		}
	public void onFinish(ITestContext tr) {
		extent.flush();
	}
}
