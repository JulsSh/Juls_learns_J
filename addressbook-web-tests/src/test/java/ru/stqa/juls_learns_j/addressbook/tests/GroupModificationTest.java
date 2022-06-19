package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().all().size()==0) {
      app.group().create(new GroupData().withGroupName("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    Set<GroupData> before=app.group().all();
    GroupData modifiedGroup =before.iterator().next();

    GroupData group =new GroupData().withId(modifiedGroup.getId()).withGroupName("test1").withGroupHeader("test2").
            withGroupFooter("test3");
    app.group().modify( group);
    Set<GroupData> after=app.group().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before, after);
  }
}
