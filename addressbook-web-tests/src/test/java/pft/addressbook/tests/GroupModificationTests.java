package pft.addressbook.tests;


import org.testng.annotations.Test;
import pft.addressbook.model.GroupData;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    app.getGropuHelper().selectGroup();
    app.getGropuHelper().initGroupModification();
    app.getGropuHelper().fillGroupForm(new GroupData("test", "header", "footer"));
    app.getGropuHelper().submitGroupModification();
    app.getGropuHelper().returnToGroupPage();

  }
}
