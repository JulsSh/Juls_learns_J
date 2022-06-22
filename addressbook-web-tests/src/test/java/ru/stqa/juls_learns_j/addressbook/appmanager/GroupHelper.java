package ru.stqa.juls_learns_j.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;
import ru.stqa.juls_learns_j.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HeplperBase{

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupInfo(GroupData groupData) {
    type(By.name("group_name"), groupData.getGroupName());
    type(By.name("group_header"), groupData.getGroupHeader());
    type(By.name("group_footer"), groupData.getGroupFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.xpath("//div[@id='content']/form/input[5]"));
  }

  public void selectGroupbyId(int id) {
    wd.findElement(By.cssSelector("input[value='" +id  + "']")).click();

  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }


  public void create(GroupData group) {

   initGroupCreation();
   fillGroupInfo(group);
   submitGroupCreation();
   returnToGroupPage();
  }
  public void modify( GroupData group) {
    selectGroupbyId(group.getId());
    initGroupModification();
    fillGroupInfo(group);
    submitGroupModification();
    returnToGroupPage();

  }

  public void delete(GroupData group) {
    selectGroupbyId(group.getId());
    deleteSelectedGroups();
    returnToGroupPage();
  }
  public boolean isThereAgroup() {
    return isElementPresent(By.name("selected[]"));
  }


  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }


  public Groups all() {
   Groups groups =new Groups();
    List<WebElement> elements =wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id=Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withGroupName(name));
    }
    return groups;
  }
  public int getUserCount() {
    return wd.findElements(By.name("selected[]")).size();
  }


}
