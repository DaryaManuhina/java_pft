package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class ContactModificationTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().homePage();

    if (app.contact().allContact().size() == 0){
      app.contact().create(new ContactData().whithFirstname("testname1").whithLastname("testlastname"));
    }
  }

  @Test
  public void testContactModification(){

    Set<ContactData> before = app.contact().allContact();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            whithId(modifiedContact.getId()).whithFirstname("testname1").whithLastname("testlastname");

    app.contact().modify(contact);

    Set<ContactData> after = app.contact().allContact();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }


}
