package pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class ContactDelTest extends TestBase {

  @Test
  public void testContactDel(){
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();

  }
}
