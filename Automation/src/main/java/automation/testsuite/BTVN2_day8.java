package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BTVN2_day8 extends CommonBase {
	@Test
	public void BTVN2_day8_locator() {
		driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);
		WebElement submitform = driver.findElement(By.id("login-form"));
		System.out.println("Form login" + submitform);
		WebElement name = driver.findElement(By.id("name"));
		System.out.println("Name is" + name);
		WebElement address = driver.findElement(By.id("address"));
		System.out.println("Address is" + address);
		WebElement email = driver.findElement(By.id("email"));
		System.out.println("Email is" + email);
		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Password" + password);
	}
	@Test
	public void BTVN2_day8_locator_addlog() {
		driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);

		findElement(By.id("login-form"), "form login");
		findElement(By.id("name"), "Name");
		findElement(By.id("address"), "Address");
		findElement(By.id("email"), "Email");
		findElement(By.id("password"), "Password");
	}

	private WebElement findElement(By locator, String elementName) 
	{
		try
		{
		WebElement element = driver.findElement(locator);
		System.out.println("passed: "+elementName);
		return element;
		}
		catch (Exception e)
		{
			System.out.println("failed: "+elementName);
			return null;
		}
		
	}

}
