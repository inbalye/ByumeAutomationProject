package buyme.co.il.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import buyme.co.il.pageobjects.GoogleLoginPage;
import buyme.co.il.pageobjects.HomePage;
import buyme.co.il.pageobjects.LoginPage;
import buyme.co.il.pageobjects.MyAccountPage;

public class GoogleLoginTest extends BaseTest {

	@Test(description = "in order to run this test you should insert your email and password Google account (to connect buyme)"
			+ "login should succeed")
	public void loginWithGoogle() {
		HomePage homeP = new HomePage(driver);
		homeP.clickRegLogBTN();
		LoginPage logP = new LoginPage(driver);
		logP.loginWithGoogle();
		GoogleLoginPage googleLoginP = new GoogleLoginPage(driver);
		googleLoginP.moveToNewWindow();
		// insert your email 
		googleLoginP.loginGoogleStep1("");
		// insert your password
		googleLoginP.loginGoogleStep2("");
		googleLoginP.moveBackToMainWindow();
		// should check that we succeed to login to our buyme account
		homeP.dropdownMenuMyAccount();
		MyAccountPage myAccount = new MyAccountPage(driver);
		String expectedText = "החשבון שלי";
		String actualText = myAccount.verifyMyAccountScreenText();
		Assert.assertEquals(actualText, expectedText);
	}

}
