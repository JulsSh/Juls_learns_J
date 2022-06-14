package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.juls_learns_j.addressbook.model.GroupData;
import java.util.HashSet;
import java.util.List;

public class CreateGroupTest extends TestBase {

  @Test
  public void testCreateGroup() throws Exception {

    app.getNavigationManager().gotoGroupPage();
    List<GroupData> before=app.getGroupHelper().getGroupList();
    GroupData group =new GroupData("juli22", null, null);
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupInfo(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() +1);

    int max=0;
    for (GroupData g :after){
      if (g.getId() > max) {
        max=g.getId();


      }
    }
    //Comparator<? super GroupData> byId= (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
     before.add(group);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }

}
