package pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pft.addressbook.appmanager.ApplicatiomManager;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class TestBase {

  protected final ApplicatiomManager app = new ApplicatiomManager(BrowserType.CHROME);

  @BeforeMethod
  public void setUp() throws Exception {
    app.inite();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }


}
