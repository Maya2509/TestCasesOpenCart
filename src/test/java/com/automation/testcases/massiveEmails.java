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

public class massiveEmails {
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
  public void testMassiveEmails() throws Exception {
    driver.get("http://localhost/opencartsite/admin/");
    driver.findElement(By.id("input-username")).click();
    driver.findElement(By.id("input-username")).clear();
    driver.findElement(By.id("input-username")).sendKeys("admin");
    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("admin");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//div[@id='modal-security']/div/div/div/button")).click();
    driver.findElement(By.xpath("//*[@id=\"button-menu\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"menu-marketing\"]/a")).click();      
    driver.findElement(By.xpath("//*[@id=\"collapse-6\"]/li[2]/a")).click();  
    driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[7]/ul/li[4]/a"));
    driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[7]/ul/li[4]/a")).click();
    driver.findElement(By.id("input-store")).click();
    driver.findElement(By.id("input-to")).click();
    new Select(driver.findElement(By.id("input-to"))).selectByVisibleText("All Customers");
    driver.findElement(By.id("input-subject")).click();
    driver.findElement(By.id("input-subject")).clear();
    driver.findElement(By.id("input-subject")).sendKeys("QA Test");
    driver.findElement(By.xpath("/html/body/p")).click();
    driver.findElement(By.xpath("/html/body/p")).sendKeys("QA Test");
    driver.findElement(By.id("button-send")).click();
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
