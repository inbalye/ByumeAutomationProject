package buyme.co.il.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import buyme.co.il.pageobjects.ChefRestaurantGiftCardPage;
import buyme.co.il.pageobjects.HomePage;
import buyme.co.il.pageobjects.OrderGiftCardStep1ChooseGiftCardAmountPage;
import buyme.co.il.pageobjects.OrderGiftCardStep2WhoToSendPage;

public class OrderGiftCardStep1ChooseGiftCardAmountTest extends BaseTest {

	@Test(description = "order gift card step1 - Choose Gift Card and fill the amount, test should succeed")
	public void fillGiftCardAmount() {
		HomePage homeP = new HomePage(driver);
		homeP.chooseYourGiftCardFromList(1);
		ChefRestaurantGiftCardPage chefRestaurantP = new ChefRestaurantGiftCardPage(driver);
		chefRestaurantP.chooseYourRestaurantGiftCardFromList(2);
		OrderGiftCardStep1ChooseGiftCardAmountPage step1P = new OrderGiftCardStep1ChooseGiftCardAmountPage(driver);
		step1P.chooseOpenGiftCardOption("400");
		OrderGiftCardStep2WhoToSendPage step2P = new OrderGiftCardStep2WhoToSendPage(driver);
		// should check that after we fill the amount we able to forward to the next page - step2
		String expectedText = "למי לשלוח";
		String actualText = step2P.verifyStep2PageText();
		Assert.assertEquals(actualText, expectedText);
	}

}
