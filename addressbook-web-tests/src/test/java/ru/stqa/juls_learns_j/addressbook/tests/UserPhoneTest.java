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
    assertThat(user1.getAddress(), equalTo(userInfoFromEditForm.getAddress()));
    assertThat(user1.getAllEmails(), equalTo(mergeEmails(userInfoFromEditForm)));

  }

  private String mergeEmails(UserData user2) {
    return Arrays.asList(user2.getEmail(),  user2.getEmail2(), user2.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(UserPhoneTest::cleaned2)
            .collect(Collectors.joining("\n"));
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
  public static String cleaned2(String addr){
    return addr.replaceAll("\\s","");
  }
}
