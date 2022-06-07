package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.juls_learns_j.addressbook.model.GroupData;

import java.util.List;

public class CreateGroupTest extends TestBase {

  @Test
  public void testCreateGroup() throws Exception {

    app.getNavigationManager().gotoGroupPage();
    List<GroupData> before=app.getGroupHelper().getGroupList();

    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupInfo(new GroupData("juli2", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after=app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() +1);

  }

}
