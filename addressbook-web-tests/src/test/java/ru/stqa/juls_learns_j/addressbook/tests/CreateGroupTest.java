package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.juls_learns_j.addressbook.TestBase;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;


public class CreateGroupTest extends TestBase {

  @Test
  public void testCreateGroup() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupInfo(new GroupData("juli", "julie header", "julie group footer"));
    app.submitGroupCreation();
    app.returnToGroupPage();

  }

}
