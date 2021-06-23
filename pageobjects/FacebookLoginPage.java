package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLoginPage extends BasePage {

	@FindBy(css = "#m_login_email")
	private WebElement emailField;
	@FindBy(css = "#m_login_password")
	private WebElement passwordField;
	@FindBy(css = "[type='button']")
	private WebElement loginBTN;

	public FacebookLoginPage(WebDriver driver) {
		super(driver);
	}

	// move to facebook login window
	@Override
	public void moveToNewWindow() {
		super.moveToNewWindow();
	}

	// fill login fields and click login button
	public void loginFacebook(String email, String password) {
		fillText(emailField, email);
		fillText(passwordField, password);
		click(loginBTN);
		sleep(2000);
	}

	// move beck to the main window
	@Override
	public void moveBackToMainWindow() {
		super.moveBackToMainWindow();
	}

}
