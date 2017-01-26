package pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;
import pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.*;
import static org.testng.Assert.*;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions (){
    app.goTo().groupPage();

    if (app.group().allGroups().size() == 0){
      app.group().create(new GroupData().withName("Test1"));
    }
  }

  @Test
  public void testGroupModification() {

   Groups before = app.group().allGroups();
    GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().
            withId(modifiedGroup.getId()).withName("test").withHeader("header").withFooter("footer");

    app.group().modify(group);
    Groups after = app.group().allGroups();
    assertEquals(after.size(), before.size());

    //before.remove(modifiedGroup);
   // before.add(group);
    //assertEquals(before, after);
    assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));

  }


}
