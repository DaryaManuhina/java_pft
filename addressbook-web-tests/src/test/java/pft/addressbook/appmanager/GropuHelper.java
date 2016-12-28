package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pft.addressbook.model.GroupData;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class GropuHelper extends HelperBase {


  public GropuHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
      click(By.linkText("group page"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
      click(By.name("new"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void deleteSelectedGroups() {
     click(By.name("delete"));
  }

  public void selectGroup() {
      click(By.name("selected[]"));
  }
}