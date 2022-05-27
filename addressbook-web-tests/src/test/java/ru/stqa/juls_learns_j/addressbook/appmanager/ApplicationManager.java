package ru.stqa.juls_learns_j.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  WebDriver wd;
  private SessionHelper sessionHelper;
  private NavigationManager navigationManager;
  private GroupHelper groupHelper;


  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   wd.get("http://localhost/addressbook/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationManager = new NavigationManager(wd);
    sessionHelper=new SessionHelper(wd);
    sessionHelper.login("admin","secret");
  }




  public void logout() {
   wd.findElement(By.linkText("Logout")).click();
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationManager getNavigationManager() {
    return navigationManager;
  }
}
