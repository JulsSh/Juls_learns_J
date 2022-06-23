package ru.stqa.juls_learns_j.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class UserPhoneTest extends TestBase{
  @Test
  public void testUserPhones(){
    app.goTo().goToHomePage();
    UserData user1 =app.user().all().iterator().next();
    UserData userInfoFromEditForm =app.user().infoFromEditForm(user1);

    assertThat(user1.getFirstName(), equalTo(cleaned(userInfoFromEditForm.getFirstName())));
    assertThat(user1.getHoPhoneNum(), equalTo(cleaned(userInfoFromEditForm.getHoPhoneNum())));
    assertThat(user1.getMobileNumber(), equalTo(cleaned(userInfoFromEditForm.getMobileNumber())));
    assertThat(user1.getWorkNumber(), equalTo(cleaned(userInfoFromEditForm.getWorkNumber())));

  }
  public String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("-","");
  }
}
