package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;
import java.util.HashSet;
import java.util.List;

public class UserDeletionTest extends TestBase{

  @Test

  public void  deleteUser(){

    app.goTo().goToHomePage();
    List<UserData> before =app.getUserHelper().getUserList();
    UserData user =new UserData( "JulsHHH", null, "juli", null,
            null, null, null,null, null,
            null, null);
    if(!app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createNewUser( new UserData( "Juls", "jennifer", "juli",
              "jiliian", "senior QA", "LucanetAG", "Tabberstr 6C", "012345",
              "1791028611", "010 345845", "[none]"));
          }
    app.getUserHelper().selectUser(before.size()-1);
    app.getUserHelper().deleteSelectedUser();
        app.goTo().groupPage();
        List<UserData> after =app.getUserHelper().getUserList();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(before.size()-1);
    Assert.assertEquals(before, after);

    }
}
