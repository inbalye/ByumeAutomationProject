package buyme.co.il.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderGiftCardStep3PaymentPage extends BasePage {

	@FindBy(css = ".step-title.highlighted")
	private WebElement verifyStep3Page;
	@FindBy(css = ".form-control.input-theme.creditcard-input")
	private WebElement cardNumberField;
	@FindBy(css = "#name")
	private WebElement firstNameField;
	@FindBy(css = "#personalId")
	private WebElement IDNumberField;
	@FindBy(css = "div.select-wrapper.error-container > .form-control.dib.input-theme > a > span")
	private WebElement yearField;
	@FindBy(css = "div.chosen-container.chosen-container-single.form-control.dib.input-theme"
			+ ".chosen-rtl.form-control.chosen-container-single-nosearch > div > ul >li[data-option-array-index='4']")
	private WebElement selectYear;
	@FindBy(css = "#creditForm > div.form-well > div.row.row-standart.techni-details > div:nth-child(1)"
			+ " > div > div > div:nth-child(2) > div > div")
	private WebElement mounthField;
	@FindBy(css = "div > div > div:nth-child(2) > div > div > div > ul > li:nth-child(4)")
	private WebElement selectMounth;
	@FindBy(css = "#cvv")
	private WebElement CVVNumberField;
	@FindBy(css = "[for='payments-2']")
	private WebElement numberOfPayments;
	@FindBy(css = "#creditForm > div.submit-wrapper > div > div > label")
	private WebElement consentCheckbox;
	@FindBy(css = ".btn.btn-theme.btn-full.button")
	private WebElement submitBTN;
	

	public OrderGiftCardStep3PaymentPage(WebDriver driver) {
		super(driver);
	}

	// get step 3 page text
	public String verifyStep3PageText() {
		return getText(verifyStep3Page);
	}

	/*
	 * it is a frame - so switch to the frame fill payment fields, click consent and
	 * submit button switch back to the main window
	 */
	public void fillPaymentFields(String cardNumber, String firstName, String IDNumber, String CVVNumber) {
		WebElement fr = driver.findElement(By.cssSelector("#step-form-wrapper > iframe"));
		driver.switchTo().frame(fr);
		sleep(2000);
		fillText(cardNumberField, cardNumber);
		fillText(firstNameField, firstName);
		fillText(IDNumberField, IDNumber);
		click(yearField);
		sleep(2000);
		click(selectYear);
		click(mounthField);
		sleep(2000);
		click(selectMounth);
		fillText(CVVNumberField, CVVNumber);
		click(numberOfPayments);
		//sleep(2000);
		click(consentCheckbox);
		click(submitBTN);
		driver.switchTo().defaultContent();
	}

}
