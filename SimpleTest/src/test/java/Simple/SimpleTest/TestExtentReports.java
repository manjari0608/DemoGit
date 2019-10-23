package Simple.SimpleTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestExtentReports {
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void beforeTest() {
		
				
		String filePath = System.getProperty("user.dir")+"/extent-reports/report.html";
		
		reporter = new ExtentHtmlReporter(filePath);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}
	 @AfterTest
	  public void afterTest() {
		 reports.flush();
	  }
	 @Test
	  public void testPass() {
		  test = reports.createTest("Test Pass");
		  test.log(Status.PASS, "Passed");
		  Assert.assertTrue(true);
	  }
	 @Test
	  public void testFail() {
		  test = reports.createTest("Test Fail");
		  test.log(Status.PASS, "Failed");
		  Assert.assertTrue(false);
	  }
	 @Test
	  public void testSkip() {
		  test = reports.createTest("Test Skip");
		  test.log(Status.PASS, "Skiped");
		  throw new SkipException("Skipped");
	  }

}
