package ru.stqa.juls_learns_j.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationManager extends GroupHelper {

  public NavigationManager(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.xpath("//form[@action='/addressbook/addressbook/group.php']"));
  }
}
