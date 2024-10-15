package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="username") WebElement UserID;
	@FindBy(name="password") WebElement Passwd;
	@FindBy(css="button[type=\"submit\"]") WebElement Login;
	
	public void Username(String UserId) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(UserID));
	    UserID.sendKeys(UserId);
		

	}
	public void Password(String Password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(Passwd));
		Passwd.sendKeys(Password);
	}
	public void clicklogin() {
		Login.click();
		
	}
	
	
	
	
	
}


