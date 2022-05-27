package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.appmanager.UserHelper;
import ru.stqa.juls_learns_j.addressbook.model.UserData;


public class UserCreationTest extends UserHelper {

  @Test
  public void testUserCreation() throws Exception {
    gotoUsers();
    fillUserDetails(new UserData("Juls", "jennifer", "Birkin", "jiliian", "senior QA", "LucanetAG", "Tabberstr 6C", "012345", "1791028611", "010 345845"));
  }

}
