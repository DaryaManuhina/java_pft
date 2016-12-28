package pft.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class ApplicatiomManager {
  FirefoxDriver wd;

  private  NavigationHelper navigationHelper;
  private  GropuHelper gropuHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;



  public void inite() {
    System.setProperty("webdriver.gecko.driver", "c:/geckodriver/geckodriver.exe");
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");

    gropuHelper = new GropuHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);


    sessionHelper.login("admin", "secret");
  }



  public void stop() {wd.quit();
  }

  public GropuHelper getGropuHelper() {
    return gropuHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
 // public SessionHelper getSessionHelper() {
 //   return sessionHelper;
 // }
}
