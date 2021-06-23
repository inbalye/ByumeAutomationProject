package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchGiftCardResultsPage extends BasePage {

	@FindBy(css = "div.application-main > div:nth-child(2) > h1")
	private WebElement searchResult;

	public SearchGiftCardResultsPage(WebDriver driver) {
		super(driver);
	}

	// get search gift card result text
	public String getSearchResultText() {
		return getText(searchResult);
	}

}
