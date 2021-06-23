package buyme.co.il.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuperVoucherPage extends BasePage {

	@FindBy(css = ".modal-title")
	private WebElement SuperVoucherScreenText;
	@FindBy(css = ".icon-times.invert")
	private WebElement closeSuperVoucherPage;
	
	public SuperVoucherPage(WebDriver driver) {
		super(driver);
	}

	// get super voucher screen title text
	public String verifySuperVoucherScreenText() {
		return getText(SuperVoucherScreenText);
	}
	
	//close close super voucher page
	public void closeSuperVoucherPage() {
		click(closeSuperVoucherPage);
	}

}
