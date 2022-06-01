package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification() {
    app.getNavigationManager().gotoGroupPage();
    if(!app.getGroupHelper().isThereAgroup()) {
      app.getGroupHelper().createGroup(new GroupData("juli", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupInfo(new GroupData("test1", "test2","test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();

  }
}
