package com.automation.testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

public class modificarUsuario {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testModificarUsuario() throws Exception {
	driver.get("http://localhost/opencartsite/admin/");
    driver.findElement(By.id("input-username")).click();
	driver.findElement(By.id("input-username")).sendKeys("admin");
	driver.findElement(By.id("input-password")).click();
	driver.findElement(By.id("input-password")).sendKeys("admin");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//div[@id='modal-security']/div/div/div/button")).click();
    driver.findElement(By.xpath("//button[@id='button-menu']/i")).click();
    driver.findElement(By.linkText("Customers")).click();
    driver.findElement(By.xpath("//ul[@id='collapse-5']/li/a")).click();
    driver.get("http://localhost/opencartsite/admin/index.php?route=customer/customer&user_token=ac5837fad8849062876071b9f4729884");
    driver.findElement(By.xpath("//form[@id='form-customer']/div/table/tbody/tr/td[7]/div/a/i")).click();
    driver.get("http://localhost/opencartsite/admin/index.php?route=customer/customer|form&user_token=ac5837fad8849062876071b9f4729884&customer_id=3");
    driver.findElement(By.id("input-firstname")).click();
    driver.findElement(By.id("input-firstname")).clear();
    driver.findElement(By.id("input-firstname")).sendKeys("Jeff");
    driver.findElement(By.id("input-lastname")).click();
    driver.findElement(By.id("input-lastname")).click();
    driver.findElement(By.id("input-lastname")).clear();
    driver.findElement(By.id("input-lastname")).sendKeys("Rodriguez");
    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("blablabla@gmail.com");
    driver.findElement(By.id("input-telephone")).click();
    driver.findElement(By.id("input-telephone")).clear();
    driver.findElement(By.id("input-telephone")).sendKeys("888888888");
    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("12345678test");
    driver.findElement(By.id("input-confirm")).click();
    driver.findElement(By.id("input-confirm")).clear();
    driver.findElement(By.id("input-confirm")).sendKeys("12345678test");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
