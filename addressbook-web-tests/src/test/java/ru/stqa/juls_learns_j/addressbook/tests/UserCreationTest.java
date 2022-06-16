package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.util.List;


public class UserCreationTest extends TestBase {


  @Test
  public void testUserCreation() throws Exception {

    app.getUserHelper().gotoUsers();

    int before=app.getGroupHelper().getUserCount();

    app.getUserHelper().initUserCreation();

    app.getUserHelper().fillUserDetails(new UserData("JulsHHH", "jennifer", "juli",
            "jiliian", "senior QA", "LucanetAG", "Tabberstr 6C",
            "012345", "1791028611", "010 345845",
            ""), true);


    app.getUserHelper().submitUserCreation();
    app.getUserHelper().gotoUsers();
    int after =app.getUserHelper().getUserCount();
    Assert.assertEquals(after,before+1);
  }
}
