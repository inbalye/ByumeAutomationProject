package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderGiftCardStep2WhoToSendPage extends BasePage {

	@FindBy(css = ".step-title.highlighted")
	private WebElement verifyStep2Page;
	@FindBy(css = "[data-parsley-required-message='�� ����� ������? �� ������ �� �� �����/�']")
	private WebElement receiveNameField;
	@FindBy(css = "[data-parsley-required-message='��� ����� ����? ���� ���� �� ��� ���']")
	private WebElement senderNameField;
	@FindBy(css = "[placeholder='��� ���, ���� ��� �� ���� ��� ����? ��� ������ ����� ����� �������� �����, �� 100 �����']")
	private WebElement blessingField;
	@FindBy(css = "div.ui-card.add-media > div > label:nth-child(2)")
	private WebElement chooseVideoOption;
	@FindBy(css = ".icon.icon-envelope")
	private WebElement chooseEmailOption;
	@FindBy(css = "[placeholder='����� ����� �� ����/� �����']")
	private WebElement mailReceiveField;
	@FindBy(css = ".btn.btn-theme.btn-save")
	private WebElement saveBTN;
	@FindBy(css = "div.submit-wrapper > button")
	private WebElement paymentBTN;

	public OrderGiftCardStep2WhoToSendPage(WebDriver driver) {
		super(driver);
	}

	// get step 2 page text
	public String verifyStep2PageText() {
		return getText(verifyStep2Page);
	}

	// fill fields info to send the gift card
	public void sendGiftForSomeoneAlse(String receive, String sender, String blassing) {
		fillText(receiveNameField, receive);
		fillText(senderNameField, sender);
		fillText(blessingField, blassing);
		sleep(2000);

	}

	// click add video option
	public void clickAddVideo() {
		click(chooseVideoOption);
		sleep(4000);
	}

	// click send gift card by email option and fill mail receive field
	public void howToSendGiftCard(String mailReceive) {
		click(chooseEmailOption);
		fillText(mailReceiveField, mailReceive);
		click(saveBTN);

	}

	// click payment button
	public void clickPaymentBTN() {
		click(paymentBTN);
		sleep(2000);
	}

}
