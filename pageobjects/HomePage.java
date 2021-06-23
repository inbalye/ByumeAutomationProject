package buyme.co.il.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(css = ".seperator-link")
	private WebElement enterRegLogBTN;
	@FindBy(css = "[href='https://buyme.co.il/myAccount?tab=details']")
	private WebElement dropdownMenuMyAccount;
	@FindBy(css = "[data-ember-action='1092']")
	private WebElement dropdownMenuExit;
	@FindBy(css = "ul.nav-bar.links > li:nth-child(1) > a")
	private WebElement giftForEmployeesBTN;
	@FindBy(css = "ul.nav-bar.links > li:nth-child(2) > a")
	private WebElement businessEntryBTN;
	@FindBy(css = "div > ul.nav-bar.buttons > li.ghost > a > span")
	private WebElement superVoucherBTN;
	@FindBy(css = "div > ul.nav-bar.buttons > li:nth-child(2) > a")
	private WebElement giftCardBalanceCheckBTN;
	@FindBy(css = "#ember776_chosen > a")
	private WebElement clickOnMount;
	@FindBy(css = "#ember776_chosen > div > ul > li:nth-child(4)")
	private WebElement selectMount;
	@FindBy(css = "#ember791_chosen > a")
	private WebElement clickOnArea;
	@FindBy(css = "#ember791_chosen > div > ul > li:nth-child(2)")
	private WebElement selectArea;
	@FindBy(css = "#ember801_chosen > a")
	private WebElement clickOnCategory;
	@FindBy(css = "#ember801_chosen > div > ul > li:nth-child(3)")
	private WebElement selectCategory;
	@FindBy(css = ".ui-btn.search.ember-view")
	private WebElement findMeGiftBTN;
	@FindBy(css = ".card-item.ember-view")
	private List<WebElement> giftCardList;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// click registration/login button
	public void clickRegLogBTN() {
		click(enterRegLogBTN);
		sleep(2000);
	}

	// click dropdown menu and click my account
	public void dropdownMenuMyAccount() {
		click(dropdownMenuMyAccount);
		sleep(4000);
	}

	// click gift for employees button
	public void clickGiftForEmployeesBTN() {
		click(giftForEmployeesBTN);
	}

	// click business entry button
	public void clickBusinessEntryBTN() {
		click(businessEntryBTN);
	}

	// click super voucher button
	public void clickSuperVoucherBTN() {
		click(superVoucherBTN);
	}

	// click gift card balance check button
	public void clickGiftCardBalanceCheckBTN() {
		click(giftCardBalanceCheckBTN);
	}

	// search gift card by click Mount, Area and Category, click on find me gift card button
	public void searchGiftCard() {
		click(clickOnMount);
		click(selectMount);
		click(clickOnArea);
		click(selectArea);
		click(clickOnCategory);
		click(selectCategory);
		click(findMeGiftBTN);
		sleep(1000);
	}

	// choose your gift card
	public void chooseYourGiftCardFromList(int pos) {
		click(giftCardList.get(pos));
		sleep(2000);
	}

}
