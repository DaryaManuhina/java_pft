package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {

   click(By.linkText("groups"));
    //click(By.xpath("//li[@class='admin']//a[.='groups']]"));

      }

  public void goToHomePage() {
   // click(By.linkText("home"));
    click(By.xpath("//div[@id='nav']//a[.='home']"));

  }
}
