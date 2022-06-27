package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.annotations.*;

import ru.stqa.juls_learns_j.addressbook.model.GroupData;
import ru.stqa.juls_learns_j.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateGroupTest extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]>list= new ArrayList<Object[]>();
    list.add(new Object[]{new GroupData().withGroupName("test1").withGroupHeader("header1").withGroupFooter("footer1")});
    list.add(new Object[]{new GroupData().withGroupName("test2").withGroupHeader("header2").withGroupFooter("footer2")});
    list.add(new Object[]{new GroupData().withGroupName("test3").withGroupHeader("header3").withGroupFooter("footer3")});
    return list.iterator();
  }

  @Test(dataProvider="validGroups")
  public void testCreateGroup(GroupData group) throws Exception {
String[] names =new String[] {"test1", "test2","test3"};

          app.goTo().groupPage();
          Groups before=app.group().all();
          app.group().create(group);
          app.goTo().groupPage();
          Groups after=app.group().all();
          assertThat(after.size(), equalTo(before.size()+1));
          assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)
                  -> g.getId()).max().getAsInt()))));


    }
  @Test
  public void testBadCreateGroup() throws Exception {

    app.goTo().groupPage();
    Groups before=app.group().all();
    GroupData group =new GroupData().withGroupName("test2'");
    app.group().create(group);
    app.goTo().groupPage();
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after=app.group().all();
    assertThat(after, equalTo(before));
  }

}
