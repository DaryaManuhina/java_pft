package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class GroupDelTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions (){
        app.goTo().groupPage();

        if (app.group().allGroups().size() == 0){
            app.group().create(new GroupData().withName("Test1"));
        }
    }

    @Test
    public void testGroupDel() {
        Set<GroupData> before = app.group().allGroups();
        GroupData deletedGroup = before.iterator().next();
        app.group().del(deletedGroup);
        Set<GroupData> after = app.group().allGroups();
        Assert.assertEquals(after.size(), before.size()-1); // сравниваем размеры списоков

        before.remove(deletedGroup);
        Assert.assertEquals(before, after); // сравниваем сами списки


    }




}
