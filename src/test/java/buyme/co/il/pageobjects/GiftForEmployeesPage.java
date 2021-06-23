package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftForEmployeesPage extends BasePage {

	@FindBy(css = "h3.f-xxl.bold")
	private WebElement GiftForEmployeesScreenText;
	
	

	public GiftForEmployeesPage(WebDriver driver) {
		super(driver);
	}

	// get gift for employees screen title text
	public String verifyGiftForEmployeesScreenTitleText() {
		return getText(GiftForEmployeesScreenText);
	}

	// move to gift for employees window
	@Override
	public void moveToNewWindow() {
		super.moveToNewWindow();
	}

	// close gift for employees screen and beck to the main window
	@Override
	public void closeWindowAndBackToMainWindow() {
		super.closeWindowAndBackToMainWindow();
	}

}
