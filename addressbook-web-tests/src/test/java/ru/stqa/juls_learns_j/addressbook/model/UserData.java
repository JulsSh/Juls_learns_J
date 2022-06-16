package ru.stqa.juls_learns_j.addressbook.model;

import java.util.Objects;

public class UserData {


  public void setId(int id) {
    this.id = id;
  }

  private  int id;
  private final String firstName;
  private final String middleName;
  private final String group;
  private final String lastName;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String hoPhoneNum;
  private final String mobileNumber;
  private final String workNumber;


  public UserData(int id, String firstName, String middleName, String lastName, String nickname, String title, String company, String address, String hoPhoneNum, String mobileNumber, String workNumber, String group) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.group = group;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.hoPhoneNum = hoPhoneNum;
    this.mobileNumber = mobileNumber;
    this.workNumber = workNumber;

  }
  public UserData( String firstName, String middleName, String lastName, String nickname, String title, String company, String address, String hoPhoneNum, String mobileNumber, String workNumber, String group) {
    this.id = 0;
    this.firstName = firstName;
    this.middleName = middleName;
    this.group = group;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.hoPhoneNum = hoPhoneNum;
    this.mobileNumber = mobileNumber;
    this.workNumber = workNumber;

  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHoPhoneNum() {
    return hoPhoneNum;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public String getWorkNumber() {
    return workNumber;
  }

  public String getGroup() {
    return group;
  }
  public int getId() {
    return id;
  }
  @Override
  public String toString() {
    return "UserData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserData userData = (UserData) o;
    return id == userData.id && Objects.equals(firstName, userData.firstName) && Objects.equals(lastName, userData.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

}
