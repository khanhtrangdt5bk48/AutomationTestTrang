package automation.pagelocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BTVNday14_ChangepwdFactory_Refactor {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[normalize-space()='Mật Khẩu']")
    private WebElement menuPassword;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement inputCurrentPassword;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement inputNewPassword;

    @FindBy(xpath = "(//input[@type='password'])[3]")
    private WebElement inputConfirmPassword;

    @FindBy(xpath = "//button[@type='button']/span[normalize-space()='Đổi mật khẩu']")
    private WebElement btnChangePassword;

    public BTVNday14_ChangepwdFactory_Refactor(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Change password function following POM best practice.
     */
    public void BTVNday14changePasswordFunctionRefactor(String currentPwd, String newPwd, String confirmNewPwd) {

        waitForClickable(menuPassword).click();

        waitForVisible(inputCurrentPassword).clear();
        inputCurrentPassword.sendKeys(currentPwd);

        waitForVisible(inputNewPassword).clear();
        inputNewPassword.sendKeys(newPwd);

        waitForVisible(inputConfirmPassword).clear();
        inputConfirmPassword.sendKeys(confirmNewPwd);

        waitForClickable(btnChangePassword).click();
    }

    // ========== SUPPORT WAIT METHODS ==========

    private WebElement waitForVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
