package pft.addressbook.tests;

import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

public class GroupDelTests extends TestBase {

    @Test
    public void testGroupDel() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGropuHelper().isThereAGroup()){
            app.getGropuHelper().createGroup(new GroupData("Name", "Header", "Footer"));
        }
        app.getGropuHelper().selectGroup();
        app.getGropuHelper().deleteSelectedGroups();
        app.getGropuHelper().returnToGroupPage();
    }

}
