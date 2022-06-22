package ru.stqa.juls_learns_j.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;
import ru.stqa.juls_learns_j.addressbook.model.Users;

import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class UserDeletionTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    if(app.user().all().size()==0){
      app.user().create(new UserData().withFName("Julia"));
    }
  }

  @Test
  public void  deleteUser(){
    app.goTo().goToHomePage();
    Users before =app.user().all();
    UserData delUser=before.iterator().next();
    app.user().delete(delUser);
    Users after =app.user().all();
    assertEquals(after.size(),before.size()-1);
    before.remove(delUser);
    assertThat(after, CoreMatchers.equalTo(before.without(delUser)));
    assertEquals(before, after);

    }

}
