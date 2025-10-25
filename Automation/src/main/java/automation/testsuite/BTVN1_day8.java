package automation.testsuite;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BTVN1_day8 extends CommonBase
{
	@Test
	public void BTVN_day8_locator()
	{
		driver = initChromeDriver(CT_PageURL.SELECTORSHUB_URL);
		WebElement user = driver.findElement(By.name("email"));
		System.out.println("User email là:"+user);
		WebElement pwd = driver.findElement(By.id("pass"));
		System.out.println("Mật khẩu là:"+pwd);
		WebElement company = driver.findElement(By.name("company"));
		System.out.println("Công ty là:"+company);
		WebElement mobilenumber = driver.findElement(By.name("mobile number"));
		System.out.println("Số điện thoại di động là:"+mobilenumber);
//		WebElement country = driver.findElement(By.xpath("//label[contains(text(),'Country')]/input"));
//		System.out.println("Đất nước là:"+country);
		WebElement submit = driver.findElement(By.tagName("button"));
		System.out.println("Đồng ý"+submit);	
	}
	@Test
    public void BTVN_day8_locator_addlog()
    {
        driver = initChromeDriver(CT_PageURL.SELECTORSHUB_URL);

        findElement(By.name("email"), "User Email");
        findElement(By.id("pass"), "Mật khẩu");
        findElement(By.name("company"), "Công ty");
        findElement(By.name("mobile number"), "Số điện thoại");
        findElement(By.xpath("//label[contains(text(),'Country')]/input"),"Đất nước");
        findElement(By.tagName("button"), "Nút Submit");
    }

    public WebElement findElement(By locator, String elementName) {
        try {
            WebElement element = driver.findElement(locator);
            System.out.println("PASS ✅  - Tìm thấy: " + elementName);
            return element;
        } catch (Exception e) {
            System.out.println("FAIL ❌ - Không tìm thấy: " + elementName);
            return null;
        }
    }
}
