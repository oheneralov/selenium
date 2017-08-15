package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Rozetkaexport {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://rozetka.com.ua/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRozetkaexport() throws Exception {
    driver.get(baseUrl + "/");
    assertEquals("Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие", driver.getTitle());
    driver.findElement(By.cssSelector("span")).click();
    assertEquals("Здравствуйте,", driver.findElement(By.cssSelector("span")).getText());
    assertEquals("Олександр Генералов", driver.findElement(By.linkText("Олександр Генералов")).getText());
    assertEquals("(044) 537-02-22,", driver.findElement(By.cssSelector("nobr.header-phones-i.bold")).getText());
    assertEquals("ru", driver.findElement(By.cssSelector("span.lang-switcher-link.gray")).getText());
    assertEquals("ua", driver.findElement(By.linkText("ua")).getText());
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
    driver.findElement(By.cssSelector("div.wrap")).click();
    assertEquals("Сравнение", driver.findElement(By.linkText("Сравнение")).getText());
    assertEquals("Желания", driver.findElement(By.linkText("Желания")).getText());
    assertEquals("Корзина", driver.findElement(By.xpath("//a[@onclick=\"document.fireEvent('openCart', {extend_event: [{name: 'eventLocation', value: 'Head'}]});\"]")).getText());
    assertEquals("Каталог товаров", driver.findElement(By.cssSelector("span.btn-link-i")).getText());
  }

  @After
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
