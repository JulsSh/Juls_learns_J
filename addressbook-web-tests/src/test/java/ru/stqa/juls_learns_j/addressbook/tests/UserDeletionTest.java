package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.util.List;

public class UserDeletionTest extends TestBase{
  private String id;

  @Test (enabled=false)


  public void  deleteUser(){

    app.getUserHelper().gotoUsers();
    List<UserData> before =app.getUserHelper().getUserList();
    if(!app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createNewUser( new UserData( "Juls", "jennifer", "juli", "jiliian", "senior QA", "LucanetAG", "Tabberstr 6C", "012345", "1791028611", "010 345845", "test1"));
    }
    app.getUserHelper().selectUser(before.size()-1);
    app.getUserHelper().deleteSelectedUser();
    app.getUserHelper().acceptAlert();
    app.getUserHelper().gotoUsers();
    List<UserData> after =app.getUserHelper().getUserList();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(before.size()-1);
    Assert.assertEquals(before, after);

    }
}
