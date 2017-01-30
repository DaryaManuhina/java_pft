package pft.addressbook.tests;

import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;
import pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().allGroups();
        GroupData group = new GroupData().withName("test");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()+1)); // хэширование - предварительная проверка при помощи более быстрой операции
        Groups after = app.group().allGroups();
       //hamcrest: Fluent интерфейс проверки
       // assertThat(after.size(), equalTo(before.size()+1));
        // hamcrest: Fluent проверки
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }
    @Test
    public void testBadGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().allGroups();
        GroupData group = new GroupData().withName("test2'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().allGroups();
        assertThat(after, equalTo(before));

    }
}
