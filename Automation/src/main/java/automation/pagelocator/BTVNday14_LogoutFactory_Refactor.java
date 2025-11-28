package automation.pagelocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BTVNday14_LogoutFactory_Refactor
{

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//img[@class='avatar avatar--md rounded-circle el-popover__reference']")
    private WebElement avatarIcon;

    @FindBy(xpath = "//i[@class='fa fa-sign-out-alt']")
    private WebElement logoutButton;

    public BTVNday14_LogoutFactory_Refactor (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** 
     * Logout function using explicit wait for stability
     */
    public void BTVNday14logoutFunctionRefactor() {
        waitForElementClickable(avatarIcon).click();
        waitForElementClickable(logoutButton).click();
    }

    // ========= PRIVATE SUPPORT METHODS =========

    private WebElement waitForElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
