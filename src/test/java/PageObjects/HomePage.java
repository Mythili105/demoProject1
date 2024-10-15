package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage  {
  
	public HomePage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span")  WebElement dropclick;

@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a") WebElement Logout;

public void dropdown() {
	dropclick.click();
}
public void logout() {
	Logout.click();
	
}

}
