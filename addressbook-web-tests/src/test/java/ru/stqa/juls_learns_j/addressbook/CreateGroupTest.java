package ru.stqa.juls_learns_j.addressbook;

import org.testng.annotations.*;


public class CreateGroupTest extends TestBAse{

  @Test
  public void testCreateGroup() throws Exception {

    gotoGroupPage();
    initGroupCreation();
    fillGroupInfo(new GroupData("juli", "julie header", "julie group footer"));
    submitGroupCreation();
    returntoGroupPage();

  }

}
