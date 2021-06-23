package buyme.co.il.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChefRestaurantGiftCardPage extends BasePage {

	@FindBy(css = "div.application-main > div:nth-child(2) > h1")
	private WebElement GiftCardResultText;
	@FindBy(css = ".card-item.ember-view")
	private List<WebElement> giftCardList;

	public ChefRestaurantGiftCardPage(WebDriver driver) {
		super(driver);
	}

	// get gift cards result text
	public String getGiftCardsResultText() {
		return getText(GiftCardResultText);
	}

	// choose your restaurant gift card
	public void chooseYourRestaurantGiftCardFromList(int pos) {
		click(giftCardList.get(pos));
		sleep(2000);
	}

}
