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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.commons.io.FileUtils;

public class modificarInventario {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;
  //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
  

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testModificarInventario() throws Exception {
    driver.get("http://localhost/opencartsite/admin/");
    driver.findElement(By.id("input-username")).click();
    driver.findElement(By.id("input-username")).sendKeys("admin");
    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).sendKeys("admin");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//*[@id=\"modal-security\"]/div/div/div[1]/button")).click();
    driver.findElement(By.xpath("//*[@id='button-menu']")).click();
    driver.findElement(By.linkText("Catalog")).click();
    driver.findElement(By.linkText("Products")).click();
    driver.findElement(By.xpath("//div[@id='content']/div/div/div/a/i")).click();
    driver.findElement(By.id("input-name-1")).click();
    driver.findElement(By.id("input-name-1")).clear();
    driver.findElement(By.id("input-name-1")).sendKeys("Testing");
    driver.findElement(By.xpath("/html/body")).click();
    driver.findElement(By.id("/html/body")).sendKeys("Testing");
    driver.findElement(By.id("input-meta-title-1")).click();
    driver.findElement(By.id("input-meta-title-1")).clear();
    driver.findElement(By.id("input-meta-title-1")).sendKeys("Test1234");
    driver.findElement(By.xpath("//div[@id='content']/div/div/div/button/i")).click();
    driver.findElement(By.linkText("Data")).click();
    driver.findElement(By.id("input-model")).click();
    driver.findElement(By.id("input-model")).clear();
    driver.findElement(By.id("input-model")).sendKeys("1");
    driver.findElement(By.linkText("Links")).click();
    driver.findElement(By.linkText("Attribute")).click();
    driver.findElement(By.linkText("Option")).click();
    driver.findElement(By.linkText("Subscription")).click();
    driver.findElement(By.linkText("Discount")).click();
    driver.findElement(By.linkText("Special")).click();
    driver.findElement(By.linkText("Image")).click();
    driver.findElement(By.linkText("Reward Points")).click();
    driver.findElement(By.linkText("SEO")).click();
    driver.findElement(By.id("input-keyword-0-1")).click();
    driver.findElement(By.id("input-keyword-0-1")).clear();
    driver.findElement(By.id("input-keyword-0-1")).sendKeys("test");
    driver.findElement(By.xpath("//form[@id='form-product']/ul/li[12]/a")).click();
    driver.findElement(By.linkText("Report")).click();
    driver.findElement(By.xpath("//div[@id='content']/div/div/div/button/i")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    }
 }

