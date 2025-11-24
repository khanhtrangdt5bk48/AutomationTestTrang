package automation.pagelocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BTVNday14_LogoutFactory 
{
	private WebDriver driver;
	@FindBy(xpath="//img[@class='avatar avatar--md rounded-circle el-popover__reference']") WebElement itemImage;
//	@FindBy(xpath="//div[@class='user-menu__menu-item']") WebElement menuUser;
	@FindBy(xpath="//i[@class='fa fa-sign-out-alt']") WebElement btnDangXuat;
	public BTVNday14_LogoutFactory(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void BTVNday14LogoutFunction()
	{
		itemImage.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		menuUser.click();
		btnDangXuat.click();
	}
	
	

}
