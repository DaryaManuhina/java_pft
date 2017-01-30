package pft.addressbook.appmanager;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pft.addressbook.model.ContactData;
import org.testng.Assert;
import pft.addressbook.model.Contacts;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by asus-1 on 28.12.2016.
 */
public class ContactHelper extends HelperBase {

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


  public void initeContatModifiation(int index) {
   wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
  }
  private void initeContatModifiationById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    wd.findElement(By.cssSelector("img[alt='Edit']")).click();

           }


  public void subminContactUpdate() { //click(By.xpath("//div[@id='content']/form[1]/input[22]"))
    click(By.name("update"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    //click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    click(By.xpath("//input[@value='Delete']"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    contactCash = null;
    submitContactCreation();
  }

  public void modify(ContactData contact) {
    initeContatModifiationById(contact.getId());
    fillContactForm(contact , false);
    subminContactUpdate();
    contactCash = null;
    goToHomePage();
  }

  public void del(int index) {
    initeContatModifiation(index); //app.contact().selectContact();
    deleteContact();
    goToHomePage();
  }
  public void del(ContactData contact) {
    initeContatModifiationById(contact.getId()); //app.contact().selectContact();
    deleteContact();
    contactCash = null;
    goToHomePage();
  }



  private void goToHomePage() {
   if (isElementPresent(By.id("maintable"))){return;}
      click(By.xpath("//div[@id='nav']//a[.='home']")); // click(By.linkText("home"));
      }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size() - 1;
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.xpath("td[3]")).getText();
      String lastName = element.findElement(By.xpath("td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.xpath("td[1]")).findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().whithId(id).whithFirstname(firstName).whithLastname(lastName);
      contacts.add(contact);
    }
    return contacts;
  }
private Contacts contactCash = null;
  public Contacts allContact() {
    if (contactCash != null){return new Contacts(contactCash);}
    contactCash = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.xpath("td[3]")).getText();
      String lastName = element.findElement(By.xpath("td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.xpath("td[1]")).findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().whithId(id).whithFirstname(firstName).whithLastname(lastName);
      contactCash.add(contact);
    }
    return contactCash;
  }



}
