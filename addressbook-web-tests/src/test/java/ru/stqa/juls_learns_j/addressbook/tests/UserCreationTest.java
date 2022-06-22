package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class UserCreationTest extends TestBase {


  @Test
  public void testUserCreation() throws Exception {
    app.goTo().goToHomePage();
    Set<UserData> before =app.user().all();
    UserData user =new UserData().withFName("JulsHHH").withLName("juli");
    app.user().create(user);
    app.goTo().goToHomePage();
    Set<UserData> after =app.user().all();
    Assert.assertEquals(after.size(),before.size()+1);

    user.withId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt());
    before.add(user);
    Assert.assertEquals(before, after);
  }

}
