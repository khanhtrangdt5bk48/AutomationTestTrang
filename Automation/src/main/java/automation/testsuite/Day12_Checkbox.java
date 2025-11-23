package automation.testsuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

//import java.awt.List;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_Checkbox extends CommonBase
{
	@Test
	public void checkboxHandle()
	{
		driver = initFirefoxDriver(CT_PageURL.DEMOQA_URL);
//Case1: kiểm tra giá trị mặc định theo yêu cầu REQ, các checkbox với giá trị mặc định là chưa được check
		WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
		WebElement readCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
		WebElement musicCheckbox = driver.findElement(By.id("hobbies-checkbox-3"));
		//Mong đợi cả 3 checkbox đều chưa được check
		boolean checkSport = sportCheckbox.isSelected();
		boolean checkRead = readCheckbox.isSelected();
		boolean checkMusic = musicCheckbox.isSelected();
		
		assertFalse(checkSport);
		assertFalse(checkRead);
		assertFalse(checkMusic);
		
	}
	@Test
	public void clickToCheckbox()
	{
		driver = initFirefoxDriver(CT_PageURL.DEMOQA_URL);
		WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
		WebElement readCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
		WebElement musicCheckbox = driver.findElement(By.id("hobbies-checkbox-3"));
		if(sportCheckbox.isSelected() == false)
		{
			driver.findElement(By.xpath("//label[text()='Sports']")).click();
//			sportCheckbox.click();
			assertTrue(sportCheckbox.isSelected());
		}
		if(readCheckbox.isSelected() == false)
		{
			driver.findElement(By.xpath("//label[text()='Reading']")).click();
//			readCheckbox.click();
			assertTrue(readCheckbox.isSelected());
		}
		if(musicCheckbox.isSelected() == false)
		{
			driver.findElement(By.xpath("//label[text()='Music']")).click();
//			musicCheckbox.click();
			assertTrue(musicCheckbox.isSelected());
		}
	}
	@Test
	public void clickToListCheckbox()
	{
		driver = initFirefoxDriver(CT_PageURL.DEMOQA_URL);
		WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
		WebElement readCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
		WebElement musicCheckbox = driver.findElement(By.id("hobbies-checkbox-3"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sportCheckbox);
		List<WebElement> listCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
		for (WebElement webElement : listCheckbox)
		{
			if(webElement.isSelected()==false)
			{
				webElement.click();
			}
			
		}
		assertTrue(sportCheckbox.isSelected());
		assertTrue(readCheckbox.isSelected());
		assertTrue(musicCheckbox.isSelected());		
	}	

}
