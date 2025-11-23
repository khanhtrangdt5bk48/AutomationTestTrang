package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BTVNday12_bai3 extends CommonBase
{

	@Test
	public void jobRole1()
	{
		driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);
	    WebElement dropdlRole1 = driver.findElement(By.xpath("//select[@id='job1']"));
	    WebElement optAutomation = driver.findElement(By.xpath("//option[text()='Automation Testing']"));
	    assertTrue(optAutomation.isSelected(), "Automation must be selected by default!");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdlRole1);
	    WebElement optManual = driver.findElement(By.xpath("//option[text()='Manual Testing']"));
	    optManual.click();
	    assertTrue(optManual.isSelected(), "Manual should be selected after clicking!");
	}
}
