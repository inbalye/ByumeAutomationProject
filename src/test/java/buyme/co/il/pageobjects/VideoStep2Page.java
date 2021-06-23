package buyme.co.il.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideoStep2Page extends BasePage {

	@FindBy(css = ".thumbnail > .play-video.ember-view")
	private List<WebElement> chooseThankVideoOption;
	@FindBy(css = ".ui-btn.orange.large")
	private WebElement iChooseThisVideoBTN;

	public VideoStep2Page(WebDriver driver) {
		super(driver);
	}

	// click thank Video and click choose video button
	public void chooseYourVideoFromList(int pos) {
		click(chooseThankVideoOption.get(pos));
		sleep(4000);
		click(iChooseThisVideoBTN);
		sleep(4000);

	}
}
