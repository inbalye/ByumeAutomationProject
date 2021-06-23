package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	@FindBy(css = "[placeholder='שם פרטי']")
	private WebElement nameField;
	@FindBy(css = "[type='email']")
	private WebElement emailField;
	@FindBy(css = "[type='password']")
	private WebElement passwordField;
	@FindBy(css = "[placeholder='אימות סיסמה']")
	private WebElement passwordVerificationField;
	@FindBy(css = "div.confirmTerms.ember-view.ui-field.ui-checkbox > label > i")
	private WebElement agreeRadioBTN;
	@FindBy(css = "[type='submit']")
	private WebElement registrationSubmitBTN;
	@FindBy(css = ".parsley-errors-list.filled > li")
	private WebElement nameRequiredErrorMessage;
	@FindBy(css = ".login-error")
	private WebElement invalidNameErrorMessage;
	@FindBy(css = ".parsley-errors-list.filled > li")
	private WebElement mailRequiredErrorMessage;
	@FindBy(css = ".parsley-errors-list.filled > li")
	private WebElement invalidEmailErrorMessage;
	@FindBy(css = ".parsley-errors-list.filled > li")
	private WebElement passwordRequiredErrorMessage;
	@FindBy(css = ".login-error")
	private WebElement invalidPasswordErrorMessage;
	@FindBy(css = ".parsley-errors-list.filled > li")
	private WebElement passwordVerificationRequiredErrorMessage;
	@FindBy(css = ".login-error")
	private WebElement emailAlreadyExistsInTheSystemErrorMessage;
	@FindBy(css = ".lightbox-close>span")
	private WebElement closeRegistrationWindow;

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	// fill registration fields, click agree button and registration submit button
	public void fillRegistrationFields(String name, String email, String password, String passwordVerification) {
		fillText(nameField, name);
		fillText(emailField, email);
		fillText(passwordField, password);
		fillText(passwordVerificationField, passwordVerification);
		//click(agreeRadioBTN);
		click(registrationSubmitBTN);
		sleep(2000);
	}

	// click to close registration window
	public void closeRegistrationWindow() {
		click(closeRegistrationWindow);
		sleep(2000);
	}

	// get name required error message
	public String getRegistrationNameRequiredErrorMessage() {
		return getText(nameRequiredErrorMessage);
	}

	// get invalid name error message
	public String getRegistrationInvalidNameErrorMessage() {
		return getText(invalidNameErrorMessage);
	}

	// get mail required error message
	public String getRegistrationMailRequiredErrorMessage() {
		return getText(mailRequiredErrorMessage);
	}

	// get invalid mail error message
	public String getRegistrationInvalidEMailErrorMessage() {
		return getText(invalidEmailErrorMessage);
	}

	// get password required error message
	public String getRegistrationPasswordRequiredErrorMessage() {
		return getText(passwordRequiredErrorMessage);
	}

	// get invalid password error message
	public String getRegistrationInvalidPasswordErrorMessage() {
		return getText(invalidPasswordErrorMessage);
	}

	// get password verification required error message
	public String getRegistrationPasswordVerificationRequiredErrorMessage() {
		return getText(passwordVerificationRequiredErrorMessage);
	}

	// get email already exists error message
	public String getRegistrationEmailAlreadyExistsInTheSystemErrorMessage() {
		return getText(emailAlreadyExistsInTheSystemErrorMessage);
	}

}
