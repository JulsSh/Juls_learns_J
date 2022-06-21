package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

public class UserDeletionTest extends TestBase{
  @Test
  public void  deleteUser(){
    app.getUserHelper().gotoUsers();
    if(!app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createNewUser( new UserData("Juls", "jennifer", "juli", "jiliian", "senior QA", "LucanetAG", "Tabberstr 6C", "012345", "1791028611", "010 345845", "test1"));
    }
    app.getNavigationManager().goToHomePage();
    app.getUserHelper().selectUser();
    app.getUserHelper().deleteSelectedUser();
    app.getUserHelper().submitUserDeletion();





  }
}
