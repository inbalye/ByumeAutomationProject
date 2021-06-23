package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderGiftCardStep1ChooseGiftCardAmountPage extends BasePage {

	@FindBy(css = ".page-title.page-title--padded")
	private WebElement searchResult;
	@FindBy(css = "[placeholder='од дслен?']")
	private WebElement giftCardAmount;
	@FindBy(css = "div.card-bottom.clearfix > div > button")
	private WebElement submitBTN;

	public OrderGiftCardStep1ChooseGiftCardAmountPage(WebDriver driver) {
		super(driver);
	}

	public String getSearchResult() {
		return getText(searchResult);
	}

	// choose Open Gift Card, fill the amount and click submit button
	public void chooseOpenGiftCardOption(String amount) {
		fillText(giftCardAmount, amount);
		click(submitBTN);
		sleep(4000);
	}

}
