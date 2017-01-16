package pft.addressbook.tests;

import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification(){
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().initeContatModifiation();
    app.getContactHelper().fillContactForm(new ContactData("testname1", "testlastname", null), false);
    app.getContactHelper().subminContactUpdate();
    app.getNavigationHelper().goToHomePage();
  }
}
