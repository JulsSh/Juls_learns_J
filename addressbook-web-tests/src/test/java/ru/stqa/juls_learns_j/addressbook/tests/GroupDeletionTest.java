package ru.stqa.juls_learns_j.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;
import ru.stqa.juls_learns_j.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().all().size()==0) {
      app.group().create(new GroupData().withGroupName("test2"));
    }
  }
  @Test
  public void testDeleteGroup() throws Exception {

    Groups before=app.group().all();
    GroupData deletedGroup =before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after=app.group().all();
    assertEquals(after.size(), before.size() -1);
    assertThat(after, equalTo(after.withoutAdded(deletedGroup)));
    }
}



