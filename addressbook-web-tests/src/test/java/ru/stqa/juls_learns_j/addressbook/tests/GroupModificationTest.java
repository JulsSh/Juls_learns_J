package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification() {

    app.getNavigationManager().gotoGroupPage();

    if(!app.getGroupHelper().isThereAgroup()) {
      app.getGroupHelper().createGroup(new GroupData("juli", null, null));
    }
    List<GroupData> before=app.getGroupHelper().getGroupList();

    app.getGroupHelper().selectGroup(before.size() -1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupInfo(new GroupData("test1", "test2","test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after=app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() );

  }
}
