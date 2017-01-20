package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.*;
import pft.addressbook.model.ContactData;


import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        //app.getNavigationHelper().goToHomePage();
      //  int before = app.getContactHelper().getContactCount();
        List <ContactData>  before = app.getContactHelper().getContactList();
        app.getContactHelper().createContact(new ContactData("Dasha", "Test", "test"));
        app.getNavigationHelper().goToHomePage();
        //int after = app.getContactHelper().getContactCount();
        List <ContactData>  after = app.getContactHelper().getContactList();
        //Assert.assertEquals(after, before+1);
        Assert.assertEquals(after.size(), before.size() + 1);


    }


}
