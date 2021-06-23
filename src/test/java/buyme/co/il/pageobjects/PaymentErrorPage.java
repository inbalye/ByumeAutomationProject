package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentErrorPage extends BasePage {

	@FindBy(css = ".title--sm> span:nth-child(1)")
	private WebElement paymentErrorMSg;

	public PaymentErrorPage(WebDriver driver) {
		super(driver);
	}

	// get payment error message
	public String getPaymentErrorMSg() {
		return getText(paymentErrorMSg);
	}

}
