package ru.stqa.juls_learns_j.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.juls_learns_j.addressbook.appmanager.ApplicationManager;

public class TestBase {

  public static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown()  {
    app.logout();
      }

  public ApplicationManager getApp() {
    return app;
  }
}
