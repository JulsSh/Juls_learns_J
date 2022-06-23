package ru.stqa.juls_learns_j.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;
import ru.stqa.juls_learns_j.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

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
    Groups before=app.group().all();
    GroupData modifiedGroup =before.iterator().next();
    GroupData group =new GroupData().withId(modifiedGroup.getId()).withGroupName("test1").withGroupHeader("test2").
            withGroupFooter("test3");
    app.group().modify( group);
    Groups after=app.group().all();
    assertThat(app.group().count(), equalTo(before.size()));
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withoutAdded(modifiedGroup).withAdded(group)));
  }
}
