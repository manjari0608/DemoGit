package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPageDemoWebShop {
	WebDriver driver;
	@FindBy(id="gender-male")
	WebElement gender;
	@FindBy(id="FirstName")
	WebElement firstName;
	@FindBy(id="LastName")
	WebElement lastName;
	@FindBy(id="Email")
	WebElement email;
	@FindBy(how = How.ID,using = "Password")
	WebElement password;
	@FindBy(id="ConfirmPassword")
	WebElement confirmPassword;
	@FindBy(name = "register-button")
	WebElement register;
	public RegisterPageDemoWebShop(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void registerInfo()
	{
		gender.click();
		firstName.sendKeys("abc");
		lastName.sendKeys("xyz");
		email.sendKeys("askmail@test.com");
		password.sendKeys("abc123");
		confirmPassword.sendKeys("abc123");
		register.click();
	}

}
