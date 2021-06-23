package buyme.co.il.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import buyme.co.il.pageobjects.BusinessEntryPage;
import buyme.co.il.pageobjects.GiftCardBalanceCheckPage;
import buyme.co.il.pageobjects.GiftForEmployeesPage;
import buyme.co.il.pageobjects.HomePage;
import buyme.co.il.pageobjects.LoginPage;
import buyme.co.il.pageobjects.SuperVoucherPage;

public class HeaderFunctionalityButtonsTest extends BaseTest {

	@Test(description = "click gift for employees button, test should succeed and open new window") 
	public void clickOn_01_giftForEmployeesBTN() {
		HomePage homeP = new HomePage(driver);
		homeP.clickGiftForEmployeesBTN();
		GiftForEmployeesPage giftForEmployeesP = new GiftForEmployeesPage(driver);
		giftForEmployeesP.moveToNewWindow();
		// should check that we succeed to open employees window
		String expectedTitleText = "BUYME @ WORK";
		String actualTitleText = giftForEmployeesP.verifyGiftForEmployeesScreenTitleText();
		Assert.assertEquals(actualTitleText, expectedTitleText);
		giftForEmployeesP.closeWindowAndBackToMainWindow();
	}

	@Test(description = "click business entry button, test should succeed and open new window")
	public void clickOn_02_businessEntryBTN() {
		HomePage homeP = new HomePage(driver);
		homeP.clickBusinessEntryBTN();
		BusinessEntryPage businessEntryP = new BusinessEntryPage(driver);
		businessEntryP.moveToNewWindow();
		// should check that we succeed to open business entry window
		String expectedTitleText = "כניסה למערכת ניהול ה-GIFT CARD שלי ב-BUYME";
		String actualTitleText = businessEntryP.verifyBusinessEntryScreenTitleText();
		Assert.assertEquals(actualTitleText, expectedTitleText);
		businessEntryP.closeWindowAndBackToMainWindow();
	}
	
	@Test(description = "click super voucher button, test should succeed")
	public void clickOn_03_superVoucherBTN() {
		HomePage homeP = new HomePage(driver);
		homeP.clickSuperVoucherBTN();
		LoginPage logP = new LoginPage(driver);
		logP.login("inbalyetest@gmail.com", "Inbaltest1");
		// should check that we succeed get to super voucher page
		SuperVoucherPage superVoucherP = new SuperVoucherPage(driver);
		String expectedText = "קיבלת סופר שובר?";
		String actualText = superVoucherP.verifySuperVoucherScreenText();
		Assert.assertEquals(actualText, expectedText);
		superVoucherP.closeSuperVoucherPage();
	}

	@Test(description = "click gift card balance-check button, test should succeed")
	public void clickOn_04_giftCardBalanceCheckBTN() {
		HomePage homeP = new HomePage(driver);
		homeP.clickGiftCardBalanceCheckBTN();
		// should check that we succeed get to gift card balance check page
		GiftCardBalanceCheckPage giftCardBalanceCheckP = new GiftCardBalanceCheckPage(driver);
		String expectedText = "בדיקת יתרה ב-Gift-Card";
		String actualText = giftCardBalanceCheckP.verifyGiftCardBalanceCheckScreenText();
		Assert.assertEquals(actualText, expectedText);
	}
	




}
