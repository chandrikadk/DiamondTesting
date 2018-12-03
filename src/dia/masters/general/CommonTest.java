package dia.masters.general;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import nmbr.diamond.DiamondLaunchTest;

public class CommonTest extends DiamondLaunchTest {

	int col_num = 1, row_num = 1;
	WebElement commonTable;
	List<WebElement> trCollection;
	Select itemType;
	String valMsg;

	@Test(priority = 1)
	public void commonTest() throws InterruptedException {
		Thread.sleep(3000);
		// driver.findElement(By.linkText("Masters")).click();
		// driver.findElement(By.linkText("General")).click();
		driver.findElement(By.linkText("Common")).click();
		Thread.sleep(3000);
		String actualHeading = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals("COMMON", actualHeading);
		String homeButton = driver.findElement(By.xpath("//div/div/ba-content-top/div/ul/li/a")).getText();
		Assert.assertEquals("Home", homeButton);
		String common = driver.findElement(By.xpath("//common/div/div/ba-card/div/div/h3")).getText();
		Assert.assertEquals("COMMON", common);
		driver.findElement(By.xpath("//div/div/ba-content-top/div/ul/li/a")).click();
		String urlHome = driver.getCurrentUrl();
		Assert.assertEquals(urlHome, "http://www.nmbr.derp.com.s3-website.ap-south-1.amazonaws.com/#/pages/dashboard");
	}

	@Test(priority = 2)
	public void searchByItemTypeTest() throws InterruptedException {
		driver.findElement(By.linkText("Common")).click();
		itemType = new Select(driver.findElement(By.xpath("//ng2-smart-table-filter/div/select-filter/select")));
		itemType.selectByVisibleText("Bank Code");
		commonTable = driver.findElement(By.tagName("tbody"));
		trCollection = commonTable.findElements(By.xpath("//ng2-smart-table/table/tbody/tr"));
		for (WebElement trElement : trCollection) {
			List<WebElement> td_collection = trElement.findElements(By.xpath("td[position() = 1]"));
			for (WebElement tdElement : td_collection) {
				System.out.println(tdElement.getText());
				col_num++;
			}
			row_num++;
		}
	}

