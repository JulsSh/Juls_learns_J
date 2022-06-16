package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class UserModificationTest extends TestBase{
  @Test(enabled = false)
  public void  modifyUser(){
    app.getUserHelper().gotoUsers();
    List<UserData> before =app.getUserHelper().getUserList();
    if(!app.getUserHelper().isThereAUser()){

      app.getUserHelper().createNewUser(new UserData("Julia",
              "SH","k","hh","zu","op",
              "Ta","123","123","98",null
              ));
    }
    app.getNavigationManager().goToHomePage();
    app.getUserHelper().selectUser(before.size()-1);
    app.getUserHelper().editSelectedUser();
    UserData user =new UserData(before.get(before.size()-1).getId(),"JulsHHH", "jennifer", "juli",
            "jiliian", "senior QA", "LucanetAG", "Tabberstr 6C",
            "012345", "1791028611", "010 345845",
            "");
    app.getUserHelper().fillUserDetails(user, false);
    app.getUserHelper().submitUserModification();
    app.getUserHelper().gotoUsers();
    List<UserData> after =app.getUserHelper().getUserList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size()-1);
    before.add(user);

    Comparator<? super UserData> byId = (u1,u2) -> Integer.compare(u1.getId(), u2.getId() );
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
