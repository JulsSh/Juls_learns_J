package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {
    app.getNavigationManager().gotoGroupPage();
    if(!app.getGroupHelper().isThereAgroup()) {
     app.getGroupHelper().createGroup(new GroupData("juli", null, null));

    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }


}
