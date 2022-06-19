package ru.stqa.juls_learns_j.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

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

    Set<GroupData> before=app.group().all();
    GroupData deletedGroup =before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after=app.group().all();
    app.goTo().groupPage();
    //Assert.assertEquals(after.size(), before.size() -1);
    before.remove(deletedGroup);
    Assert.assertEquals(before,after);

    }


}



