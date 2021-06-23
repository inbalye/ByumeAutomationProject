package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCardBalanceCheckPage extends BasePage {

	@FindBy(css = "div.text > p")
	private WebElement GiftCardBalanceCheckScreenText;

	public GiftCardBalanceCheckPage(WebDriver driver) {
		super(driver);
	}

	// get gift card balance check screen title text
	public String verifyGiftCardBalanceCheckScreenText() {
		return getText(GiftCardBalanceCheckScreenText);
	}

}
