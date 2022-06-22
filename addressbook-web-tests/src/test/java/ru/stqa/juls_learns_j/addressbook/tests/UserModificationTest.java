package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserModificationTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    if(app.user().list().size()==0){
      app.user().create(new UserData("Julia",
              "SH","k","hh","zu","op",
              "Ta","123","123","98",null));
    }
  }
  @Test
  public void  modifyUser(){
    app.goTo().goToHomePage();
    List<UserData> before =app.user().list();
    int i=before.size()-1;
    UserData user =new UserData(before.get(i).getId(),"JulsHHH", "jennifer", "juli",
            "jiliian", "senior QA", "LucanetAG", "Tabberstr 6C",
            "012345", "1791028611", "010 345845",
            "[none]");

    app.user().modify(i, user);
    List<UserData> after =app.user().list();
    Assert.assertEquals(after.size(),before.size());
    before.remove(i);
    before.add(user);
    Comparator<? super UserData> byId = (u1,u2) -> Integer.compare(u1.getId(), u2.getId() );
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
