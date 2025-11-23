package automation.testsuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BTVNday12_bai2 extends CommonBase
{
	@Test
	public void clickRadioButton()
	{
		driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);
		//Kiểm tra giá trị mặc định chưa được check
		WebElement radiounder18 = driver.findElement(By.id("under_18"));
		WebElement radioover18 = driver.findElement(By.id("over_18"));
		WebElement radiodisabled = driver.findElement(By.id("radio-disabled"));
		boolean under18 = radiounder18.isSelected();
	
		assertFalse(under18);
		assertFalse(radioover18.isSelected());
		assertFalse(radiodisabled.isSelected());
		
		driver.findElement(By.xpath("//input[@id='under_18']")).click();
//		femaleRadio.click();
		assertTrue(radiounder18.isSelected());

	}

}
