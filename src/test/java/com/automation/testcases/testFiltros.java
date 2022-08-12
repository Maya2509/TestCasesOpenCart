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

public class testFiltros {
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
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300000));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testFiltros() throws Exception {
    driver.get("http://localhost/opencartsite/");
    driver.findElement(By.name("search")).click();
    driver.findElement(By.name("search")).clear();
    driver.findElement(By.name("search")).sendKeys("apple");
    driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("input-category")).click();
    new Select(driver.findElement(By.id("input-category"))).selectByVisibleText("Phones & PDAs");
    driver.findElement(By.id("button-search")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Checkout'])[1]/following::main[1]")).click();
    driver.findElement(By.id("input-search")).click();
    driver.findElement(By.id("input-search")).clear();
    driver.findElement(By.id("input-search")).sendKeys("");
    driver.findElement(By.id("button-search")).click();
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

