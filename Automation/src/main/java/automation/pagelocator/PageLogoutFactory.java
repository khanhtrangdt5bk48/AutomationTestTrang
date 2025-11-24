package automation.pagelocator;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLogoutFactory 
{
	private WebDriver driver;
	@FindBy(id="dropdownMenuLink") WebElement adminDropdown;
	@FindBy(xpath="//form[@id='logout']") WebElement btnDangXuat;
	@FindBy(xpath="//button[text()='Đăng xuất' and @type='submit']") WebElement btnConfirmDangXuat;

	public PageLogoutFactory(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void LogoutFunction()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		adminDropdown.click();
		btnDangXuat.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		btnConfirmDangXuat.click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement confirm = wait.until(
	        ExpectedConditions.elementToBeClickable(btnConfirmDangXuat)
	    );

	    // 4. Scroll vào view (Firefox bắt buộc nếu nằm dưới)
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirm);

	    // 5. Click logout
	    confirm.click();
		
	}

}
