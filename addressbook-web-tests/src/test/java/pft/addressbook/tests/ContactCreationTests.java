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
        List <ContactData>  before = app.getContactHelper().getContactList();
        ContactData contact =  new ContactData("Dasha", "Test", "test");
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().goToHomePage();
        //int after = app.getContactHelper().getContactCount();
        List <ContactData>  after = app.getContactHelper().getContactList();
        //Assert.assertEquals(after, before+1);
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        // нужно узнать макимальный идентификатор maxId, чтобы добавить новую группу  идентификатором maxId+1
        int max = 0;
        for (ContactData c : after){
            if (c.getId() > max) {
                max =   c.getId();
            }
            contact.setId(max);
        }
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    }


}
