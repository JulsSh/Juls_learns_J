package ru.stqa.juls_learns_j.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.juls_learns_j.addressbook.TestBase;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testDeleteGroup() throws Exception {
    app.getNavigationManager().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }


}
