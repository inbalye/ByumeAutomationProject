package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	@FindBy(css = ".page-title")
	private WebElement myAccountScreenText;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// get my account screen text
	public String verifyMyAccountScreenText() {
		return getText(myAccountScreenText);
	}

}
