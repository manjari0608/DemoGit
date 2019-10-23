package Simple.SimpleTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestDragAndDrop {
	@Test
	public void testDragAndDrop() {
		System.setProperty("webdriver.chrome.driver","C:\\NexGen Testing Stream\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebElement pack = driver.findElement(By.xpath("//div[@id='ct100_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[2]/div/div/span"));
		WebElement price = driver.findElement(By.xpath(xpathExpression));
		Actions act1 = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
}
