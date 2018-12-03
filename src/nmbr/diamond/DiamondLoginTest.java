package nmbr.diamond;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DiamondLoginTest extends DiamondLaunchTest {

	final private String userName_value = "Swastik";
	final private String password_value = "Password@123";
	Select oGroup, oCompany;

	@Test
	private void loginInvalidCredentialsTest() throws InterruptedException {
		driver.findElement(By.id("inputUserName")).sendKeys(userName_value);
		driver.findElement(By.id("inputPassword3")).sendKeys("abcd");
		oGroup = new Select(driver.findElement(By.id("inputGroup")));
		oGroup.selectByVisibleText("Diamond");
		oCompany = new Select(driver.findElement(By.id("inputCompany")));
		oCompany.selectByVisibleText("SAM EXPORT");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-auth']")).click();
		Thread.sleep(3000);
		String actual = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		Assert.assertEquals(actual, "Username or password incorrect.");
	}

	@Test
	private void loginValidCredentialsTest() throws InterruptedException {
		driver.findElement(By.id("inputUserName")).clear();
		driver.findElement(By.id("inputUserName")).sendKeys(userName_value);
		driver.findElement(By.id("inputPassword3")).clear();
		driver.findElement(By.id("inputPassword3")).sendKeys(password_value);
		oGroup = new Select(driver.findElement(By.id("inputGroup")));
		oGroup.selectByVisibleText("Diamond");
		oCompany = new Select(driver.findElement(By.id("inputCompany")));
		oCompany.selectByVisibleText("SAM EXPORT");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-auth']")).click();
	}
}
