package com.mysite.rozetka;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    
    public void setUp() throws Exception {
      System.setProperty("webdriver.gecko.driver", "C://alex//selenium//geckodriver-v0.18.0-win64//geckodriver.exe");
     
    }

    
    public void testRozetkaexport() {
      System.out.println("Starting testing of the main web page");
      driver = new FirefoxDriver();
      driver.get(Rozetka.baseUrl + "/");
      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      if (this.isAlertPresent()) {
    	  System.out.println("Alert is present!");
    	  this.closeAlertAndGetItsText();
      }
     
      System.out.println("Testing title");
      assertEquals(Rozetka.title, driver.getTitle());
      
      assertEquals(Rozetka.WelcomeMessage, driver.findElement(By.cssSelector("span")).getText());
      assertEquals(Rozetka.phone, driver.findElement(By.cssSelector("nobr.header-phones-i.bold")).getText());
      assertEquals("RU", driver.findElement(By.cssSelector("span.lang-switcher-link.gray")).getText());
      System.out.printf("The laguage is: %s", driver.findElement(By.cssSelector("span.lang-switcher-link.gray")).getText());
      assertEquals("UA", driver.findElement(By.linkText("ua")).getText());
      assertEquals("Вопросы и ответы", driver.findElement(By.linkText("Вопросы и ответы")).getText());
      assertEquals("Кредит", driver.findElement(By.linkText("Кредит")).getText());
      assertEquals("Доставка и оплата", driver.findElement(By.linkText("Доставка и оплата")).getText());
      assertEquals("Гарантия", driver.findElement(By.linkText("Гарантия")).getText());
      assertEquals("Контакты", driver.findElement(By.linkText("Контакты")).getText());
      assertEquals("Отследить заказ", driver.findElement(By.id("status_orders")).getText());
      assertEquals("Продавать на Розетке", driver.findElement(By.linkText("Продавать на Розетке")).getText());
      assertEquals("Львов", driver.findElement(By.cssSelector("span.xhr.bold")).getText());
      assertEquals("Город", driver.findElement(By.cssSelector("div.header-city-select-title")).getText());
      assertEquals("", driver.findElement(By.name("text")).getText());
      
      assertEquals("Сравнение", driver.findElement(By.linkText("Сравнение")).getText());
      assertEquals("Желания", driver.findElement(By.linkText("Желания")).getText());
      assertEquals("Корзина", driver.findElement(By.xpath("//a[@onclick=\"document.fireEvent('openCart', {extend_event: [{name: 'eventLocation', value: 'Head'}]});\"]")).getText());
      assertEquals("Каталог товаров", driver.findElement(By.cssSelector("span.btn-link-i")).getText());
    }

    
    public void tearDown() throws Exception {
      System.out.println("Closing the driver");
      driver.quit();
      /*
      String verificationErrorString = verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
      }
      */
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
