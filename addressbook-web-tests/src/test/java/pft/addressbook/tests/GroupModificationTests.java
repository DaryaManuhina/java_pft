package pft.addressbook.tests;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
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

    GroupData group = new GroupData(before.get(before.size() -1).getId(),"test", "header", null);
    app.getGropuHelper().fillGroupForm(group);
    app.getGropuHelper().submitGroupModification();
    app.getGropuHelper().returnToGroupPage();
    List<GroupData> after = app.getGropuHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(group);
    Comparator<? super GroupData> byId  = (g1 , g2 ) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
// преобразуем списки в множества для сравнения, так как множества порядок не важен (множества - не упорядоченная коллекция)
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
// выполняем спавнение отсортированных спиков
    Assert.assertEquals(before, after);

  }
}
