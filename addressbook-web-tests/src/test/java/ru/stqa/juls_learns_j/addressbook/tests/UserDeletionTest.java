package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

public class UserDeletionTest extends TestBase{
  @Test


  public void  deleteUser(){

    app.getUserHelper().gotoUsers();
    int before=app.getUserHelper().getUserCount();
    if(!app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createNewUser( new UserData("Juls", "jennifer", "juli", "jiliian", "senior QA", "LucanetAG", "Tabberstr 6C", "012345", "1791028611", "010 345845", "test1"));
    }
    app.getUserHelper().selectUser(before-1);
    app.getUserHelper().deleteSelectedUser();
    app.getUserHelper().acceptAlert();
    app.getUserHelper().gotoUsers();
    int after=app.getUserHelper().getUserCount();
    Assert.assertEquals(after,before-1);



  }
}
