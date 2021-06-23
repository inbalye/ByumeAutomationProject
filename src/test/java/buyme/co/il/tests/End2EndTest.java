package buyme.co.il.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import buyme.co.il.pageobjects.ChefRestaurantGiftCardPage;
import buyme.co.il.pageobjects.HomePage;
import buyme.co.il.pageobjects.LoginPage;
import buyme.co.il.pageobjects.OrderGiftCardStep1ChooseGiftCardAmountPage;
import buyme.co.il.pageobjects.OrderGiftCardStep2WhoToSendPage;
import buyme.co.il.pageobjects.OrderGiftCardStep3PaymentPage;
import buyme.co.il.pageobjects.PaymentErrorPage;


public class End2EndTest extends BaseTest {

	@Test(description = "End-to-End test - a complete scenario, test should succeed")
	public void end2End() {
		HomePage homeP = new HomePage(driver);
		homeP.clickRegLogBTN();
		LoginPage logP = new LoginPage(driver);
		logP.login("inbalyetest@gmail.com", "Inbaltest1");
		homeP.chooseYourGiftCardFromList(1);
		ChefRestaurantGiftCardPage chefRestaurantP = new ChefRestaurantGiftCardPage(driver);
		chefRestaurantP.chooseYourRestaurantGiftCardFromList(2);
		OrderGiftCardStep1ChooseGiftCardAmountPage step1P = new OrderGiftCardStep1ChooseGiftCardAmountPage(driver);
		step1P.chooseOpenGiftCardOption("400");
		OrderGiftCardStep2WhoToSendPage step2P = new OrderGiftCardStep2WhoToSendPage(driver);
		step2P.sendGiftForSomeoneAlse("ruma", "inbal", "best mom");
		step2P.howToSendGiftCard("rumayefet@gmail.com");
		step2P.clickPaymentBTN();
		OrderGiftCardStep3PaymentPage step3PaymentP = new OrderGiftCardStep3PaymentPage(driver);
		step3PaymentP.fillPaymentFields("51747332", "inbal", "036199495", "123");
		PaymentErrorPage paymentErrorP = new PaymentErrorPage(driver);
		// should check that we able to fill all the payment info, and get the right message
		String expectedText = "אירעה שגיאה בעת ניסיון הוספת הכרטיס, ניתן לפנות לתמיכה לקבלת עזרה";
		String actualText = paymentErrorP.getPaymentErrorMSg();
		Assert.assertEquals(actualText, expectedText);
	}

}
