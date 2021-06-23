package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessEntryPage extends BasePage {

	@FindBy(css = "#login > p.login-page-tagline")
	private WebElement businessEntryScreenText;

	public BusinessEntryPage(WebDriver driver) {
		super(driver);
	}

	// get business entry screen title text
	public String verifyBusinessEntryScreenTitleText() {
		return getText(businessEntryScreenText);
	}

	// move to business entry window
	@Override
	public void moveToNewWindow() {
		super.moveToNewWindow();
	}

	// close business entry screen and beck to the main window
	@Override
	public void closeWindowAndBackToMainWindow() {
		super.closeWindowAndBackToMainWindow();
	}

}
