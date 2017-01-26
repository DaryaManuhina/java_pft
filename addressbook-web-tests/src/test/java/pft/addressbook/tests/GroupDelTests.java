package pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;
import pft.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.*;
import static org.testng.Assert.*;

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
        Groups before = app.group().allGroups();
        GroupData deletedGroup = before.iterator().next();
        app.group().del(deletedGroup);
        Groups after = app.group().allGroups();
        assertEquals(after.size(), before.size()-1); // сравниваем размеры списоков

        //before.remove(deletedGroup);
        //assertEquals(before, after); // сравниваем сами списки
        assertThat(after, equalTo(before.withOut(deletedGroup)));


    }




}
