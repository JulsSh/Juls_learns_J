package ru.stqa.juls_learns_j.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  public   NavigationManager navigationManager;
  public GroupHelper groupHelper;

  public boolean isAlertPresent(WebDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   wd.get("http://localhost/addressbook/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationManager = new NavigationManager(wd);
    login("admin", "secret");
  }

  public void login(String username, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
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
