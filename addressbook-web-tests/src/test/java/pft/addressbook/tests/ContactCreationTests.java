package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.*;
import pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    //app.getNavigationHelper().goToHomePage();
    //  int before = app.getContactHelper().getContactCount();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Dasha", "Test", "test");
    app.getContactHelper().createContact(contact);
    app.getNavigationHelper().goToHomePage();
    //int after = app.getContactHelper().getContactCount();
    List<ContactData> after = app.getContactHelper().getContactList();
    //Assert.assertEquals(after, before+1);
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()); //ищем мах идентификатор
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


  }


}
