package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


/**
 * Created by asus-1 on 28.12.2016.
 */
public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void type(By locator, String text) {
    click(locator);
        if(text != null) { // проверка на оставление значения по умолчанию
      String existingText = wd.findElement(locator).getAttribute("value"); // проверка что новое значение совпадает со значением по умолчанию
      if (! text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }

  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public  boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex){
      return false;
    }
  }
}
