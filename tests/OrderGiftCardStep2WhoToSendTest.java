package buyme.co.il.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import buyme.co.il.pageobjects.ChefRestaurantGiftCardPage;
import buyme.co.il.pageobjects.HomePage;
import buyme.co.il.pageobjects.LoginPage;
import buyme.co.il.pageobjects.OrderGiftCardStep1ChooseGiftCardAmountPage;
import buyme.co.il.pageobjects.OrderGiftCardStep2WhoToSendPage;
import buyme.co.il.pageobjects.OrderGiftCardStep3PaymentPage;
import buyme.co.il.pageobjects.VideoStep2Page;

public class OrderGiftCardStep2WhoToSendTest extends BaseTest {

	@Test(description = "order gift card step2 - who to send info , test should succeed")
	public void GiftCardWhoToSendInfo() {
		HomePage homeP = new HomePage(driver);
		homeP.chooseYourGiftCardFromList(1);
		ChefRestaurantGiftCardPage chefRestaurantP = new ChefRestaurantGiftCardPage(driver);
		chefRestaurantP.chooseYourRestaurantGiftCardFromList(2);
		OrderGiftCardStep1ChooseGiftCardAmountPage step1P = new OrderGiftCardStep1ChooseGiftCardAmountPage(driver);
		step1P.chooseOpenGiftCardOption("400");
		OrderGiftCardStep2WhoToSendPage step2P = new OrderGiftCardStep2WhoToSendPage(driver);
		step2P.sendGiftForSomeoneAlse("ruma", "inbal", "best mom");
		step2P.clickAddVideo();
		VideoStep2Page videoP = new VideoStep2Page(driver);
		videoP.chooseYourVideoFromList(3);
		step2P.howToSendGiftCard("rumayefet@gmail.com");
		step2P.clickPaymentBTN();
		// login
		LoginPage logP = new LoginPage(driver);
		logP.login("inbalyetest@gmail.com", "Inbaltest1");
		OrderGiftCardStep3PaymentPage step3PaymentP = new OrderGiftCardStep3PaymentPage(driver);
		// should check that we able to fill all the info and forward to the next page -step3
		String expectedText = "תשלום ושליחה";
		String actualText = step3PaymentP.verifyStep3PageText();
		Assert.assertEquals(actualText, expectedText);
	}

}
