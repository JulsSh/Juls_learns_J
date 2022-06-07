package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {

    app.getNavigationManager().gotoGroupPage();

    if(!app.getGroupHelper().isThereAgroup()) {
     app.getGroupHelper().createGroup(new GroupData("juli", null, null));
    }
    List<GroupData> before=app.getGroupHelper().getGroupList();

    app.getGroupHelper().selectGroup(before.size() -1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after=app.getGroupHelper().getGroupList();

    Assert.assertEquals(after, before.size() -1);
  }


}
