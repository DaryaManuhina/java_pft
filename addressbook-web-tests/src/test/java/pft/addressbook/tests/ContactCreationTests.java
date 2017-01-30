package pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pft.addressbook.model.ContactData;
import pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    //app.goTo().homePage();

    Contacts before = app.contact().allContact();
    ContactData contact = new ContactData().whithFirstname("Dasha").whithLastname("Test").whithGroup("test");
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().getContactCount(), equalTo(before.size()+1));
    Contacts after = app.contact().allContact();
   // assertEquals(after.size(), before.size() + 1);
   // assertThat(after.size(), equalTo(before.size() + 1));
    //узнаем id добавленного контакте- максимальный id в списке после добавления. преобразуем объект в число
    //contact.whithId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    //before.add(contact);
    //assertEquals(before, after);
    assertThat(after, equalTo(
            before.withAdded(contact.whithId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));


  }


}
