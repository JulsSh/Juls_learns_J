package ru.stqa.juls_learns_j.addressbook.tests;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.juls_learns_j.addressbook.model.GroupData;
import ru.stqa.juls_learns_j.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateGroupTest extends TestBase {

  @Test
  public void testCreateGroup() throws Exception {

    app.goTo().groupPage();
    Groups before=app.group().all();
    GroupData group =new GroupData().withGroupName("test2");

    app.group().create(group);
    app.goTo().groupPage();
    Groups after=app.group().all();


    assertThat(after.size(), equalTo(before.size()+1));
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
