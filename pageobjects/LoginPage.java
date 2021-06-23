package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	@FindBy(css = ".text-btn")
	private WebElement regBTN;
	@FindBy(css = ".lightbox-head")
	private WebElement LoginScreenText;
	@FindBy(css = "[type='email']")
	private WebElement emailField;
	@FindBy(css = "[type='password']")
	private WebElement passwordField;
	@FindBy(css = "[type='submit']")
	private WebElement submitBTN;
	@FindBy(css = ".forgot-password")
	private WebElement forgotPasswordBTN;
	@FindBy(css = ".login-error")
	private WebElement loginErrorMessage;
	@FindBy(css = ".parsley-required")
	private WebElement loginErrorMessageEmailRequired;
	@FindBy(css = ".parsley-errors-list.filled")
	private WebElement loginErrorMessagePasswordRequired;
	@FindBy(css = "[type='checkbox']")
	private WebElement rememberMeCheckbox;
	@FindBy(css = ".social-btn.facebook")
	private WebElement loginFacebookBTN;
	@FindBy(css = ".social-btn.google")
	private WebElement loginGoogleBTN;
	@FindBy(css = "#m_login_email")
	private WebElement loginEmail;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// click register button
	public void registerBTN() {
		click(regBTN);
		sleep(2000);
	}

	// get login screen text
	public String verifyLoginScreenText() {
		return getText(LoginScreenText);
	}

	// fill login fields and click submit button
	public void login(String email, String password) {
		fillText(emailField, email);
		fillText(passwordField, password);
		click(submitBTN);
		sleep(3000);
	}

	// click forgot password button
	public void forgotPasswordBTN() {
		click(forgotPasswordBTN);
	}

	// get email/password error message
	public String getLoginWrongEmailPasswordErrorMessage() {
		return getText(loginErrorMessage);
	}

	// get email required error message
	public String getLoginEmailFieldErrorMessage() {
		return getText(loginErrorMessageEmailRequired);
	}

	// get Password required error message
	public String getLoginPasswordFieldErrorMessage() {
		return getText(loginErrorMessagePasswordRequired);
	}

	// click login with facebook button
	public void loginWithFacebook() {
		click(loginFacebookBTN);
		sleep(2000);
	}

	// click login with google button
	public void loginWithGoogle() {
		click(loginGoogleBTN);
		sleep(2000);
	}

}
