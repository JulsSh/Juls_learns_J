package ru.stqa.juls_learns_j.addressbook.model;

import java.util.Objects;

public class GroupData {
  private  int id;
  public  String groupName;
  public  String groupHeader;
  public  String groupFooter;

  public GroupData(int id, String groupName, String groupHeader, String groupFooter) {
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
    this.id = id;
  }
  public GroupData( String groupName, String groupHeader, String groupFooter) {
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
    this.id = 0;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id && Objects.equals(groupName, groupData.groupName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, groupName);
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", groupName='" + groupName + '\'' +
            '}';
  }

}
