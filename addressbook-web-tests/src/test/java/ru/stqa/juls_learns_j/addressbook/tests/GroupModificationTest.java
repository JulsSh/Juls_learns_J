package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification() {

    app.getNavigationManager().gotoGroupPage();
    int before =app.getGroupHelper().getGroupCount();
    if(!app.getGroupHelper().isThereAgroup()) {
      app.getGroupHelper().createGroup(new GroupData("juli", null, null));
    }
    app.getGroupHelper().selectGroup(before -1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupInfo(new GroupData("test1", "test2","test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    int after =app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before );

  }
}
