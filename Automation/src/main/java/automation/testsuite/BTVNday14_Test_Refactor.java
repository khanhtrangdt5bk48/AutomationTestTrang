package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.BTVNday14_ChangepwdFactory_Refactor;
import automation.pagelocator.BTVNday14_LoginFactory_Refactor;
import automation.pagelocator.BTVNday14_LogoutFactory_Refactor;

public class BTVNday14_Test_Refactor extends CommonBase {

    @BeforeMethod
    public void openWebsite() {
        driver = initChromeDriver(CT_PageURL.VIBLO_URL);
    }

    // ======= COMMON METHOD =======
    private void login(String email, String password) {
        BTVNday14_LoginFactory_Refactor loginPage = new BTVNday14_LoginFactory_Refactor(driver);
        loginPage.BTVNday14loginFunctionRefactor(email, password);
    }

    private WebElement waitForVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ======= TEST CASES =======

    @Test
    public void loginVibloSuccessfully() {
        login("khanhtrangdt5@gmail.com", "12345678");
        WebElement welcomeMsg = waitForVisible(By.xpath("//h1[normalize-space()='Chào mừng, TrangNTK']"));
        assertTrue(welcomeMsg.isDisplayed(), "Login failed: Welcome message not displayed");
    }

    @Test
    public void loginVibloFailed() {
        login("khanhtrandt5@gmail.com", "11111111");
        WebElement errorMsg = waitForVisible(By.xpath("//span[normalize-space()='Wrong username/email or password']"));
        assertTrue(errorMsg.isDisplayed(), "Error message not displayed for invalid login");
    }

    @Test
    public void logoutVibloSuccessfully() {
        login("khanhtrangdt5@gmail.com", "12345678");

        BTVNday14_LogoutFactory_Refactor logoutPage = new BTVNday14_LogoutFactory_Refactor(driver);
        logoutPage.BTVNday14logoutFunctionRefactor();

        WebElement loginTitle = waitForVisible(By.xpath("//h5[normalize-space()='Đăng nhập vào Viblo']"));
        assertTrue(loginTitle.isDisplayed(), "Logout failed: Login page is not displayed");
    }

    @Test
    public void changePasswordAndLoginAgain() {
        // Step 1: Login
        login("khanhtrangdt5@gmail.com", "12345678");

        // Step 2: Change password
        BTVNday14_ChangepwdFactory_Refactor changePwdPage = new BTVNday14_ChangepwdFactory_Refactor(driver);
        changePwdPage.BTVNday14changePasswordFunctionRefactor("12345678", "87654321", "87654321");

        WebElement successMsg = waitForVisible(
                By.xpath("//p[contains(@class,'el-message__content') and contains(text(),'Mật khẩu đã được thay đổi')]"));
        assertTrue(successMsg.isDisplayed(), "Password change message not displayed");

        // Step 3: Logout
        BTVNday14_LogoutFactory_Refactor logoutPage = new BTVNday14_LogoutFactory_Refactor(driver);
        logoutPage.BTVNday14logoutFunctionRefactor();

        WebElement loginTitle = waitForVisible(By.xpath("//h5[normalize-space()='Đăng nhập vào Viblo']"));
        assertTrue(loginTitle.isDisplayed(), "Logout after change password failed");

        // Step 4: Login with new password
        login("khanhtrangdt5@gmail.com", "87654321");

        WebElement welcomeMsg = waitForVisible(By.xpath("//h1[normalize-space()='Chào mừng, TrangNTK']"));
        assertTrue(welcomeMsg.isDisplayed(), "Login with new password failed");
    }
}
