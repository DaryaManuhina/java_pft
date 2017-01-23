package pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pft.addressbook.appmanager.ApplicatiomManager;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class TestBase {

  protected static final ApplicatiomManager app = new ApplicatiomManager(BrowserType.CHROME);

  @BeforeSuite
    public void setUp() throws Exception {
    app.inite();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }


}
