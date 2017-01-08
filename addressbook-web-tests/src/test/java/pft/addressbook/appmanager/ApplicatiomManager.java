package pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class ApplicatiomManager {
  private  String browser;
  private WebDriver wd;
  private  NavigationHelper navigationHelper;
  private  GropuHelper gropuHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;

  public ApplicatiomManager(String browser) {
    this.browser = browser;
  }


  public void inite() {
    System.setProperty("webdriver.gecko.driver", "c:/geckodriver/geckodriver.exe");

    if (browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    } else if(browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }

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
  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
