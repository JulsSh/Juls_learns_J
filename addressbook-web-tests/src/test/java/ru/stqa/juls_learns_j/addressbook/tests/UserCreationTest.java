package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;
import ru.stqa.juls_learns_j.addressbook.model.UserData;


public class UserCreationTest extends TestBase {



  @Test
  public void testUserCreation() throws Exception {


    app.getUserHelper().initUserCreation();
    app.getUserHelper().fillUserDetails(new UserData("JulsHHH", "jennifer", "juli",
            "jiliian", "senior QA", "LucanetAG", "Tabberstr 6C",
            "012345", "1791028611", "010 345845",
                        "[none]"), true);
    app.getUserHelper().submitUserCreation();
  }
}
