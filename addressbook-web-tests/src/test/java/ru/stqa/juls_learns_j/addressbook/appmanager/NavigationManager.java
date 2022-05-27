package ru.stqa.juls_learns_j.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationManager {
  WebDriver wd;

  public NavigationManager(WebDriver wd) {
    this.wd=wd;
  }

  public void gotoGroupPage() {
    wd.findElement(By.xpath("//form[@action='/addressbook/addressbook/group.php']")).click();
  }
}
