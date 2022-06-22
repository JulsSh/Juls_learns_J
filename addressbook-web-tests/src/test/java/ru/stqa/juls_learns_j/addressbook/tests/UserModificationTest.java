package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class UserModificationTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    if(app.user().all().size()==0){
      app.user().create(new UserData().withFName("Julia"));
    }
  }
  @Test
  public void  modifyUser(){
    app.goTo().goToHomePage();
    Set<UserData> before =app.user().all();
    UserData modifiedUser=before.iterator().next();
    UserData user =new UserData().withId(modifiedUser.getId()).withFName("JulsHHH").withLName("juli").withGroup("[none]");
    app.user().modify(user);
    Set<UserData> after =app.user().all();
    Assert.assertEquals(after.size(),before.size());
    before.remove(modifiedUser);
    before.add(user);
    Assert.assertEquals(before, after);
  }
}
