package buyme.co.il.pageobjects;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	protected void fillText(WebElement el, String text) {
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", el);
		el.clear();
		el.sendKeys(text);
	}

	protected void click(WebElement el) {
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", el);
		el.click();
	}

	protected String getText(WebElement el) {
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", el);
		return el.getText();
	}

	protected void alertOK(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}

	protected void backToPreviousPage() {
		driver.navigate().back();
		sleep(2000);
	}

	protected void sleep(int mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// move to new window
	protected void moveToNewWindow() {
		String parentHandle = driver.getWindowHandle();
		Set<String> handels = driver.getWindowHandles();
		for (String h : handels) {
			System.out.println("current handle is the set is : " + h);
			if (!parentHandle.contains(h)) {
				driver.switchTo().window(h);
				break;
			}
		}
	}

	// close window and beck to the main window
	protected void closeWindowAndBackToMainWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			System.out.println("current handle is the set is : " + windowHandle);
			if (!parentWindow.contains(windowHandle)) {
				driver.close();
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	// move beck to the main window
	protected void moveBackToMainWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			System.out.println("current handle is the set is : " + windowHandle);
			if (!parentWindow.contains(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

}
