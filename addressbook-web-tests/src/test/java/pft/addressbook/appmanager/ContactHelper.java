package pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pft.addressbook.model.ContactData;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
   // click(By.xpath("//div[@id='content']/form/input[21]"));
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void initContactCreation() {
       click(By.xpath("//div[@id='nav']//a[.='add new']"));
  }


   public void initeContatModifiation() {
    //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"))
     click(By.cssSelector("img[alt='Edit']")) ;}

  public void subminContactUpdate() { //click(By.xpath("//div[@id='content']/form[1]/input[22]"))
    click(By.name("update")); }

  public void selectContact() {click(By.name("selected[]"));  }

  public void deleteContact() { click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));     }
}
