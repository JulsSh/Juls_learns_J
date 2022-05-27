package ru.stqa.juls_learns_j.addressbook.model;

public class GroupData {
  public  String groupName;
  public  String groupHeader;
  public  String groupFooter;

  public GroupData(String groupName, String groupHeader, String groupFooter) {
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getGroupHeader() {
    return groupHeader;
  }

  public String getGroupFooter() {
    return groupFooter;
  }
}
