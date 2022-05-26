package ru.stqa.juls_learns_j.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBAse{




  @Test
  public void testDeleteGroup() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returntoGroupPage();
  }


}
