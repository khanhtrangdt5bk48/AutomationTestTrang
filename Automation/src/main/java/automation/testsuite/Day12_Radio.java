package automation.testsuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_Radio extends CommonBase
{
	@Test
	public void clickToRadio()
	{
		driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
		//kiểm tra giá trị mặc định isSelected là false
		WebElement maleRadio = driver.findElement(By.id("gender-radio-1"));
		WebElement femaleRadio = driver.findElement(By.id("gender-radio-2"));
		WebElement otherRadio = driver.findElement(By.id("gender-radio-3"));
		
		boolean male = maleRadio.isSelected();
		//mong đợi male chưa được chọn với isSelected = false
		assertFalse(male);
//		boolean female = femaleRadio.isSelected();
//		assertFalse(female);
//		boolean other = otherRadio.isSelected();
//		assertFalse(other);
		assertFalse(femaleRadio.isSelected());
		assertFalse(otherRadio.isSelected());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", femaleRadio);
		//click Female
		driver.findElement(By.xpath("//label[text()='Female']")).click();
//		femaleRadio.click();
		assertTrue(femaleRadio.isSelected());



	}

}
