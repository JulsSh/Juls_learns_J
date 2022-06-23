package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

public class UserPhoneTest extends TestBase{
  @Test
  public void testUserPhones(){
    app.goTo().goToHomePage();
    UserData user =app.user().all().iterator().next();
    UserData userInfoFromEditForm =app.user().infoFromEditForm(user);
  }
}
