package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.TEDU_CapNhatMK_Page;

public class TEDU_CapNhatMK_Test extends CommonBase
{
	@BeforeMethod
	public void openWebPage()
	{
		driver = initChromeDriver(CT_PageURL.TEDU_URL);
		
	}
	
	@Test
	public void loginSuccessfully()
	{
		TEDU_CapNhatMK_Page tedu = new TEDU_CapNhatMK_Page(driver);
		tedu.LoginFunction("khanhtrangdt5@gmail.com", "TrangNK26@9");
		WebElement avatar = driver.findElement(By.xpath("//a[@title='Tài khoản' and @data-toggle='dropdown']"));
		assertTrue(avatar.isDisplayed());
	}
	@Test
	public void searchCourse1()
	{
		loginSuccessfully();
		driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("ASP Net");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement result1 = driver.findElement(By.xpath("//div[@class='container' and contains(., 'Kết quả tìm kiếm: ASP Net')]"));
		WebElement result2 = driver.findElement(By.xpath("//h3[contains(., 'ASP NET sử dụng SMTP')]"));
		assertTrue(result1.isDisplayed());
		assertTrue(result2.isDisplayed());
	}
	@Test
	public void searchCourse2()
	{
		loginSuccessfully();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByName('keyword')[0].setAttribute('value', 'ASP Net');");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement result1 = driver.findElement(By.xpath("//div[@class='container' and contains(., 'Kết quả tìm kiếm: ASP Net')]"));
		WebElement result2 = driver.findElement(By.xpath("//h3[contains(., 'ASP NET sử dụng SMTP')]"));
		assertTrue(result1.isDisplayed());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", result2);
		assertTrue(result2.isDisplayed());

	}
	@Test
	public void updatePassword()
	{
		loginSuccessfully();
		TEDU_CapNhatMK_Page tedu = new TEDU_CapNhatMK_Page(driver);
		tedu.changePassword("TrangNTK26@9", "TrangNK26@9");
		WebElement avatar = driver.findElement(By.xpath("//h2[text()='Đăng nhập']"));
		assertTrue(avatar.isDisplayed());
	}

}
