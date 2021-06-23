package buyme.co.il.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import buyme.co.il.pageobjects.FacebookLoginPage;
import buyme.co.il.pageobjects.HomePage;
import buyme.co.il.pageobjects.LoginPage;
import buyme.co.il.pageobjects.MyAccountPage;

public class FacebookLoginTest extends BaseTest {

	@Test(description = "in order to run this test you should insert your email and password Facebook account (to connect buyme)"
			+ "login should succeed")
	public void loginWithFacebook() {
		HomePage homeP = new HomePage(driver);
		homeP.clickRegLogBTN();
		LoginPage logP = new LoginPage(driver);
		logP.loginWithFacebook();
		FacebookLoginPage facebookP = new FacebookLoginPage(driver);
		facebookP.moveToNewWindow();
		// insert your email (left) and password (right)
		facebookP.loginFacebook("", "");
		facebookP.moveBackToMainWindow();
		// should check that we succeed to login to our buyme account
		homeP.dropdownMenuMyAccount();
		MyAccountPage myAccount = new MyAccountPage(driver);
		String expectedText = "החשבון שלי";
		String actualText = myAccount.verifyMyAccountScreenText();
		Assert.assertEquals(actualText, expectedText);
	}

}
