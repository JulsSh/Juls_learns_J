package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.util.List;

public class UserDeletionTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    if(app.user().list().size()==0){
      app.user().create(new UserData("Julia",
              "SH","k","hh","zu","op",
              "Ta","123","123","98",null));
    }
  }

  @Test
  public void  deleteUser(){
    app.goTo().goToHomePage();
    List<UserData> before =app.user().list();
    UserData user =new UserData( "JulsHHH", null, "juli", null,
            null, null, null,null, null,
            null, null);
    int i=before.size()-1;
    app.user().delete(i);
    List<UserData> after =app.user().list();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(i);
    Assert.assertEquals(before, after);

    }

}
