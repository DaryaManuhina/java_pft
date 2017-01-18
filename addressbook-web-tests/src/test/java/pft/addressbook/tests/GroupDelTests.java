package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDelTests extends TestBase {

    @Test
    public void testGroupDel() {
        app.getNavigationHelper().goToGroupPage();

        if (! app.getGropuHelper().isThereAGroup()){
            app.getGropuHelper().createGroup(new GroupData("Name", "Header", "Footer"));
        }
        List<GroupData> before = app.getGropuHelper().getGroupList();
        app.getGropuHelper().selectGroup(before.size()-1);
        app.getGropuHelper().deleteSelectedGroups();
        app.getGropuHelper().returnToGroupPage();

        List<GroupData> after = app.getGropuHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() -1);
    }

}
