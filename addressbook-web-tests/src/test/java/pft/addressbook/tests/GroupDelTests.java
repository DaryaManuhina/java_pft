package pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDelTests extends TestBase {

    @Test
    public void testGroupDel() {
        app.getNavigationHelper().goToGroupPage();
        app.getGropuHelper().selectGroup();
        app.getGropuHelper().deleteSelectedGroups();
        app.getGropuHelper().returnToGroupPage();
    }

}
