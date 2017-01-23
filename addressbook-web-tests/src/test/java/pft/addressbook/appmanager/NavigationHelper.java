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

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups")); //click(By.xpath("//li[@class='admin']//a[.='groups']]"));
}

  public void homePage() {
    if (isElementPresent(By.id("maintable"))){return;}
       click(By.xpath("//div[@id='nav']//a[.='home']")); // click(By.linkText("home"));

  }
}
