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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class giftCertificates {
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
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testGiftCertificates() throws Exception {
    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
    driver.findElement(By.xpath("//img[@alt='Your Store']")).click();
    WebElement element = driver.findElement(By.xpath("/html/body/footer/div/div/div[3]/ul/li[2]/a"));
    js.executeScript("arguments[0].scrollIntoView(true);",element);
    driver.findElement(By.xpath("/html/body/footer/div/div/div[3]/ul/li[2]/a")).click();
    driver.get("http://localhost/opencartsite/index.php?route=checkout/voucher&language=en-gb");
    driver.findElement(By.id("input-to-name")).click();
    driver.findElement(By.id("input-to-name")).clear();
    driver.findElement(By.id("input-to-name")).sendKeys("Random User");
    driver.findElement(By.id("input-to-email")).click();
    driver.findElement(By.id("input-to-email")).clear();
    driver.findElement(By.id("input-to-email")).sendKeys("user@gmail.com");
    driver.findElement(By.id("input-from-name")).click();
    driver.findElement(By.id("input-from-name")).clear();
    driver.findElement(By.id("input-from-name")).sendKeys("QAGroup");
    driver.findElement(By.id("input-from-email")).click();
    driver.findElement(By.id("input-from-email")).clear();
    driver.findElement(By.id("input-from-email")).sendKeys("qaopencart@gmail.com");
    driver.findElement(By.id("input-theme-8")).click();
    driver.findElement(By.id("input-message")).click();
    driver.findElement(By.id("input-message")).clear();
    driver.findElement(By.id("input-message")).sendKeys("Test Case");
    driver.findElement(By.id("input-amount")).click();
    driver.findElement(By.id("input-amount")).clear();
    driver.findElement(By.id("input-amount")).sendKeys("100");
    driver.findElement(By.name("agree")).click();
    driver.findElement(By.xpath("//form[@id='form-voucher']/div[8]/div/button")).click();
    driver.get("http://localhost/opencartsite/index.php?route=checkout/voucher|success&language=en-gb");
    driver.findElement(By.linkText("Continue")).click();
    driver.get("http://localhost/opencartsite/index.php?route=checkout/cart&language=en-gb");
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

