package pft.addressbook.tests;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();

    if (! app.getGropuHelper().isThereAGroup()){
      app.getGropuHelper().createGroup(new GroupData("Name", "Header", "Footer"));
    }
    List<GroupData> before = app.getGropuHelper().getGroupList();
    app.getGropuHelper().selectGroup(before.size() -1);
    app.getGropuHelper().initGroupModification();
    app.getGropuHelper().fillGroupForm(new GroupData("test", "header", null));
    app.getGropuHelper().submitGroupModification();
    app.getGropuHelper().returnToGroupPage();
    List<GroupData> after = app.getGropuHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

  }
}
