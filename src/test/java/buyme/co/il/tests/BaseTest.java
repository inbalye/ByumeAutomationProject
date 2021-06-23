package buyme.co.il.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.Utils;

public class BaseTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		//System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		
		//WebDriverManeger.chromegriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Utils u = new Utils();
//		driver.get("https://buyme.co.il/");
		driver.get(u.readProperty("url"));
	}

	@AfterClass
	public void tearDownDriver() {
		driver.quit();
	}

}
