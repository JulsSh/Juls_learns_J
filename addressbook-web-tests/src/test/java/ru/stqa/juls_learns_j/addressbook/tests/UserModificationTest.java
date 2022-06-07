package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

public class UserModificationTest extends TestBase{
  @Test
  public void  modifyUser(){
app.getNavigationManager().goToHomePage();
app.getUserHelper().selectUser();
    app.getUserHelper().editSelectedUser();
    app.getUserHelper().fillUserDetails(new UserData("222edited edit2", "222juls jennifer edit", "Birkin", "edit", "jiliianedit", "Zatoo", "alexanderplatz", "0123456", "0123456", "17910286119", null), false);
    app.getUserHelper().submitUserModification();


  }
}
