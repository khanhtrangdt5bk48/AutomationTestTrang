package automation.pagelocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BTVNday14_ChangepwdFactory 
{
	private WebDriver driver;
	@FindBy(xpath="//span[normalize-space()='Mật Khẩu']") WebElement btnMenuItem;
	@FindBy(xpath="(//input[@type='password'])[1]") WebElement textCurrentpwd;
	@FindBy(xpath="(//input[@type='password'])[2]") WebElement textNewpwd;
	@FindBy(xpath="(//input[@type='password'])[3]") WebElement textNewpwdconfirm;
	@FindBy(xpath="//button[@type='button']/span[normalize-space()='Đổi mật khẩu']") WebElement btnDoimatkhau;
	public BTVNday14_ChangepwdFactory(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void BTVNday14ChangePwdFunction(String currentpwd, String newpwd, String newpwdconfirm)
	{
		btnMenuItem.click();
		textCurrentpwd.sendKeys(currentpwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		textNewpwd.sendKeys(newpwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		textNewpwdconfirm.sendKeys(newpwdconfirm);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		btnDoimatkhau.click();
		
	}

}
