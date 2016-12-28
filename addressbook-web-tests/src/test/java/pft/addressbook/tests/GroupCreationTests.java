package pft.addressbook.tests;

import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        app.getGropuHelper().initGroupCreation();
        app.getGropuHelper().fillGroupForm(new GroupData("Name", "Header", "Footer"));
        app.getGropuHelper().submitGroupCreation();
        app.getGropuHelper().returnToGroupPage();
    }

}
