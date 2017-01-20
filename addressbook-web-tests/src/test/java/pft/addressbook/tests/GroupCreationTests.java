package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGropuHelper().getGroupList();
       // int before = app.getGropuHelper().getGroupCount();
        GroupData group = new GroupData("Name", "Header", "Footer");
        app.getGropuHelper().createGroup(group);
        List<GroupData> after = app.getGropuHelper().getGroupList();
      //  int after = app.getGropuHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size()+1);

        before.add(group);
        // нужно узнать макимальный идентификатор maxId, чтобы добавить новую группу  идентификатором maxId+1
       int max = 0;
       for (GroupData g : after){
           if (g.getId() > max) {
               max =   g.getId();
           }
           group.setId(max);
       }
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    }

}
