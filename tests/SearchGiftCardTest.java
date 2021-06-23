package buyme.co.il.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import buyme.co.il.pageobjects.HomePage;
import buyme.co.il.pageobjects.SearchGiftCardResultsPage;

public class SearchGiftCardTest extends BaseTest {

	@Test(description = "search Gift Card, test should succeed")
	public void searchGiftCardByMountAreaCategory() {
		HomePage homeP = new HomePage(driver);
		homeP.searchGiftCard();
		SearchGiftCardResultsPage resultP = new SearchGiftCardResultsPage(driver);
		// should check that we get the right search result text
		String expectedText = "50 ������ ����� �200-299 �\"�, �\"� �������, ���� ���� ������� ��";
		String actualText = resultP.getSearchResultText();
		Assert.assertEquals(actualText, expectedText);
	}

}
