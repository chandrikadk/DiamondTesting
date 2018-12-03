package dia.masters.paramdetails;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import nmbr.diamond.DiamondLoginTest;

public class ParamListTest extends DiamondLoginTest {
	int col_num = 1, row_num = 1;
	WebElement paramListTable;
	List<WebElement> trCollection;
	String valMsg;

	@Test(priority = 1)
	public void paramListTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Masters")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Parameter Details")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Parameter List")).click();
		Thread.sleep(6000);
		String actualHeading = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("PARAMETER LIST", actualHeading);
		Thread.sleep(6000);
		String homeButton = driver.findElement(By.xpath("//div/div/ba-content-top/div/ul/li/a")).getText();
		Assert.assertEquals("Home", homeButton);
		Thread.sleep(6000);
		String paramList = driver.findElement(By.xpath("//pages/div/div/ba-content-top/div/ul/li[2]")).getText();
		Assert.assertEquals("Parameter List", paramList);
		driver.findElement(By.xpath("//div/div/ba-content-top/div/ul/li/a")).click();
		String urlHome = driver.getCurrentUrl();
		Assert.assertEquals(urlHome, "http://www.nmbr.derp.com.s3-website.ap-south-1.amazonaws.com/#/pages/dashboard");
	}

	@Test(priority = 2)
	public void searchByParamCodeAndName() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Parameter List")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Parameter Code']")).sendKeys("C_Lgt");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Thread.sleep(5000);
		paramListTable = driver.findElement(By.tagName("tbody"));
		Thread.sleep(5000);
		trCollection = driver.findElements(By.xpath("//ng2-smart-table/table/tbody/tr"));
		Thread.sleep(5000);
		for (WebElement trElement : trCollection) {
			Thread.sleep(5000);
			List<WebElement> td_collection = trElement.findElements(By.xpath("td[position() = 1]"));
			Thread.sleep(5000);
			for (WebElement tdElement : td_collection) {
				Thread.sleep(3000);
				System.out.println(tdElement.getText());
				col_num++;
			}
			row_num++;
		}
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.navigate().refresh();
//		driver.findElement(By.xpath("//input[@placeholder='Parameter Code']")).clear();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Parameter Name']")).sendKeys("C_Depth");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Thread.sleep(5000);
		paramListTable = driver.findElement(By.tagName("tbody"));
		Thread.sleep(5000);
		trCollection = driver.findElements(By.xpath("//ng2-smart-table/table/tbody/tr"));
		Thread.sleep(5000);
		for (WebElement trElement : trCollection) {
			Thread.sleep(2000);
			List<WebElement> td_collection = trElement.findElements(By.xpath("td[position() = 2]"));
			Thread.sleep(3000);
			for (WebElement tdElement : td_collection) {
				Thread.sleep(3000);
				System.out.println(tdElement.getText());
				col_num++;
			}
			row_num++;
		}

		// check for invalid filter values
	}

	@Test(priority = 3)
	public void sortByParamCodeAndName() throws InterruptedException {

	}

	@Test(priority = 4)
	public void addParamList() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-ios-plus-outline']")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-checkmark']")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		valMsg = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(true, valMsg.contains("Danger! Parameter Code field is required"));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-close']")).click();
	}

	@Test(priority = 5)
	public void addParamListWithProperFieldValues() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-ios-plus-outline']")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='paramCode']")).sendKeys("tes");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='paramName']")).sendKeys("testParam");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-checkmark']")).click();
	}

	@Test(priority = 6)
	public void editParamList() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Parameter Name']")).sendKeys("testParam");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-edit']")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='paramCode']")).clear();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='paramCode']")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='paramName']")).clear();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='paramName']")).sendKeys("testParamName");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-checkmark']")).click();

	}
}
