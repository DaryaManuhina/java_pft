package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class ContactModificationTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().homePage();

    if (app.contact().getContactList().size() == 0){
      app.contact().create(new ContactData("testname1", "testlastname", null));
    }
  }

  @Test
  public void testContactModification(){

    List<ContactData> before = app.contact().getContactList();
    int index = before.size() -1;
    ContactData contact = new ContactData(before.get(index).getId(), "testname1", "testlastname", null);

    app.contact().modify(index, contact);

    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
// преобразуем списки в множества для сравнения, так как множества порядок не важен (множества - не упорядоченная коллекция)
    Comparator<? super ContactData> byId  = (c1 , c2 ) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
   // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    Assert.assertEquals(before, after);






  }


}
