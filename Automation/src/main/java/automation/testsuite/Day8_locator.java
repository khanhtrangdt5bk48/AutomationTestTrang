package automation.testsuite;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day8_locator extends CommonBase
{
	@Test
	public void getElementById()
	{
		driver = initChromeDriver(CT_PageURL.RISE_URL);
		WebElement email = driver.findElement(By.id("email"));
		System.out.println("Email element is:"+email);
		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Password element is:"+password);
	}
	@Test
	public void getElementByLinkText()
	{
		driver = initChromeDriver(CT_PageURL.BEPANTOAN_URL);
		WebElement mayhutmuiLink = driver.findElement(By.linkText("Máy Hút Mùi"));
		System.out.println("Máy hút mùi là:"+mayhutmuiLink);
		WebElement ruachen = driver.findElement(By.partialLinkText("Rửa Chén"));
		System.out.println("Máy Rửa Chén bát là: "+ruachen);
	}
	@Test
	public void getElementClassName_TagName()
	{
		driver = initChromeDriver(CT_PageURL.BEPANTOAN_URL);
		WebElement h1 = driver.findElement(By.className("inline-block"));
		System.out.println("Top Máy hút mùi tốt nhất cho gia đình"+h1);
		WebElement h3 = driver.findElement(By.tagName("h3"));
		System.out.println("h3 is: "+h3);
		
	}

}
