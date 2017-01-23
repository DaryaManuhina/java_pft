package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDelTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions (){
        app.goTo().groupPage();

        if (app.group().getGroupList().size() == 0){
            app.group().create(new GroupData("Name", "Header", "Footer"));
        }
    }

    @Test
    public void testGroupDel() {
        List<GroupData> before = app.group().getGroupList();
        int index = before.size()-1;
        app.group().del(index);

        List<GroupData> after = app.group().getGroupList();
        Assert.assertEquals(after.size(), index); // сравниваем размеры списоков

        before.remove(index);
        Assert.assertEquals(before, after); // сравниваем сами списки


    }




}
