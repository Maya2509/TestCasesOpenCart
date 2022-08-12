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

public class changeCurrency {
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
  public void testChangeCurrency() throws Exception {
    driver.get("http://localhost/opencartsite/index.php?route=checkout/cart&language=en-gb");
    driver.findElement(By.xpath("//img[@alt='Your Store']")).click();
    driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
    driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/a")).click();
    driver.findElement(By.linkText("$ US Dollar")).click();
    driver.findElement(By.xpath("//form[@id='form-currency']/div")).click();
    driver.findElement(By.xpath("//form[@id='form-currency']/div/a/span")).click();
    driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/a")).click();
    driver.findElement(By.xpath("//form[@id='form-currency']/div/a/span")).click();
    driver.findElement(By.linkText("£ Pound Sterling")).click();
    driver.findElement(By.xpath("//form[@id='form-currency']/div/a/span")).click();
    driver.findElement(By.linkText("$ US Dollar")).click();
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


