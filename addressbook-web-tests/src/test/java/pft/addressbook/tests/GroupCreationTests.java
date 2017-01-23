package pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        List<GroupData> before = app.group().getGroupList();
       // int before = app.group().getGroupCount();
        GroupData group = new GroupData().withName("test");
        app.group().create(group);
        List<GroupData> after = app.group().getGroupList();
      //  int after = app.group().getGroupCount();
        Assert.assertEquals(after.size(), before.size()+1);
        // Вариант 1. нужно узнать макимальный идентификатор maxId, чтобы добавить новую группу  идентификатором maxId+1
/*       int max = 0;
       for (GroupData g : after){
           if (g.getId() > max) {
               max =   g.getId();
           }

       }
        group.setId(max);*/
       //Вариант 2.  првератим список в поток спавнение с помощью компаратора и ананимные функции
       // group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

        //Вариант 3. сравниваем упорядоченные списки
        before.add(group);
        Comparator<? super GroupData> byId  = (g1 , g2 ) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
              // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Assert.assertEquals(before, after);


    }

}
