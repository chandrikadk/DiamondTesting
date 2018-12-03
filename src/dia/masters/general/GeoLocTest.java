package dia.masters.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import nmbr.diamond.DiamondLaunchTest;

public class GeoLocTest extends DiamondLaunchTest {

	boolean result;

	@Test(priority = 1)
	public void geoLocTest() throws InterruptedException {
		try {
			Thread.sleep(3000);
			driver.findElement(By.linkText("Masters")).click();
			driver.findElement(By.linkText("General")).click();
			driver.findElement(By.linkText("Geographical Location")).click();
			Thread.sleep(4000);
			String actualHeading = driver.findElement(By.tagName("h1")).getText();
			Assert.assertEquals("GEOGRAPHICAL LOCATION", actualHeading);
			String rightActualHeading = driver.findElement(By.xpath("//div/div/ba-content-top/div/ul/li[2]")).getText();
			Assert.assertEquals("Geographical Location", rightActualHeading);
			String homeButton = driver.findElement(By.xpath("//div/div/ba-content-top/div/ul/li/a")).getText();
			Assert.assertEquals("Home", homeButton);
			String zoneEntry = driver.findElement(By.xpath("//zoneentry/div/div/ba-card/div/div/h3")).getText();
			Assert.assertEquals("ZONE ENTRY", zoneEntry);
			// WebElement tableZoneEntry =
			// driver.findElement(By.xpath("//div/ng2-smart-table/table/thead"));
			// List<WebElement> th_collection =
			// tableZoneEntry.findElements(By.xpath("//table/thead/tr[1]/th"));
			/*
			 * for (WebElement e : th_collection) { System.out.print(e.getText() + " "); }
			 */
			// System.out.println("Step 4 - Passed");
			driver.findElement(By.xpath("//div/div/ba-content-top/div/ul/li/a")).click();
			String urlHome = driver.getCurrentUrl();
			Assert.assertEquals(urlHome,
					"http://www.nmbr.derp.com.s3-website.ap-south-1.amazonaws.com/#/pages/dashboard");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// FILTERING

	// SORTING

	// ADD GeoLoc
	@Test(priority = 2)
	public void addGeoLocTest() throws InterruptedException {
		try {
			Thread.sleep(3000);
			driver.findElement(By.linkText("Geographical Location")).click();
			// Add geographical locations
			driver.findElement(By.className("ion-ios-plus-outline")).click();
			String pageTitle = driver.findElement(By.tagName("h3")).getText();
			Assert.assertEquals("ZONE ENTRY", pageTitle);
			String zoneTab = driver.findElement(By.id("zone")).getText();
			Assert.assertEquals("ZONE", zoneTab);
			String countryTab = driver.findElement(By.id("country")).getText();
			Assert.assertEquals("COUNTRY", countryTab);
			String stateTab = driver.findElement(By.id("state")).getText();
			Assert.assertEquals("STATE", stateTab);
			String cityTab = driver.findElement(By.id("city")).getText();
			Assert.assertEquals("CITY", cityTab);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 3)
	public void addZoneTest() throws InterruptedException {
		try {
			String homeButton = driver.findElement(By.xpath("//div/div/ba-content-top/div/ul/li/a")).getText();
			Assert.assertEquals("Home", homeButton);
			String backButton = driver.findElement(By.xpath("//pages/div/div/masters/create-zoneentry/div/button"))
					.getText();
			Assert.assertEquals("  Back", backButton);
			String saveButton = driver.findElement(By.xpath("//form/div[2]/div/button")).getText();
			Assert.assertEquals("Save", saveButton);
			String cancelButton = driver.findElement(By.xpath("//form/div[2]/div/button[2]")).getText();
			Assert.assertEquals("Cancel", cancelButton);

			WebElement saveBtnDisabled = driver.findElement(By.xpath("//form/div[2]/div/button"));
			result = saveBtnDisabled.isEnabled();
			if (result = true) {
				System.out.println("Step 2 - Passed");
			} else {
				System.out.println("Step 2 -Failed");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// To verify Zone with empty field values
	@Test(priority = 4)
	public void verifyAddZoneWithEmptyFieldsTest() throws InterruptedException {
		try {
			driver.findElement(By.id("zone")).click();
			driver.findElement(By.id("code")).click();
			driver.findElement(By.xpath("//html")).click();
			String zoneCodeValMsg = driver.findElement(By.xpath(
					"//div/masters/create-zoneentry/div/ba-card/div/div[2]/ngb-tabset/div/div/zoneentry-zone/form/div/div/div/small"))
					.getText();
			Assert.assertEquals("Zone Code is required.", zoneCodeValMsg);
			System.out.println("Step 1 - Passed");
			driver.findElement(By.id("name")).click();
			driver.findElement(By.xpath("//html")).click();
			Thread.sleep(5000);
			String zoneNameValMsg = driver.findElement(By.xpath(
					"//div/masters/create-zoneentry/div/ba-card/div/div[2]/ngb-tabset/div/div/zoneentry-zone/form/div/div[2]/div/small"))
					.getText();
			Assert.assertEquals("Zone Name is required.", zoneNameValMsg);
			System.out.println("Step 2 - Passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// To verify length of Zone fields
	@Test(priority = 5)
	public void verifyZoneFieldLengthsTest() throws InterruptedException {
		try {
			driver.findElement(By.id("code")).sendKeys("testcode");
			driver.findElement(By.xpath("//html")).click();
			Thread.sleep(3000);
			String codeLenValMsg = driver.findElement(By.xpath(
					"//div/masters/create-zoneentry/div/ba-card/div/div[2]/ngb-tabset/div/div/zoneentry-zone/form/div/div/div/small"))
					.getText();
			Assert.assertEquals("Zone Code must not be greater than 5.", codeLenValMsg);
			System.out.println("Step 1 - Passed");
			driver.findElement(By.id("code")).clear();
			driver.findElement(By.id("code")).sendKeys("t");
			driver.findElement(By.xpath("//html")).click();
			Thread.sleep(3000);
			String codeLenValMsg2 = driver.findElement(By.xpath(
					"//div/masters/create-zoneentry/div/ba-card/div/div[2]/ngb-tabset/div/div/zoneentry-zone/form/div/div/div/small"))
					.getText();
			Assert.assertEquals("Zone Code must be at least 2.", codeLenValMsg2);
			driver.findElement(By.id("name")).sendKeys("tst");
			driver.findElement(By.xpath("//html")).click();
			Thread.sleep(3000);
			String nameLenValMsg = driver.findElement(By.xpath(
					"//div/masters/create-zoneentry/div/ba-card/div/div[2]/ngb-tabset/div/div/zoneentry-zone/form/div/div[2]/div/small"))
					.getText();
			Assert.assertEquals("Zone Name must be at least 4.", nameLenValMsg);
			System.out.println("DMND_GL_TC_05 - Passed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// To verify add Zone with proper input
	@Test(priority = 6)
	public void verifyAddZoneTest() throws InterruptedException {
		try {
			driver.findElement(By.id("code")).clear();
			driver.findElement(By.id("code")).sendKeys("test");
			String codeValue = driver.findElement(By.id("code")).getAttribute("value");
			Assert.assertEquals("test", codeValue);
			driver.findElement(By.id("name")).clear();
			driver.findElement(By.id("name")).sendKeys("ZoneName");
			String nameValue = driver.findElement(By.id("name")).getAttribute("value");
			Assert.assertEquals("ZoneName", nameValue);
			driver.findElement(By.xpath("//form/div[2]/div/button")).click();
			String successMsg = driver.findElement(By.tagName("body")).getText();
			Assert.assertEquals(true, successMsg.contains("Zone Successfully Saved! Go To Next Tab"));
			driver.findElement(By.xpath("//form/div[2]/div/button[2]")).click();
			String geoLocUrl = driver.getCurrentUrl();
			Assert.assertEquals(geoLocUrl,
					"http://www.nmbr.derp.com.s3-website.ap-south-1.amazonaws.com/#/pages/masters/zoneEntry");
			driver.findElement(By.xpath("//div/div/ba-content-top/div/ul/li/a")).click();
			String urlHome = driver.getCurrentUrl();
			Assert.assertEquals(urlHome,
					"http://www.nmbr.derp.com.s3-website.ap-south-1.amazonaws.com/#/pages/dashboard");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Edit Zone//no proper code
	@Test(priority = 7)
	public void editZoneTest() throws InterruptedException {
		try {
			driver.findElement(By.linkText("Geographical Location")).click();
			// driver.findElement(By.className("ion-edit")).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
