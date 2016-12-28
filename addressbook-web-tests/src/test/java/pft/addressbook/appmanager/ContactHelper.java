package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pft.addressbook.model.ContactData;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitGroupCreation() {

    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());

  }

  public void initContactCreation() {
       click(By.xpath("//div[@id='nav']//a[.='add new']"));
  }


   public void editContact() { click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));}

  public void subminContactUpdate() { click(By.xpath("//div[@id='content']/form[1]/input[22]"));}

  public void selectContact() {click(By.name("selected[]"));  }

  public void deleteContact() { click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));  }
}
