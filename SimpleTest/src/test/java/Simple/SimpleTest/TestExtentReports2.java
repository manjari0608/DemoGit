package Simple.SimpleTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestExtentReports2 {
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void beforeTest() {
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-ms");
		
		String filePath = System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html";
		reporter = new ExtentHtmlReporter(filePath);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}
	 @AfterTest
	  public void afterTest() {
		 reports.flush();
	  }
	 @BeforeMethod
	 public void beforeMethod(ITestResult result) {
		 
		 test = reports.createTest(result.getMethod().getMethodName());
	  }
	 @AfterMethod
	 public void afterMethod(ITestResult result) {
		 if(result.getStatus()==ITestResult.SUCCESS) {
			 test.log(Status.PASS,"The "+result.getMethod().getMethodName()+" is passed");
		 }
		 else if(result.getStatus()==ITestResult.FAILURE) {
			 test.log(Status.FAIL,"The "+result.getMethod().getMethodName()+" is failed");
			 TakesScreenshot ts = (TakesScreenshot) driver;
			 File srcFile = ts.getScreenshotAs(OutputType.FILE);
			 String destFile = System.getProperty("user.dir")+"/extent-reports/screenshots/"+result.getMethod()+".png";
			 FileUtils.copyFile(srcFile, new File(destFile));
			 test.addScreenCaptureFromPath(destFile,"Demo web shop");
			 test.log(Status.FAIL, result.getThrowable().getMessage());
		 }
		 else if(result.getStatus()==ITestResult.SKIP) {
			 
			 test.log(Status.SKIP,"The "+result.getMethod().getMethodName()+" is skiped");
			 String data[][]= {{"uname","pwd"},{"kim","kim"}};
			 test.log(Status.SKIP, MarkupHelper.createTable(data));
		 }
	  }
	 @Test
	  public void testDemoWebShopLogin() {
		  
		  driver.get("http://demowebshop.tricenties.com/logon");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  }
	 @Test
	  public void testPass() {
		  
		  Assert.assertTrue(true);
	  }
	 @Test
	  public void testFail() {
		 
		  Assert.assertTrue(false);
	  }
	 @Test
	  public void testSkip() {
		  
		  throw new SkipException("Skipped");
	  }

}
