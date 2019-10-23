package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageDemoWebShop {
	WebDriver driver;
	@FindBy(how = How.ID,using = "Email")
	WebElement email;
	@FindBy(how = How.ID,using = "Password")
	WebElement password;
	@FindBy(how = How.LINK_TEXT,using = "Forgot password?")
	WebElement forgotPassword;
	@FindBy(how = How.CSS,using = "input[value='Log in']")
	WebElement loginButton;
	public LoginPageDemoWebShop(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void loginInfo()
	{
		email.sendKeys("askmail29@email.com");
		password.sendKeys("abc123");
		loginButton.click();
	}
}
