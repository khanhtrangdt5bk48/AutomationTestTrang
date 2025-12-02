package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BTVNday16_bai1 extends CommonBase {

    @BeforeMethod
    public void openWebpage() {
        driver = initFirefoxDriver(CT_PageURL.CRMSTAR_URL);
    }

    @Test
    public void loginSuccessfully() {
        type(By.id("email"), "admin@gmail.com");
        type(By.id("password"), "12345678");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 150)");
        click(By.name("signin"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("User Management"));
    }

    @Test
    public void openQuanLyKLV() {
        loginSuccessfully();
        click(By.xpath("//a[normalize-space(text())='Quản lý khu làm việc']"));

        WebElement textQuanLyKLV = driver.findElement(
                By.xpath("//p[normalize-space(text())='Quản lý khu làm việc']"));
        assertTrue(textQuanLyKLV.isDisplayed());
    }

    @Test
    public void addKLV() {
        openQuanLyKLV();
        click(By.xpath("//button[text()='Thêm mới']"));

        type(By.name("work_areas_code"), "NTK110");
        type(By.name("name"), "TrangNTK110");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 150)");

        click(By.xpath("//button[text()='Lưu']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@id='myModal']//button[normalize-space()='Thêm']")));
        click(By.xpath("//button[text()='Thêm']"));

        // Check hiển thị thêm thành công
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='toast-message' and contains(normalize-space(.),'Thêm mới khu vực làm việc thành công')]")));
        System.out.println(toast.getText());

        closeDriver();
    }

    @Test
    public void searchQuanLyKVL() {
        openQuanLyKLV();
        type(By.name("query"), "TrangNTK");
        click(By.xpath("//button[text()='Tìm kiếm']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody/tr"));
        assertFalse(rows.isEmpty());
    }

    @Test
    public void xoaKVL() {
        searchQuanLyKVL();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Xóa phần từ vừa được add vào
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//td[normalize-space()='TrangNTK110']/following-sibling::td//a[contains(text(),'Xóa')]")));
        click(By.xpath(".//a[contains(text(),'Xóa')]"));

        String actualMessage = driver.switchTo().alert().getText();
        assertEquals(actualMessage, "Bạn có thực sự muốn xóa khu vực này");
        driver.switchTo().alert().accept();

        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='toast-message' and contains(normalize-space(.),'Xóa khu vực làm việc thành công')]")));
        System.out.println(toast.getText());
        
     // Xóa phần tử đầu tiên được tìm thấy
     // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//              By.xpath("//table//tbody/tr[1]")));
     // click(By.xpath(".//a[contains(text(),'Xóa')]"));

     // String actualMessage = driver.switchTo().alert().getText();
     // assertEquals(actualMessage, "Bạn có thực sự muốn xóa khu vực này");
     // driver.switchTo().alert().accept();

     // WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
//              By.xpath("//div[@class='toast-message' and contains(normalize-space(.),'Xóa khu vực làm việc thành công')]")));
     // System.out.println(toast.getText());


        closeDriver();
    }
}
