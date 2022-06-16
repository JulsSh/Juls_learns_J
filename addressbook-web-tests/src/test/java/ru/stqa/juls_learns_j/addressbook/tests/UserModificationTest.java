package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

public class UserModificationTest extends TestBase{
  @Test
  public void  modifyUser(){
    app.getUserHelper().gotoUsers();
    int before=app.getUserHelper().getUserCount();
    if(!app.getUserHelper().isThereAUser()){

      app.getUserHelper().createNewUser(new UserData("Julia",
              "SH","k","hh","zu","op",
              "Ta","123","123","98",null
              ));
    }
app.getNavigationManager().goToHomePage();
app.getUserHelper().selectUser(before-1);
    app.getUserHelper().editSelectedUser();
    app.getUserHelper().fillUserDetails(new UserData("222edited edit2", "222juls jennifer edit", "Birkin", "edit", "jiliianedit", "Zatoo", "alexanderplatz", "0123456", "0123456", "17910286119", null), false);
    app.getUserHelper().submitUserModification();
    app.getUserHelper().gotoUsers();
    int after=app.getUserHelper().getUserCount();
    Assert.assertEquals(after,before );
  }
}
