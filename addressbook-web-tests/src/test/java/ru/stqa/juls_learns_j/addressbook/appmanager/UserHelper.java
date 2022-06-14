package ru.stqa.juls_learns_j.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

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
    wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[7]/td[8]/a/img")).click();
  }

  public void selectUser() {
    wd.findElement(By.name("selected[]")).click();
  }

  public void deleteSelectedUser() {
    boolean acceptNextAlert = true;
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
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
}