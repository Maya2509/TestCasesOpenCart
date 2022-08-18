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
import java.util.concurrent.TimeUnit;
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
	 driver.get("http://localhost/opencartsite/index.php?route=common/home&language=en-gb");
	 driver.manage().window().setSize(new Dimension(954, 1040));
	    driver.findElement(By.cssSelector(".fa-bars")).click();
	    driver.findElement(By.linkText("Desktops")).click();
	    driver.findElement(By.linkText("Mac (1)")).click();
	    driver.findElement(By.cssSelector(".image .img-fluid")).click();
	    driver.findElement(By.id("button-cart")).click();
	    
	    driver.findElement(By.cssSelector("#top > div.container > div.nav.float-end > ul > li:nth-child(5) > a")).click();
	    

	    {
	      WebElement element = driver.findElement(By.cssSelector("#top > div.container > div.nav.float-end > ul > li:nth-child(5) > a"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    driver.findElement(By.id("input-guest")).click();
	    driver.findElement(By.id("input-firstname")).click();
	    driver.findElement(By.id("input-firstname")).sendKeys("qagroup");
	    driver.findElement(By.id("input-lastname")).click();
	    driver.findElement(By.id("input-lastname")).sendKeys("qa");
	    driver.findElement(By.id("input-email")).click();
	    driver.findElement(By.id("input-email")).sendKeys("qa@gmail.com");
	    driver.findElement(By.id("input-shipping-company")).click();
	    driver.findElement(By.id("input-shipping-company")).sendKeys("GROUP");
	    driver.findElement(By.id("input-shipping-address-1")).click();
	    driver.findElement(By.id("input-shipping-address-1")).sendKeys("ala");
	    driver.findElement(By.id("input-shipping-address-2")).click();
	    driver.findElement(By.id("input-shipping-address-2")).sendKeys("san@@@");
	    driver.findElement(By.id("input-shipping-city")).click();
	    driver.findElement(By.id("input-shipping-city")).sendKeys("Car***64");
	    driver.findElement(By.id("input-shipping-postcode")).click();
	    driver.findElement(By.id("input-shipping-postcode")).sendKeys("56479");
	    
	    /* driver.findElement(By.id("input-shipping-country")).click();
	    {
		      WebElement dropdown = driver.findElement(By.id("input-shipping-country"));
		      dropdown.findElement(By.xpath("//option[. = 'United Kingdom']")).click();
		    } */
	    
	    
	    /*driver.findElement(By.cssSelector("#input-shipping-zone")).click();
	    {
	      WebElement dropdown = driver.findElement(By.cssSelector("#input-shipping-zone"));
	      dropdown.findElement(By.xpath("//option[. = 'Anglesey']")).click();
	    }*/
	    
	    
	    driver.findElement(By.id("input-comment")).click();
	    driver.findElement(By.id("input-comment")).sendKeys("TESTING");
	    driver.findElement(By.xpath("//div[@id='content']/div")).click();
	    driver.findElement(By.xpath("//div[@id='content']/div")).click();
	    driver.findElement(By.xpath("//div[@id='checkout-payment']/div")).click();
	      
  } 



 @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }
}