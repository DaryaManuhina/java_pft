package pft.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class ContactDelTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().homePage();

    if (app.contact().getContactList().size() == 0){
      app.contact().create(new ContactData().whithFirstname("testname1").whithLastname("testlastname"));
    }
  }

  @Test
  public void testContactDel(){
       //int before = app.contact().getContactCount();
    List<ContactData> before = app.contact().getContactList();
    int index = before.size() - 1;

    app.contact().del(index);
    //int after = app.contact().getContactCount();
    List<ContactData> after = app.contact().getContactList();
   // Assert.assertEquals(after , before -1);
    Assert.assertEquals(after.size() , index);
    before.remove(index);
    Assert.assertEquals(after , before);

  }


}
