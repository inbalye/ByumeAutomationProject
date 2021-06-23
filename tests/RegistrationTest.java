package buyme.co.il.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import buyme.co.il.pageobjects.HomePage;
import buyme.co.il.pageobjects.LoginPage;
import buyme.co.il.pageobjects.RegistrationPage;

public class RegistrationTest extends BaseTest {

	@BeforeClass
	public void setupRegistration() {
		HomePage homeP = new HomePage(driver);
		homeP.clickRegLogBTN();
		LoginPage logP = new LoginPage(driver);
		logP.registerBTN();
	}

	@Test(description = "leave name field empty,Registration should failed")
	public void registrationFailed_1() {
		RegistrationPage regP = new RegistrationPage(driver);
		regP.fillRegistrationFields("", "inbalye@gmail.com", "Iinbal44", "Iinbal44");
		// should check that we get the right message
		String expectedErrorMessage = "ערך זה דרוש.";
		String actualErrorMessage = regP.getRegistrationNameRequiredErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Test(description = "insert invalid name in name field ,Registration should failed")
	public void registrationFailed_2() {
		RegistrationPage regP = new RegistrationPage(driver);
		regP.fillRegistrationFields("@@@@", "inbalye@gmail.com", "Iinbal44", "Iinbal44");
		// should check that we get the right message
		String expectedErrorMessage = "מצטערים, אבל השם יכול להכיל רק אותיות, מספרים ורווח בלבד.";
		String actualErrorMessage = regP.getRegistrationInvalidNameErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Test(description = "leave email field empty, Registration should failed")
	public void registrationFailed_3() {
		RegistrationPage regP = new RegistrationPage(driver);
		regP.fillRegistrationFields("inbal", "", "Iinbal44", "Iinbal44");
		// should check that we get the right message
		String expectedErrorMessage = "ערך זה דרוש.";
		String actualErrorMessage = regP.getRegistrationMailRequiredErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Test(description = "insert invalid email in email field ,Registration should failed")
	public void registrationFailed_4() {
		RegistrationPage regP = new RegistrationPage(driver);
		regP.fillRegistrationFields("inbal", "inbaly@@gmail.com", "Iinbal44", "Iinbal44");
		// should check that we get the right message
		String expectedErrorMessage = "ערך זה צריך להיות כתובת אימייל.";
		String actualErrorMessage = regP.getRegistrationInvalidEMailErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Test(description = "leave password field empty, Registration should failed")
	public void registrationFailed_5() {
		RegistrationPage regP = new RegistrationPage(driver);
		regP.fillRegistrationFields("inbal", "inbaly@gmail.com", "", "");
		// should check that we get the right message
		String expectedErrorMessage = "ערך זה דרוש.";
		String actualErrorMessage = regP.getRegistrationPasswordRequiredErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Test(description = "insert invalid password in password field, Registration should failed")
	public void registrationFailed_6() {
		RegistrationPage regP = new RegistrationPage(driver);
		regP.fillRegistrationFields("inbal", "inbal@gmail.com", "inbalye44", "inbalye44");
		// should check that we get the right message
		String expectedErrorMessage = "הסיסמה צריכה להכיל לפחות 8 תווים, ביניהם לפחות אות אחת גדולה באנגלית, לפחות אות אחת קטנה באנגלית ולפחות ספרה אחת";
		String actualErrorMessage = regP.getRegistrationInvalidPasswordErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Test(description = "insert incorrect verification password, Registration should failed")
	public void registrationFailed_7() {
		RegistrationPage regP = new RegistrationPage(driver);
		regP.fillRegistrationFields("inbal", "inbaly@gmail.com", "Iinbal44", "Iinbal55");
		// should check that we get the right message
		String expectedErrorMessage = "הסיסמאות לא זהות, אולי זה מהתרגשות :)";
		String actualErrorMessage = regP.getRegistrationPasswordVerificationRequiredErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Test(description = "try to register with email who already exists in the system, Registration should failed")
	public void registrationFailed_8() {
		RegistrationPage regP = new RegistrationPage(driver);
		regP.fillRegistrationFields("inbal", "inbalye@gmail.com", "Iinbalye44", "Iinbalye44");
		// should check that we get the right message
		String expectedErrorMessage = "דוא\"ל זה כבר קיים במערכת.";
		String actualErrorMessage = regP.getRegistrationEmailAlreadyExistsInTheSystemErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

}
