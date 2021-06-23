package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleLoginPage extends BasePage {

	@FindBy(css = "[type='email']")
	private WebElement emailField;
	@FindBy(css = "#identifierNext")
	private WebElement nextBTN;
	@FindBy(css = "[type='password']")
	private WebElement passwordField;
	@FindBy(css = "#passwordNext")
	private WebElement passwordNextBTN;

	public GoogleLoginPage(WebDriver driver) {
		super(driver);
	}

	// move to google login window
	@Override
	public void moveToNewWindow() {
		super.moveToNewWindow();
	}

	// fill email field and click next button
	public void loginGoogleStep1(String email) {
		fillText(emailField, email);
		click(nextBTN);
		sleep(2000);
	}

	// fill password field and click next button
	public void loginGoogleStep2(String password) {
		fillText(passwordField, password);
		click(passwordNextBTN);
		sleep(2000);
	}

	// move beck to the main window
	@Override
	public void moveBackToMainWindow() {
		super.moveBackToMainWindow();
	}

}
