package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGropuHelper().getGroupList();
       // int before = app.getGropuHelper().getGroupCount();
        app.getGropuHelper().createGroup(new GroupData("Name", "Header", "Footer"));
        List<GroupData> after = app.getGropuHelper().getGroupList();
      //  int after = app.getGropuHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size()+1);

    }

}
