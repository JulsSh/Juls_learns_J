package ru.stqa.juls_learns_j.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.juls_learns_j.addressbook.model.UserData;
import ru.stqa.juls_learns_j.addressbook.model.Users;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class UserHelper extends HeplperBase {

  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void initUserCreation()  {
    click(By.linkText("add new"));
  }

  public void fillUserDetails(UserData userData, boolean creation) {

    type(By.name("firstname"), userData.getFirstName());
    type(By.name("middlename"), userData.getMiddleName());
    type(By.name("lastname"), userData.getLastName());
    type(By.name("nickname"), userData.getNickname());
    type(By.name("title"), userData.getTitle());
    type(By.name("company"), userData.getCompany());
    type(By.name("address"), userData.getAddress());
    type(By.name("home"), userData.getHoPhoneNum());
    type(By.name("mobile"), userData.getMobileNumber());
    type(By.name("work"), userData.getWorkNumber());

    if (creation) {
      if(!wd.findElement(By.name("new_group")).getAttribute("value").equals("none")){
        new Select(wd.findElement(By.name("new_group"))).selectByIndex(0);
              }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void submitUserCreation(){
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void gotoUsers() {
    wd.findElement(By.linkText("home")).click();
  }

  public void editSelectedUser(){
    wd.findElement(By.xpath("//img[@alt='Edit']")).click();
  }

  public void selectUserbyId(int id) {
    wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
  }

  public void deleteSelectedUser() {
    boolean acceptNextAlert = true;
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }
  protected String closeAlertAndGetItsText() {
    boolean acceptNextAlert = true;
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  public void acceptAlert(){
    wd.switchTo().alert().accept();
  }

  public boolean isThereAUser() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(UserData user) {
    initUserCreation();
    fillUserDetails(user, true);
    submitUserCreation();
  }


  public void modify( UserData user) {
    gotoUsers();
    selectUserbyId(user.getId());
    editSelectedUser();
    fillUserDetails(user, false);
    submitUserModification();
    gotoUsers();
  }

  public void delete(UserData delUser) {
    selectUserbyId(delUser.getId());
    deleteSelectedUser();
    gotoUsers();

  }
public void submitUserModification() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[22]")).click();
  }

  public int getUserCount() {
    return wd.findElements(By.name("selected[]")).size();
  }


  public Users all() {
    Users users = new Users();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
    for (WebElement element: elements){
      String FirstNname =element.findElement(By.xpath(".//td[3]")).getText();
      String LastNname=element.findElement(By.xpath(".//td[2]")).getText();
      String allPhones= element.findElement(By.xpath(".//td[6]")).getText();
      String[] phones = allPhones.split("\n");

      int id= Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      users.add(new UserData().withId(id).withFName(FirstNname).withLName(LastNname).
              withHomeNum(phones[0]).withWorkNum(phones[2]).withMobileNum(phones[1]));
    }
    return users;
  }

  public UserData infoFromEditForm(UserData user) {
    initUserModificationById(user.getId());
    String firstName= wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName= wd.findElement(By.name("lastname")).getAttribute("value");
    String home= wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work= wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new UserData().withId(user.getId()).withLName(lastName).withFName(firstName).withHomeNum(home)
    .withMobileNum(mobile).withWorkNum(work);
  }
  private void initUserModificationById(int id){
    WebElement checkbox =wd.findElement(By.cssSelector(String.format("input[value= '%s']", id)));
    WebElement row =checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells= row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

    //wd.findElement(By.xpath(String.format("//tr[.//input[value='%s']]/td[8]/a", id))).click();
    //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }
}