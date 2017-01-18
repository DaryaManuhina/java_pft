package pft.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class ContactDelTest extends TestBase {

  @Test
  public void testContactDel(){
    app.getNavigationHelper().goToHomePage();

    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("testname1", "testlastname", null));
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after , before -1);

  }
}
