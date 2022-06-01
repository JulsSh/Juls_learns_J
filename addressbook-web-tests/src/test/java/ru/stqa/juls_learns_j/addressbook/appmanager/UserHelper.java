package ru.stqa.juls_learns_j.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

public class UserHelper extends HeplperBase {


  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void fillUserDetails(UserData userData) {
   click(By.linkText("add new"));
   type(By.name("firstname"), userData.getFirstName());
   type(By.name("middlename"), userData.getMiddleName());
   type(By.name("lastname"), userData.getLastName());
   type(By.name("nickname"), userData.getNickname());
   type(By.name("title"), userData.getTitle());
   type(By.name("company"), userData.getCompany());
   type(By.name("address"), userData.getAddress());
   type(By.name("home"), userData.getHoPhoneNum());
   type(By.name("mobile"),userData.getMobileNumber());
   type(By.name("work"), userData.getWorkNumber());

    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }
  protected void gotoUsers(By mainForm) {
    wd.findElement(mainForm).click();
  }



  public void editUserDetails(UserData userData) {
  }
}