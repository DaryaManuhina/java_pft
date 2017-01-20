package pft.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

import java.util.List;

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
    //int before = app.getContactHelper().getContactCount();
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().initeContatModifiation(before.size() - 1); //app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().goToHomePage();
    //int after = app.getContactHelper().getContactCount();
    List<ContactData> after = app.getContactHelper().getContactList();
   // Assert.assertEquals(after , before -1);
    Assert.assertEquals(after.size() , before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(after , before);

  }
}
