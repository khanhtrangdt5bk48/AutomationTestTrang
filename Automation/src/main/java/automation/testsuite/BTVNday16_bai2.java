package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BTVNday16_bai2 extends CommonBase
{
	@BeforeMethod
	public void openWebPage()
	{
		driver = initFirefoxDriver(CT_PageURL.SELENIUM_PRAC_URL);
	}
	@Test
	public void alertDemo()
	{
		click(By.xpath("//button[@onclick='myFunction()']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		String message = driver.switchTo().alert().getText();
		assertEquals(message, "Welcome to Selenium WebDriver Tutorials");
		driver.switchTo().alert().accept();
        closeDriver();

	}

}
