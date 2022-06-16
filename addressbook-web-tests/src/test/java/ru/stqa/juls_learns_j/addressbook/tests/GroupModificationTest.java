package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationManager().gotoGroupPage();
    if(!app.getGroupHelper().isThereAgroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
  }

  @Test
  public void testGroupModification() {



    List<GroupData> before=app.getGroupHelper().getGroupList();
    int index= before.size()-1;
    GroupData group =new GroupData(before.get(index).getId(),"test1", "test2","test3");
    app.getGroupHelper().modifiyGroup(index, group);
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId =(g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
