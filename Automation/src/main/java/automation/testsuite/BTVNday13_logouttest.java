package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.LoginPage;


public class BTVNday13_logouttest extends CommonBase
{
//	@Test
	//Tham khảo chatGPT
//	public void logoutSuccessfully()
//	{
//	    driver = initFirefoxDriver(CT_PageURL.CRMSTAR_URL);
//
//	    LoginPage login = new LoginPage(driver);
//	    login.LoginFunction("admin@gmail.com", "12345678");
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    WebElement textQuanLyND = wait.until(
//	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Quản lý người dùng']"))
//	    );
//	    assertTrue(textQuanLyND.isDisplayed());
//
//	    WebElement admin = driver.findElement(By.id("dropdownMenuLink"));
//	    admin.click();
//
//	    WebElement openLogoutModal = wait.until(
//	    	    ExpectedConditions.elementToBeClickable(
//	    	        By.xpath("//*[contains(text(),'Đăng xuất') and (self::a or self::button)]")
//	    	    )
//	    	);
//	    	openLogoutModal.click();
//
//
//	    WebElement btnLogoutConfirm = wait.until(
//	        ExpectedConditions.elementToBeClickable(
//	            By.xpath("//button[@form='logout' and @type='submit']")
//	        )
//	    );
//	    btnLogoutConfirm.click();
//	}
	@Test
	public void logoutSuccessfully()
	{
	    driver = initFirefoxDriver(CT_PageURL.CRMSTAR_URL);

	    LoginPage login = new LoginPage(driver);
	    login.LoginFunction("admin@gmail.com", "12345678");

	    // không dùng WebDriverWait, chỉ dùng implicit wait
	    WebElement textQuanLyND = driver.findElement(By.xpath("//p[text()='Quản lý người dùng']"));
	    assertTrue(textQuanLyND.isDisplayed());
	    
	    try {
	        Thread.sleep(30000); // 30 giây
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
	    WebElement admin = driver.findElement(By.id("dropdownMenuLink"));
	    admin.click();

	    // click Đăng xuất trong dropdown
	    WebElement openLogoutModal = driver.findElement(
	        By.xpath("//form[@id='logout']")
	    );
	    openLogoutModal.click();

	    try {
	        Thread.sleep(10000); // 30 giây
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
	    // click nút xác nhận
	    WebElement btnLogoutConfirm = driver.findElement(
	        By.xpath("//div[@class='modal-footer']//button[contains(normalize-space(),'Đăng xuất')]")
	    );
	    btnLogoutConfirm.click();
	    try {
	        Thread.sleep(10000); // 30 giây
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    // verify quay lại login
	    WebElement loginHeading = driver.findElement(
	        By.xpath("//h4[text()='Đăng nhập']/..")
	    );
	    assertTrue(loginHeading.isDisplayed());
	}


}
