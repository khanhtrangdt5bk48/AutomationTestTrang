package automation.pagelocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BTVNday14_LoginFactory_Refactor {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Đăng nhập']")
    private WebElement btnLogin;

    public BTVNday14_LoginFactory_Refactor(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Login to Viblo with username and password.
     */
    public void BTVNday14loginFunctionRefactor(String username, String password) {
        waitForVisible(inputUsername).clear();
        inputUsername.sendKeys(username);

        waitForVisible(inputPassword).clear();
        inputPassword.sendKeys(password);

        waitForClickable(btnLogin).click();
    }

    // ========== PRIVATE WAIT METHODS ==========

    private WebElement waitForVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
