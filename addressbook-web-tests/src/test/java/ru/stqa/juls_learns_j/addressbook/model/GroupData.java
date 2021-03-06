package ru.stqa.juls_learns_j.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.ArrayList;
import java.util.Objects;

@XStreamAlias("group")
public class GroupData {
  @XStreamOmitField
  private int id= Integer.MAX_VALUE;
  @Expose
  public  String groupName;
  @Expose
  public  String groupHeader;
  @Expose
  public  String groupFooter;


  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withGroupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

  public GroupData withGroupHeader(String groupHeader) {
    this.groupHeader = groupHeader;
    return this;
  }

  public GroupData withGroupFooter(String groupFooter) {
    this.groupFooter = groupFooter;
    return this;
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
  public String toString() {
    return "GroupData{" +
            "id=" + id +
            ", groupName='" + groupName + '\'' +
            '}';
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

}
