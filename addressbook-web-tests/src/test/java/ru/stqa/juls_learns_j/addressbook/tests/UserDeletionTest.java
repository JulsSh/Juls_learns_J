package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.util.List;
import java.util.Set;

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
    Set<UserData> before =app.user().all();
    UserData delUser=before.iterator().next();
    app.user().delete(delUser);
    Set<UserData> after =app.user().all();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(delUser);
    Assert.assertEquals(before, after);

    }

}
