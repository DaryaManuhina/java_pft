package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class GropuHelper extends HelperBase {


  public GropuHelper(WebDriver wd) {
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

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
      //click(By.name("selected[]"));
  }

  public void initGroupModification() { click(By.name("edit"));}

  public void submitGroupModification() {click(By.name("update"));  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public void modify(int index, GroupData group) {
    selectGroup(index);
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }
  public void del(int index) {
    selectGroup(index);
    deleteSelectedGroups();
    returnToGroupPage();
  }


  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element:elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData(id, name , null , null);
      groups.add(group);
    }
    return groups;
  }
}
