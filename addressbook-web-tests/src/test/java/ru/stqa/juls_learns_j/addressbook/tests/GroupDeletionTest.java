package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {

    app.getNavigationManager().gotoGroupPage();
    int before =app.getGroupHelper().getGroupCount();
    if(!app.getGroupHelper().isThereAgroup()) {
     app.getGroupHelper().createGroup(new GroupData("juli", null, null));
    }
    app.getGroupHelper().selectGroup(before -1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    int after =app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before -1);
  }


}
