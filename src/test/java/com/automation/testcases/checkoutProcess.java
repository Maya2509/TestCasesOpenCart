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



public class checkoutProcess {
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
  public void testCheckout() throws Exception {
	 driver.get("http://localhost/opencartsite/index.php");
    driver.findElement(By.linkText("Desktops")).click();
    driver.findElement(By.linkText("Mac (1)")).click();
    driver.get("http://localhost/opencartsite/index.php?route=product/category&language=en-gb&path=20_27");
    driver.findElement(By.xpath("//img[@alt='iMac']")).click();
    driver.get("http://localhost/opencartsite/index.php?route=product/product&language=en-gb&path=20_27&product_id=41");
    driver.findElement(By.id("button-cart")).click();
    driver.findElement(By.xpath("//div[@id='header-cart']/div/button")).click();
    driver.findElement(By.xpath("//div[@id='header-cart']/div/ul/li/div/p/a[2]/strong")).click();
    driver.get("http://localhost/opencartsite/index.php?route=checkout/checkout&language=en-gb");
    driver.findElement(By.id("input-shipping-firstname")).click();
    driver.findElement(By.id("input-shipping-firstname")).clear();
    driver.findElement(By.id("input-shipping-firstname")).sendKeys("jef");
    driver.findElement(By.id("input-shipping-lastname")).click();
    driver.findElement(By.id("input-shipping-lastname")).clear();
    driver.findElement(By.id("input-shipping-lastname")).sendKeys("loa");
    driver.findElement(By.id("input-shipping-address-1")).click();
    driver.findElement(By.id("input-shipping-address-1")).clear();
    driver.findElement(By.id("input-shipping-address-1")).sendKeys("ala");
    driver.findElement(By.id("input-shipping-city")).click();
    driver.findElement(By.id("input-shipping-city")).clear();
    driver.findElement(By.id("input-shipping-city")).sendKeys("san@#");
    driver.findElement(By.id("input-shipping-postcode")).click();
    driver.findElement(By.id("input-shipping-postcode")).clear();
    driver.findElement(By.id("input-shipping-postcode")).sendKeys("548769H@");
    driver.findElement(By.id("input-shipping-country")).click();
    new Select(driver.findElement(By.id("input-shipping-country"))).selectByVisibleText("Andorra");
    driver.findElement(By.id("input-shipping-zone")).click();
    new Select(driver.findElement(By.id("input-shipping-zone"))).selectByVisibleText("Canillo");
    driver.findElement(By.id("input-comment")).click();
    driver.findElement(By.id("input-comment")).clear();
    driver.findElement(By.id("input-comment")).sendKeys("gh,m");
    driver.findElement(By.id("button-shipping-address")).click();
    driver.findElement(By.id("input-shipping-method")).click();
    new Select(driver.findElement(By.id("input-shipping-method"))).selectByVisibleText("Flat Shipping Rate - $5.00");
    driver.findElement(By.id("input-payment-method")).click();
    new Select(driver.findElement(By.id("input-payment-method"))).selectByVisibleText("Cash On Delivery");
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