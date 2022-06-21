package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserModificationTest extends TestBase{
  @Test
  public void  modifyUser(){
    app.goTo().goToHomePage();
    List<UserData> before =app.getUserHelper().getUserList();
    if(!app.getUserHelper().isThereAUser()){

      app.getUserHelper().createNewUser(new UserData("Julia",
              "SH","k","hh","zu","op",
              "Ta","123","123","98",null));
    }
    app.goTo().goToHomePage();
    app.getUserHelper().selectUser(0);
    app.getUserHelper().editSelectedUser();
    UserData user =new UserData(before.get(before.size()-1).getId(),"JulsHHH", "jennifer", "juli",
            "jiliian", "senior QA", "LucanetAG", "Tabberstr 6C",
            "012345", "1791028611", "010 345845",
            "[none]");
    app.getUserHelper().fillUserDetails(user, false);
    app.getUserHelper().submitUserModification();
    app.goTo().goToHomePage();
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
