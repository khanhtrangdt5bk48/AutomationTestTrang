package automation.common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonBase 
{
	public  static WebDriver driver; //thuộc tính
	public WebDriver initFirefoxDriver(String URL)
	{
		System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public WebDriver initChromeDriver(String URL)
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public void closeDriver()
	{
		if(driver != null)
			driver.close();
	}

}
