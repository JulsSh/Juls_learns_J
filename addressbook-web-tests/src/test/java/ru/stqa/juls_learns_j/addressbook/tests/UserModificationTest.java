package ru.stqa.juls_learns_j.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;
import ru.stqa.juls_learns_j.addressbook.model.Users;

import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

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
   Users before =app.user().all();
    UserData modifiedUser=before.iterator().next();
    UserData user =new UserData().withId(modifiedUser.getId()).withFName("JulsHHH").withLName("juli").withGroup("[none]");
    app.user().modify(user);
    Users after =app.user().all();
    assertEquals(after.size(),before.size());
    before.remove(modifiedUser);
    before.add(user);
    assertEquals(before, after);
    assertThat(after, CoreMatchers.equalTo(before.without(modifiedUser).withAdded(user)));
  }
}
