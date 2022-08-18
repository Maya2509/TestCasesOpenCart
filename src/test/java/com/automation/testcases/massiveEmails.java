package com.automation.testcases;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testMassiveEmails() throws Exception {
	  driver.get("http://localhost/opencartsite/admin/");
	    driver.manage().window().setSize(new Dimension(954, 1040));
	    driver.findElement(By.cssSelector(".row:nth-child(1)")).click();
	    driver.findElement(By.id("input-username")).click();
	    driver.findElement(By.id("input-username")).sendKeys("admin");
	    driver.findElement(By.id("input-password")).click();
	    driver.findElement(By.id("input-password")).sendKeys("admin");
	    driver.findElement(By.cssSelector(".btn")).click();
	    driver.findElement(By.cssSelector(".btn-close")).click();
	    driver.findElement(By.cssSelector("#button-menu > .fas")).click();
	    js.executeScript("var evt = document.createEvent('MouseEvents');" + 
	    "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
	    		+ "arguments[0].dispatchEvent(evt);", driver.findElement(By.cssSelector("#menu-marketing > a")));
	    driver.findElement(By.cssSelector("#collapse-6 > li:nth-child(4) > a")).click();
	    driver.findElement(By.id("input-store")).click();
	    driver.findElement(By.id("input-to")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("input-to"));
	      dropdown.findElement(By.xpath("//option[. = 'All Customers']")).click();
	    }
	    driver.findElement(By.id("input-subject")).click();
	    driver.findElement(By.id("input-subject")).sendKeys("QA Test");
	    {
	      WebElement element = driver.findElement(By.id("cke_39"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.switchTo().frame(0);
	    driver.findElement(By.cssSelector("html")).click();
	    {
	      WebElement element = driver.findElement(By.cssSelector(".cke_editable"));
	      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>Hla Testing</p>'}", element);
	    }
	    driver.switchTo().defaultContent();
	    driver.findElement(By.cssSelector("#button-send > .fas")).click();
	  
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    }
  }
