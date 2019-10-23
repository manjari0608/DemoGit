package Simple.SimpleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	@Test
	public void testCreateCard() {
		System.setProperty("webdriver.chrome.driver","C:\\NexGen Testing Stream\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://newsite.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		Actions act1 = new Actions(driver);
		act1.moveToElement((driver.findElement(By.xpath("//a[@title='Pay']")))).perform();
		driver.findElement(By.xpath("//a[@href='/personal/pay/cards/credit-cards\']")).click();
		String titlepage = driver.getTitle();
		Assert.assertEquals(titlepage.contains("Credit Cards"),true);
			
	}
	
}
