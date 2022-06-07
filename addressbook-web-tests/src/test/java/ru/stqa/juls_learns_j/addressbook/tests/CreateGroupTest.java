package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.juls_learns_j.addressbook.model.GroupData;

public class CreateGroupTest extends TestBase {

  @Test
  public void testCreateGroup() throws Exception {

    app.getNavigationManager().gotoGroupPage();
    int before =app.getGroupHelper().getGroupCount();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupInfo(new GroupData("juli2", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    int after =app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before +1);

  }

}
