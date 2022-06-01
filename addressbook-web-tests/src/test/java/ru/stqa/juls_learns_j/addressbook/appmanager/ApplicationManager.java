package ru.stqa.juls_learns_j.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.Browser.FIREFOX;

public class ApplicationManager {

  WebDriver wd;
  private SessionHelper sessionHelper;
  private NavigationManager navigationManager;
  private GroupHelper groupHelper;
  private UserHelper userHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void init() {

    if (browser.equals (BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    }else if (browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    }else if (browser.equals(BrowserType.IE)){
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
   wd.get("http://localhost/addressbook/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    userHelper =new UserHelper(wd);
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

  public UserHelper getUserHelper() {
    return userHelper;
  }
}
