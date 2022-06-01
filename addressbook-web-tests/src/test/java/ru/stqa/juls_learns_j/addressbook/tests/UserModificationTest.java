package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

public class UserModificationTest extends TestBase{
  @Test
  public void  modifyUser(){

    app.getUserHelper().editUserDetails(new UserData("Juls edit", "jennifer edit", "Birkinedit", "jiliianedit", "senior QA edit", "LucanetAG edit", "Tabberstr 6C edit", "0123456", "17910286119", "010 3458459"));



  }
}
