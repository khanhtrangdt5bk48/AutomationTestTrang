package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.LoginPage;

public class LoginTest extends CommonBase
{
	@BeforeMethod
	public void openWebPage()
	{
		driver = initFirefoxDriver(CT_PageURL.CRMSTAR_URL);
	}
	@Test
	public void loginSuccessfully()
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		WebElement textQuanLyND = driver.findElement(By.xpath("//p[text()='Quản lý người dùng']"));
		assertTrue(textQuanLyND.isDisplayed());
	}
	@Test
	public void loginFailed()
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin1111@gmail.com", "12345678");
		WebElement error = driver.findElement(By.xpath("//h4[text()='Đăng nhập']"));
		assertTrue(error.isDisplayed());
	}
}
