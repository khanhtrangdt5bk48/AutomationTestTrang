package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.BTVNday14_ChangepwdFactory;
import automation.pagelocator.BTVNday14_LoginFatory;
import automation.pagelocator.BTVNday14_LogoutFactory;

public class BTVNday14_test extends CommonBase
{
	@BeforeMethod
	public void openWebstie()
	{
		driver = initChromeDriver(CT_PageURL.VIBLO_URL);
	}
	@Test
	public void LoginVibloSuccessfully()
	{
		BTVNday14_LoginFatory login = new BTVNday14_LoginFatory(driver);
		login.BTVNday14loginFunction("khanhtrangdt5@gmail.com", "12345678");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Chào mừng, TrangNTK']")).isDisplayed());
	}
	@Test
	public void LoginVibloFailed()
	{
		BTVNday14_LoginFatory login = new BTVNday14_LoginFatory(driver);
		login.BTVNday14loginFunction("khanhtrandt5@gmail.com", "11111111");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Wrong username/email or password']")).isDisplayed());
	}
	@Test
	public void LogoutVibloSuccessfully()
	{
		LoginVibloSuccessfully();
		BTVNday14_LogoutFactory logout = new BTVNday14_LogoutFactory(driver);
		logout.BTVNday14LogoutFunction();
		assertTrue(driver.findElement(By.xpath("//h5[normalize-space()='Đăng nhập vào Viblo']")).isDisplayed());
	}
	@Test
	public void ChangePwd()
	{
		LoginVibloSuccessfully();
		BTVNday14_ChangepwdFactory change = new BTVNday14_ChangepwdFactory(driver);
		change.BTVNday14ChangePwdFunction("12345678", "87654321", "87654321");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		assertTrue(driver.findElement(By.xpath("//p[contains(@class,'el-message__content') and contains(text(),'Mật khẩu đã được thay đổi')]")).isDisplayed());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement successMsg = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//p[contains(@class,'el-message__content') and contains(text(),'Mật khẩu đã được thay đổi')]")
		    )
		);

		assertTrue(successMsg.isDisplayed());
		BTVNday14_LogoutFactory logout = new BTVNday14_LogoutFactory(driver);
		logout.BTVNday14LogoutFunction();
		assertTrue(driver.findElement(By.xpath("//h5[normalize-space()='Đăng nhập vào Viblo']")).isDisplayed());;
		BTVNday14_LoginFatory login = new BTVNday14_LoginFatory(driver);
		login.BTVNday14loginFunction("khanhtrangdt5@gmail.com", "87654321");	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Chào mừng, TrangNTK']")).isDisplayed());
		}

}
