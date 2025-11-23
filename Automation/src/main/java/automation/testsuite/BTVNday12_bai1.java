package automation.testsuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BTVNday12_bai1 extends CommonBase
{

	@Test
	public void SelectCountry()
	{
		driver = initChromeDriver(CT_PageURL.GLOBALSQA_URL);
	    WebElement dropdlCountry = driver.findElement(By.xpath("//div[@rel-title='Select Country']//select"));
	    WebElement optAfghanistan = driver.findElement(By.xpath("//option[text()='Afghanistan']"));
	    assertTrue(optAfghanistan.isSelected(), "Afghanistan must be selected by default!");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",dropdlCountry);
	    WebElement optAustralia = driver.findElement(By.xpath("//option[text()='Australia']"));
	    optAustralia.click();
	    assertTrue(optAustralia.isSelected(), "Australia should be selected after clicking!");
	}
}
