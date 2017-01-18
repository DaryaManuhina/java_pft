package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;
import pft.addressbook.model.GroupData;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification(){
    app.getNavigationHelper().goToHomePage();

    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("testname1", "testlastname", null));
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().initeContatModifiation(before -1);
    app.getContactHelper().fillContactForm(new ContactData("testname1", "testlastname", null), false);
    app.getContactHelper().subminContactUpdate();
    app.getNavigationHelper().goToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after , before);




  }
}
