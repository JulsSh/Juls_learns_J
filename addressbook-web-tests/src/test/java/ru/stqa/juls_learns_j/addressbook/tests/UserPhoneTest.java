package ru.stqa.juls_learns_j.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class UserPhoneTest extends TestBase{
  @Test
  public void testUserPhones(){
    app.goTo().goToHomePage();
    UserData user1 =app.user().all().iterator().next();
    UserData userInfoFromEditForm =app.user().infoFromEditForm(user1);
    assertThat(user1.getAllPhones(), equalTo(mergePhones(userInfoFromEditForm)));
    //assertThat(user1.getAllPhones(), equalTo(mergePhones(userInfoFromEditForm)));
  }

  private String mergePhones(UserData user1) {
    return Arrays.asList(user1.getHoPhoneNum(),  user1.getMobileNumber(), user1.getWorkNumber())
            .stream().filter((s) -> !s.equals(""))
            .map(UserPhoneTest::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("-","");
  }
}
