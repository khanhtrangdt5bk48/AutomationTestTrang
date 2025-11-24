package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.PageLoginFactory;
import automation.pagelocator.PageLogoutFactory;

public class Day14_Test extends CommonBase
{
	@BeforeMethod
	public void openWebPage()
	{
		driver = initFirefoxDriver(CT_PageURL.CRMSTAR_URL);
	}
	@Test
	public void loginSuccessfully()
	{
		PageLoginFactory login = new PageLoginFactory(driver);
		login.LoginFunction("admin@gmail.com","12345678");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
	}
	@Test
	public void logoutSuccessfully()
	{
		loginSuccessfully();
		PageLogoutFactory logout = new PageLogoutFactory(driver);
		logout.LogoutFunction();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		assertTrue(driver.findElement(By.id("login")).isDisplayed());
	}
}
