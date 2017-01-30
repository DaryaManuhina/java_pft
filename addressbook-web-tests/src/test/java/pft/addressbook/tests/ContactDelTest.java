package pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;
import pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.*;
import static org.testng.Assert.*;
/**
 * Created by asus-1 on 28.12.2016.
 */
public class ContactDelTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().homePage();

    if (app.contact().allContact().size() == 0){
      app.contact().create(new ContactData().whithFirstname("testname1").whithLastname("testlastname"));
    }
  }

  @Test
  public void testContactDel(){
    Contacts before = app.contact().allContact();
    ContactData deletedContact = before.iterator().next();
    app.contact().del(deletedContact);
    assertThat(app.contact().getContactCount(), equalTo(before.size()-1));
    Contacts after = app.contact().allContact();
    //assertEquals(after.size() , before.size() - 1);
   // before.remove(deletedContact);
    //assertEquals(after , before);
    assertThat(after, equalTo(before.withOut(deletedContact)));


  }


}
