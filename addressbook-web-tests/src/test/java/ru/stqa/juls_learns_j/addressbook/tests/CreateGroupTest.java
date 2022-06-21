package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.juls_learns_j.addressbook.model.GroupData;

public class CreateGroupTest extends TestBase {

  @Test
  public void testCreateGroup() throws Exception {
    int before =app.getGroupHelper().getGroupCount();
    app.getNavigationManager().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupInfo(new GroupData("juli", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    int after =app.getGroupHelper().getGroupCount();
    Assert.assertEquals(before+1, after);

  }

}
