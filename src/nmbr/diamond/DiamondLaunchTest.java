package nmbr.diamond;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DiamondLaunchTest {

	private String baseUrl = "http://www.nmbr.derp.com.s3-website.ap-south-1.amazonaws.com";
	public static WebDriver driver;
	final private String driverPath = "E:/DiamondAutomation/geckodriver.exe";
	final private String logFilePath = "E:/DiamondAutomation/Diamond/logs.txt";

	@BeforeSuite
	public void launchDiamondApp() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, logFilePath);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@AfterSuite
	public void closeDriver() {
		driver.close();
	}
}
