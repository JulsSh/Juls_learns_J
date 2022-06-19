package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.juls_learns_j.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class CreateGroupTest extends TestBase {

  @Test
  public void testCreateGroup() throws Exception {

    app.goTo().groupPage();
    Set<GroupData> before=app.group().all();
    GroupData group =new GroupData().withGroupName("test2");

    app.group().create(group);
    app.goTo().groupPage();
    Set<GroupData> after=app.group().all();

    //Assert.assertEquals(after.size(), before.size() +1);
   group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    before.add(group);
        Assert.assertEquals(before, after);
  }

}
