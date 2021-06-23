package buyme.co.il.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import buyme.co.il.pageobjects.ChefRestaurantGiftCardPage;
import buyme.co.il.pageobjects.HomePage;

public class ChooseGiftCardTest extends BaseTest {

	@Test(description = "choose Chef Restaurant Gift Card, test should succeed")
	public void chooseGiftCard() {
		HomePage homeP = new HomePage(driver);
		homeP.chooseYourGiftCardFromList(1);
		ChefRestaurantGiftCardPage chefRestaurantP = new ChefRestaurantGiftCardPage(driver);
		// should check that we get the right result text
		String expectedText = "בחרת גיפט קארד למסעדות שף";
		String actualText = chefRestaurantP.getGiftCardsResultText();
		Assert.assertEquals(actualText, expectedText);
	}

}
