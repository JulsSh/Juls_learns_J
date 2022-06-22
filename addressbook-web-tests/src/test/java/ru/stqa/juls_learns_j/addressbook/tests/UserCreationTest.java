package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;
import ru.stqa.juls_learns_j.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class UserCreationTest extends TestBase {


  @Test
  public void testUserCreation() throws Exception {
    app.goTo().goToHomePage();
   Users before =app.user().all();
    UserData user =new UserData().withFName("JulsHHH").withLName("juli");
    app.user().create(user);
    app.goTo().goToHomePage();
    Users after =app.user().all();
    assertThat(after.size(), equalTo (before.size()+1));
    assertThat(after, equalTo(
            before.withAdded(user.withId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt()))));
  }

}
