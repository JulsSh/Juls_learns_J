package ru.stqa.juls_learns_j.addressbook.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.appmanager.UserHelper;
import ru.stqa.juls_learns_j.addressbook.model.UserData;


public class UserCreationTest extends TestBase {

  @Test
  public void testUserCreation() throws Exception {
    app.getUserHelper().fillUserDetails(new UserData("Juls", "jennifer", "juli", "jiliian", "senior QA", "LucanetAG", "Tabberstr 6C", "012345", "1791028611", "010 345845", "test1"), true);
  }
}
