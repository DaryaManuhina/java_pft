package pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions (){
    app.goTo().groupPage();

    if (app.group().getGroupList().size() == 0){
      app.group().create(new GroupData("Name", "Header", "Footer"));
    }
  }

  @Test
  public void testGroupModification() {

    List<GroupData> before = app.group().getGroupList();
    int index= before.size() -1;
    GroupData group = new GroupData(before.get(index).getId(),"test", "header", null);

    app.group().modify(index, group);

    List<GroupData> after = app.group().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
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
