package ru.stqa.juls_learns_j.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import static org.testng.Assert.assertTrue;

public class UserHelper extends HeplperBase {


  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void fillUserDetails(UserData userData, boolean creation) {
    click(By.linkText("add new"));
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
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }


    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void gotoUsers() {
    wd.findElement(By.linkText("home")).click();
  }


  public void editUserDetails(UserData userData, boolean b) {
  }

  public void selectUser() {
    wd.findElement(By.name("selected[]")).click();
    //wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void deleteSelectedUser() {
    boolean acceptNextAlert = true;
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }

  private String closeAlertAndGetItsText() {
    boolean acceptNextAlert = false;
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

  public boolean isThereAUser() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createNewUser(UserData user, boolean b) {
    fillUserDetails(user, true);
  }
}