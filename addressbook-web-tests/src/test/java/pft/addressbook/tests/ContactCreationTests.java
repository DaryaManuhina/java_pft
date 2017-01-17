package pft.addressbook.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.*;
import pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        //app.getNavigationHelper().goToHomePage();
        app.getContactHelper().createContact(new ContactData("Dasha", "Test", "test"));
        app.getNavigationHelper().goToHomePage();
    }


}
