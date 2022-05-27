package ru.stqa.juls_learns_j.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.juls_learns_j.addressbook.appmanager.ApplicationManager;

public class TestBase {

  public  ApplicationManager app = new ApplicationManager();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown()  {
    app.logout();
    app.stop();
  }

  public ApplicationManager getApp() {
    return app;
  }
}
