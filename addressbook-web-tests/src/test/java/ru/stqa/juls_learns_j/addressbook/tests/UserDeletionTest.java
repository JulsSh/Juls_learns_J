package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

public class UserDeletionTest extends TestBase{
  @Test
  public void  deleteUser(){
    app.getUserHelper().gotoUsers();
    app.getUserHelper().selectUser();
    app.getUserHelper().deleteSelectedUser();




  }
}
