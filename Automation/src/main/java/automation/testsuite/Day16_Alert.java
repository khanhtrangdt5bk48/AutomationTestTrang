package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day16_Alert extends CommonBase
{
	@BeforeMethod
	public void openWebPage()
	{
		driver = initChromeDriver(CT_PageURL.DELETE_CUS_URL);
	}
	@Test
	public void deleteCustomerSuccessfully()
	{
		type(By.name("cusid"),"234");
		click(By.name("submit"));
		driver.switchTo().alert().accept();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		String actualMessage = driver.switchTo().alert().getText();
		assertEquals(actualMessage, "Customer Successfully Delete!");
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='Delete Customer Form']")));
		closeDriver();
	}

}
