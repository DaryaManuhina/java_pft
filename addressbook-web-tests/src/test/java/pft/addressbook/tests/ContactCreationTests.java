package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    //app.goTo().homePage();

    Set<ContactData> before = app.contact().allContact();
    ContactData contact = new ContactData().whithFirstname("Dasha").whithLastname("Test").whithGroup("test");
    app.contact().create(contact);
    app.goTo().homePage();

    Set<ContactData> after = app.contact().allContact();
    Assert.assertEquals(after.size(), before.size() + 1);
    //узнаем id добавленного контакте- максимальный id в списке после добавления. преобразуем объект в число
    contact.whithId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);


  }


}
