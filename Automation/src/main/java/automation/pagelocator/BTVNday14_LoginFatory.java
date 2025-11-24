package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BTVNday14_LoginFatory 
//khanhtrangdt5@gmail.com/NLinh26@9/TrangNTK84
{
	private WebDriver driver;
	@FindBy(xpath="//input[@type='text']") WebElement textUsername;
	@FindBy(xpath="//input[@type='password']") WebElement textPassword;
	@FindBy(xpath="//button[normalize-space()='Đăng nhập']") WebElement btnDangNhap;
	
	public BTVNday14_LoginFatory(WebDriver driverTest) 
	{
		this.driver = driverTest;
		PageFactory.initElements(driverTest, this);
	}
	public void BTVNday14loginFunction(String username, String password)
	{
		textUsername.sendKeys(username);
		textPassword.sendKeys(password);
		btnDangNhap.click();
//		driver.switchTo().alert().accept();
	}

}
