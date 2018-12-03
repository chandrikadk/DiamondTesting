package dia.masters.general;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import nmbr.diamond.DiamondLoginTest;

public class CurrencyTest extends DiamondLoginTest {

	int col_num = 1, row_num = 1;
	WebElement currencyTable;
	List<WebElement> trCollection;
	Select itemType;
	String valMsg;
	Select freelyConvertible;

	@Test(priority = 1)
	public void currencyTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Masters")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.linkText("General")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Currency")).click();
		Thread.sleep(6000);
		String actualHeading = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("CURRENCY", actualHeading);
		Thread.sleep(6000);
		String homeButton = driver.findElement(By.xpath("//div/div/ba-content-top/div/ul/li/a")).getText();
		Assert.assertEquals("Home", homeButton);
		Thread.sleep(6000);
		String currency = driver.findElement(By.xpath("//currency/div/div/ba-card/div/div/h3")).getText();
		Assert.assertEquals("CURRENCY", currency);
		driver.findElement(By.xpath("//div/div/ba-content-top/div/ul/li/a")).click();
		String urlHome = driver.getCurrentUrl();
		Assert.assertEquals(urlHome, "http://www.nmbr.derp.com.s3-website.ap-south-1.amazonaws.com/#/pages/dashboard");
	}

	@Test(priority = 2)
	public void searchByCurrName() throws InterruptedException {
		// driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Currency")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//ng2-smart-table/table/thead/tr[2]/th/ng2-smart-table-filter/div/input-filter/input"))
				.sendKeys("RUPEES");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		currencyTable = driver.findElement(By.tagName("tbody"));
		Thread.sleep(5000);
		trCollection = currencyTable.findElements(By.xpath("//ng2-smart-table/table/tbody/tr"));
		Thread.sleep(5000);
		for (WebElement trElement : trCollection) {
			Thread.sleep(5000);
			List<WebElement> td_collection = trElement.findElements(By.xpath("td[position() = 1]"));
			Thread.sleep(5000);
			for (WebElement tdElement : td_collection) {
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				System.out.println(tdElement.getText());
				col_num++;
			}
			row_num++;
		}
	}

	@Test(priority = 3)
	public void searchByCurrCode() throws InterruptedException {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//ng2-smart-table/table/thead/tr[2]/th[2]/ng2-smart-table-filter/div/input-filter/input"))
				.sendKeys("USD");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		currencyTable = driver.findElement(By.tagName("tbody"));
		Thread.sleep(5000);
		trCollection = currencyTable.findElements(By.xpath("//ng2-smart-table/table/tbody/tr"));
		Thread.sleep(5000);
		for (WebElement trElement : trCollection) {
			Thread.sleep(5000);
			List<WebElement> td_collection = trElement.findElements(By.xpath("td[position() = 2]"));
			Thread.sleep(5000);
			for (WebElement tdElement : td_collection) {
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				System.out.println(tdElement.getText());
				col_num++;
			}
			row_num++;
		}
	}

	@Test(priority = 4)
	public void searchByFreelyConvertible() throws InterruptedException {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		freelyConvertible = new Select(driver.findElement(
				By.xpath("//ng2-smart-table/table/thead/tr[2]/th[3]/ng2-smart-table-filter/div/select-filter/select")));
		freelyConvertible.selectByVisibleText("Yes");
		Thread.sleep(5000);
		currencyTable = driver.findElement(By.tagName("tbody"));
		Thread.sleep(5000);
		trCollection = currencyTable.findElements(By.xpath("//ng2-smart-table/table/tbody/tr"));
		Thread.sleep(5000);
		for (WebElement trElement : trCollection) {
			Thread.sleep(5000);
			List<WebElement> td_collection = trElement.findElements(By.xpath("td[position() = 3]"));
			for (WebElement tdElement : td_collection) {
				Thread.sleep(5000);
				System.out.println(tdElement.getText());
				col_num++;
			}
			row_num++;
		}
	}

	@Test(priority = 5)
	public void addCurrVal() throws InterruptedException {
		// driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//currency/div/div/ba-card/div/div[2]/ng2-smart-table/table/thead/tr[2]/th[4]/a/i")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(
				"//currency/div/div/ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[4]/ng2-st-actions/a/i"))
				.click();
		valMsg = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(true, valMsg.contains("Danger! Currency Name field is required"));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(
				"//currency/div/div/ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[4]/ng2-st-actions/a[2]/i"))
				.click();
	}

	@Test(priority = 6)
	public void addCurrWithProperFieldValues() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//currency/div/div/ba-card/div/div[2]/ng2-smart-table/table/thead/tr[2]/th[4]/a/i")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(
				"//currency/div/div/ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.sendKeys("TestCurr");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(
				"//currency/div/div/ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[2]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.sendKeys("tes");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		freelyConvertible = new Select(driver.findElement(By.xpath(
				"//currency/div/div/ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/select-editor/select")));
		freelyConvertible.selectByVisibleText("No");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.className("ion-checkmark")).click();
		// valMsg = driver.findElement(By.tagName("body")).getText();
		// Assert.assertEquals(true, valMsg.contains("Currency details saved
		// successfully!"));
	}

	@Test(priority = 7)
	public void editCurr() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//ng2-smart-table/table/thead/tr[2]/th/ng2-smart-table-filter/div/input-filter/input"))
				.sendKeys("TestCurr");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//i[@class='ion-edit']")).click();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='currName']")).clear();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='currName']")).sendKeys("TestCur");
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='currCode']")).clear();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='currCode']")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		freelyConvertible = new Select(driver.findElement(By.xpath("//select[@ng-reflect-name='convertible']")));
		freelyConvertible.selectByVisibleText("Yes");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//i[@class='ion-close']")).click();

		Thread.sleep(6000);
		driver.findElement(
				By.xpath("//ng2-smart-table/table/thead/tr[2]/th/ng2-smart-table-filter/div/input-filter/input"))
				.clear();
		driver.findElement(
				By.xpath("//ng2-smart-table/table/thead/tr[2]/th/ng2-smart-table-filter/div/input-filter/input"))
				.sendKeys("TestCurr");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//i[@class='ion-edit']")).click();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='currName']")).clear();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='currName']")).sendKeys("TestCur");
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='currCode']")).clear();
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='currCode']")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		freelyConvertible = new Select(driver.findElement(By.xpath("//select[@ng-reflect-name='convertible']")));
		freelyConvertible.selectByVisibleText("Yes");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//i[@class='ion-checkmark']")).click();
	}

	@Test(priority = 8)
	public void addDuplicateCurr() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-ios-plus-outline']")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='currName']")).sendKeys("TestCur");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='currCode']")).sendKeys("test");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		freelyConvertible = new Select(driver.findElement(By.xpath("//select[@ng-reflect-name='convertible']")));
		freelyConvertible.selectByVisibleText("No");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-checkmark']")).click();
		Thread.sleep(7000);
		valMsg = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(true, valMsg.contains("Danger! Duplicate Currency Name!"));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-close']")).click();

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-ios-plus-outline']")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='currName']")).sendKeys("TestCurr");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-reflect-name='currCode']")).sendKeys("tes");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		freelyConvertible = new Select(driver.findElement(By.xpath("//select[@ng-reflect-name='convertible']")));
		freelyConvertible.selectByVisibleText("Yes");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-checkmark']")).click();
		Thread.sleep(7000);
		valMsg = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(true, valMsg.contains("Danger! Duplicate Currency Code!"));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='ion-close']")).click();
	}

	@Test(priority = 9)
	public void deleteCurr() throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.alertIsPresent());

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(
					By.xpath("//ng2-smart-table/table/thead/tr[2]/th/ng2-smart-table-filter/div/input-filter/input"))
					.clear();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(
					By.xpath("//ng2-smart-table/table/thead/tr[2]/th/ng2-smart-table-filter/div/input-filter/input"))
					.sendKeys("TestCur");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//i[@class='ion-trash-a']")).click();
			Thread.sleep(6000);
			alert.dismiss();

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(
					By.xpath("//ng2-smart-table/table/thead/tr[2]/th/ng2-smart-table-filter/div/input-filter/input"))
					.clear();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(
					By.xpath("//ng2-smart-table/table/thead/tr[2]/th/ng2-smart-table-filter/div/input-filter/input"))
					.sendKeys("TestCur");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//i[@class='ion-trash-a']")).click();
			Thread.sleep(6000);
			alert.accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