	@Test(priority = 3)
	public void searchByCommonNameTest() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(
				By.xpath("//div/ng2-smart-table/table/thead/tr[2]/th[2]/ng2-smart-table-filter/div/input-filter/input"))
				.sendKeys("COMMON");
		commonTable = driver.findElement(By.tagName("tbody"));
		trCollection = commonTable.findElements(By.xpath("//ng2-smart-table/table/tbody/tr"));
		for (WebElement trElement : trCollection) {
			List<WebElement> td_collection = trElement.findElements(By.xpath("td[position() = 2]"));
			for (WebElement tdElement : td_collection) {
				System.out.println(tdElement.getText());
				col_num++;
			}
			row_num++;
		}
	}

	@Test(priority = 4)
	public void searchByCommonCodeTest() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(
				By.xpath("//div/ng2-smart-table/table/thead/tr[2]/th[3]/ng2-smart-table-filter/div/input-filter/input"))
				.sendKeys("COM");
		commonTable = driver.findElement(By.tagName("tbody"));
		trCollection = commonTable.findElements(By.xpath("//ng2-smart-table/table/tbody/tr"));
		for (WebElement trElement : trCollection) {
			List<WebElement> td_collection = trElement.findElements(By.xpath("td[position() = 3]"));
			for (WebElement tdElement : td_collection) {
				System.out.println(tdElement.getText());
				col_num++;
			}
			row_num++;
		}
	}

	@Test(priority = 5)
	public void addCommonTest() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(By.tagName("i")).click();
		// step 1 pending
		driver.findElement(
				By.xpath("//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[4]/ng2-st-actions/a[2]/i")).click();
		driver.findElement(By.xpath("//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[2]/th[4]/a/i")).click();
		driver.findElement(By.xpath("//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[4]/ng2-st-actions/a/i"))
				.click();
		valMsg = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(true, valMsg.contains("Danger! Item Type field is required"));
	}

	@Test(priority = 6)
	public void addCommonWithProperFieldValuesTest() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//div/ng2-smart-table/table/thead/tr[2]/th[4]/a/i")).click();
		itemType = new Select(driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/select-editor/select")));
		itemType.selectByVisibleText("Bank Code");
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[2]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.sendKeys("COMMON_Test");
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[3]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.sendKeys("CCtt");
		driver.findElement(
				By.xpath("//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[4]/ng2-st-actions/a[2]/i")).click();
		driver.findElement(By.xpath("//div/ng2-smart-table/table/thead/tr[2]/th[4]/a/i")).click();
		itemType = new Select(driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/select-editor/select")));
		itemType.selectByVisibleText("Bank Code");
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[2]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.clear();
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[2]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.sendKeys("COMMON_Test");
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[3]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.clear();
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[3]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.sendKeys("test");
		driver.findElement(By.xpath("//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[4]/ng2-st-actions/a/i"))
				.click();
		// Thread.sleep(6000);
		// String valMsg = driver.findElement(By.tagName("body")).getText();
		// Assert.assertEquals(true, valMsg.contains("Common saved successfully!"));
	}

	@Test(priority = 7)
	public void editCommonTest() throws InterruptedException {
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[2]/th[3]/ng2-smart-table-filter/div/input-filter/input"))
				.sendKeys("CCtt");
		driver.findElement(
				By.xpath("//ba-card/div/div[2]/ng2-smart-table/table/tbody/tr/td[4]/ng2-st-tbody-edit-delete/a/i"))
				.click();
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/tbody/tr/td[2]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.clear();
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/tbody/tr/td[2]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.sendKeys("TestCommon");
		driver.findElement(
				By.xpath("//ba-card/div/div[2]/ng2-smart-table/table/tbody/tr/td[4]/ng2-st-tbody-create-cancel/a[2]/i"))
				.click();
		driver.findElement(
				By.xpath("//ba-card/div/div[2]/ng2-smart-table/table/tbody/tr/td[4]/ng2-st-tbody-edit-delete/a/i"))
				.click();
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/tbody/tr/td[2]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.clear();
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/tbody/tr/td[2]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.sendKeys("TestCommon");
		driver.findElement(
				By.xpath("//ba-card/div/div[2]/ng2-smart-table/table/tbody/tr/td[4]/ng2-st-tbody-create-cancel/a/i"))
				.click();
	}

	@Test(priority = 8)
	public void addDuplicateCommonNameTest() throws InterruptedException {
		driver.findElement(By.xpath("//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[2]/th[4]/a/i")).click();
		itemType = new Select(driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/select-editor/select")));
		itemType.selectByVisibleText("Bank Code");
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[2]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.clear();
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[2]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.sendKeys("TestCommon");
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[3]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.clear();
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[3]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.sendKeys("tes");
		driver.findElement(By.xpath("//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[4]/ng2-st-actions/a/i"))
				.click();
		valMsg = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(true, valMsg.contains("Danger! Duplicate Common Name!"));
	}

	@Test(priority = 9)
	public void addDuplicateCommonCodeTest() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//div/ng2-smart-table/table/thead/tr[2]/th[4]/a/i")).click();
		itemType = new Select(driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/select-editor/select")));
		itemType.selectByVisibleText("Bank Code");
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[2]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.sendKeys("COMMONtest");
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[3]/ng2-smart-table-cell/table-cell-edit-mode/div/table-cell-default-editor/div/input-editor/input"))
				.sendKeys("CCtt");
		driver.findElement(By.xpath("//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[3]/td[4]/ng2-st-actions/a/i"))
				.click();
		valMsg = driver.findElement(By.tagName("body")).getText();
		Assert.assertEquals(true, valMsg.contains("Danger! Duplicate Common Code!"));
	}

	@Test(priority = 10)
	public void deleteCommonTest() throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		driver.findElement(By.xpath(
				"//ba-card/div/div[2]/ng2-smart-table/table/thead/tr[2]/th[2]/ng2-smart-table-filter/div/input-filter/input"))
				.sendKeys("TestCommon");
		driver.findElement(By
				.xpath("//ba-card/div/div[2]/ng2-smart-table/table/tbody/tr[2]/td[4]/ng2-st-tbody-edit-delete/a[2]/i"))
				.click();
		alert.dismiss();
		driver.findElement(By
				.xpath("//ba-card/div/div[2]/ng2-smart-table/table/tbody/tr[2]/td[4]/ng2-st-tbody-edit-delete/a[2]/i"))
				.click();
		alert.accept();
	}
}
