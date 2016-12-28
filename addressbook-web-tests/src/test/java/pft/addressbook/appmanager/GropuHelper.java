package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pft.addressbook.model.GroupData;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class GropuHelper {
  private FirefoxDriver wd;


  public GropuHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void returnToGroupPage() {
      wd.findElement(By.linkText("group page")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  private void type(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void initGroupCreation() {
      wd.findElement(By.name("new")).click();
  }

  public void submitGroupCreation() {
    click();
  }

  private void click() {
    wd.findElement(By.name("submit")).click();
  }

  public void deleteSelectedGroups() {
      wd.findElement(By.name("delete")).click();
  }

  public void selectGroup() {
      wd.findElement(By.name("selected[]")).click();
  }
}
