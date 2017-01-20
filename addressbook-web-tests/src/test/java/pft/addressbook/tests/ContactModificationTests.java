package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;
import pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

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
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initeContatModifiation(before.size() -1);
    ContactData contact = new ContactData(before.get(before.size() -1).getId(), "testname1", "testlastname", null);
    app.getContactHelper().fillContactForm(contact , false);
    app.getContactHelper().subminContactUpdate();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
// преобразуем списки в множества для сравнения, так как множества порядок не важен (множества - не упорядоченная коллекция)
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));







  }
}
