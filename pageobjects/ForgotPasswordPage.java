package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

	@FindBy(css = ".form-control.input-theme.input-mail.rtl-input.ember-view.ember-text-field")
	private WebElement emailField;
	@FindBy(css = ".btn.btn-theme.modal-btn")
	private WebElement sendBTN;
	@FindBy(css = "div.with-space > span:nth-child(1)")
	private WebElement forgotPasswordScreenText;
	@FindBy(css = ".icon-times")
	private WebElement closeWindow;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}

	// fill email to receive email with password
	public void sendMeEmailWithPassword(String email) {
		fillText(emailField, email);
		click(sendBTN);
		sleep(2000);
	}

	// get forgot password screen text
	public String verifyForgotPasswordScreenText() {
		return getText(forgotPasswordScreenText);
	}

	// click close window
	public void closeWindow() {
		click(closeWindow);
	}

}
