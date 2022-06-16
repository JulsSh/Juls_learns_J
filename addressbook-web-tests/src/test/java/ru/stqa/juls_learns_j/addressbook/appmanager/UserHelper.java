package ru.stqa.juls_learns_j.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.util.ArrayList;
import java.util.List;

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

  public void selectUser(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedUser() {
    boolean acceptNextAlert = true;
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
    //assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }
  public void acceptAlert(){
    wd.switchTo().alert().accept();
  }

  public boolean isThereAUser() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createNewUser(UserData user) {
    initUserCreation();
    fillUserDetails(user, true);
    submitUserCreation();
  }
public void submitUserModification() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[22]")).click();
  }

  public int getUserCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<UserData> getUserList() {
    List<UserData> users = new ArrayList<UserData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
    for (WebElement element: elements){
      String FirstNname =element.findElement(By.xpath(".//td[3]")).getText();
      String LastNname=element.findElement(By.xpath(".//td[2]")).getText();
      int id= Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      UserData user =new UserData(id, FirstNname, "test1", LastNname, "nick3", "title4", "company 5", "address6", "123", "124", "126", "[none]");
      users.add(user);
    }
    return users;
  }
}