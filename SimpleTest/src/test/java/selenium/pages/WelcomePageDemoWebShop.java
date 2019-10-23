package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePageDemoWebShop {
	WebDriver driver;
	@FindBy(how = How.LINK_TEXT,using = "Register") 
	WebElement registerLink;
	@FindBy(how = How.LINK_TEXT,using = "Log in")
	WebElement loginLink;
	
	
	public WelcomePageDemoWebShop(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public String clickRegisterLink()
	{
		registerLink.click();
		return driver.getTitle();
	}

	public String clickLoginLink()
	{
		loginLink.click();
		return driver.getCurrentUrl();
	}

}
