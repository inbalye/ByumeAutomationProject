package buyme.co.il.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import buyme.co.il.pageobjects.ForgotPasswordPage;
import buyme.co.il.pageobjects.HomePage;
import buyme.co.il.pageobjects.LoginPage;
import buyme.co.il.pageobjects.MyAccountPage;

public class LoginTest extends BaseTest {

	@BeforeClass
	public void setupLogin() {
		HomePage homeP = new HomePage(driver);
		homeP.clickRegLogBTN();
	}

	@Test(dataProvider="getData",description = "in this test method i used dataProvider,"
			+ "which means the test method will run multiple times with different data-sets - login should failed")
	public void loginFailed_1(String email, String password) {
		LoginPage logP = new LoginPage(driver);
		logP.login(email, password);
		// should check that we get the right message
		String expectedErrorMessage = "אחד או יותר מהפרטים שהזנת אינם נכונים.";
		String actualErrorMessage = logP.getLoginWrongEmailPasswordErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}
	
    @DataProvider
    public Object [] [] getData (){
    	
    Object [] [] myData = {
    		{"gefen@gmail.com","gefen1234"},
    		{"rotem@gmail.com","555"},
    		{"guy@gmail.com","guy07"},
    		{"ben@gmail.com","#$%&"}	
    };
    
    return myData;
  	
    }

	@Test(description = "insert only password and email field leave empty, login should failed")
	public void loginFailed_2() {
		LoginPage logP = new LoginPage(driver);
		logP.login("", "Inbalye44");
		// should check that we get the right message
		String expectedErrorMessage = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
		String actualErrorMessage = logP.getLoginEmailFieldErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Test(description = "insert only email and password field leave empty, login should failed")
	public void loginFailed_3() {
		LoginPage logP = new LoginPage(driver);
		logP.login("inbalye@gmail.com", "");
		// should check that we get the right message
		String expectedErrorMessage = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
		String actualErrorMessage = logP.getLoginPasswordFieldErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Test(description = "leave login fields empty, without email or password, login should failed")
	public void loginFailed_4() {
		LoginPage logP = new LoginPage(driver);
		logP.login("", "");
		// should check that we get the right message
		String expectedErrorMessage = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
		String actualErrorMessage = logP.getLoginEmailFieldErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		String expectedErrorMessage1 = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
		String actualErrorMessage1 = logP.getLoginPasswordFieldErrorMessage();
		Assert.assertEquals(actualErrorMessage1, expectedErrorMessage1);
	}

	@Test(description = "click on forgot password BTN, fill your email, and check the message you receive")
	public void loginFailed_5() {
		LoginPage logP = new LoginPage(driver);
		logP.forgotPasswordBTN();
		ForgotPasswordPage forgotPasswordP = new ForgotPasswordPage(driver);
		forgotPasswordP.sendMeEmailWithPassword("inbal@gmail.com");
		// should check that we succeed get a message that email was sent to us
		String expectedTextMessage = "שלחנו לך את המייל";
		String actualTextMessage = forgotPasswordP.verifyForgotPasswordScreenText();
		Assert.assertEquals(actualTextMessage, expectedTextMessage);
		forgotPasswordP.closeWindow();
	}

	@Test(description = "insert correct email and password, login should succeed")
	public void loginSucceed() {
		HomePage homeP = new HomePage(driver);
		homeP.clickRegLogBTN();
		LoginPage logP = new LoginPage(driver);
		logP.login("inbalyetest@gmail.com", "Inbaltest1");
		// should check that we succeed to login our account
		homeP.dropdownMenuMyAccount();
		MyAccountPage myAccount = new MyAccountPage(driver);
		String expectedText = "החשבון שלי";
		String actualText = myAccount.verifyMyAccountScreenText();
		Assert.assertEquals(actualText, expectedText);
	}

}
