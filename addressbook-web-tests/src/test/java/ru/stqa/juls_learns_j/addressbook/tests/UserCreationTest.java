package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class UserCreationTest extends TestBase {


  @Test
  public void testUserCreation() throws Exception {
    app.getUserHelper().gotoUsers();
    List<UserData> before =app.getUserHelper().getUserList();
    UserData user =new UserData( "JulsHHH", "jennifer", "juli", "jiliian", "senior QA", "LucanetAG", "Tabberstr 6C","012345", "1791028611", "010 345845",
            "[none]");
    app.getUserHelper().initUserCreation();
    app.getUserHelper().fillUserDetails(user, true);
    app.getUserHelper().submitUserCreation();
    app.getUserHelper().gotoUsers();
    List<UserData> after =app.getUserHelper().getUserList();
    Assert.assertEquals(after.size(),before.size()+1);
  user.setId(after.stream().max((o1, o2) -> Integer.compare((o1.getId()),o2.getId())).get().getId());
    before.add(user);
    Comparator<? super UserData> byId = (u1,u2) -> Integer.compare(u1.getId(), u2.getId() );
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
