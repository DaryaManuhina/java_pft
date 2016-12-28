package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
      click(By.linkText("groups"));
      }

  public void goToHomePage() {
    click(By.linkText("home"));
  }
}
