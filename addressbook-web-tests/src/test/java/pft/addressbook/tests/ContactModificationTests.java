package pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;
import pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.*;
import static org.testng.Assert.*;

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

    Contacts before = app.contact().allContact();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            whithId(modifiedContact.getId()).whithFirstname("testname1").whithLastname("testlastname");

    app.contact().modify(contact);

    Contacts after = app.contact().allContact();
    assertEquals(after.size(), before.size());

   // before.remove(modifiedContact);
    //before.add(contact);
    //Assert.assertEquals(before, after);
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));

  }


}
