package pft.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

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
    Set<ContactData> before = app.contact().allContact();
    ContactData deletedContact = before.iterator().next();
    app.contact().del(deletedContact);
    Set<ContactData> after = app.contact().allContact();
    Assert.assertEquals(after.size() , before.size() - 1);
    before.remove(deletedContact);
    Assert.assertEquals(after , before);

  }


}
