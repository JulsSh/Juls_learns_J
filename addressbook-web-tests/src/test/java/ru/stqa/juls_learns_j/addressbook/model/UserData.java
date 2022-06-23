package ru.stqa.juls_learns_j.addressbook.model;

import java.util.Objects;

public class UserData {
  private  int id=Integer.MAX_VALUE;;
  private  String firstName;
  private  String middleName;
  private String group;
  private  String lastName;
  private String nickname;
  private  String title;
  private  String company;
  private String address;
  private  String hoPhoneNum;
  private  String mobileNumber;
  private String workNumber;
  private String allPhones;

  public String getAllPhones() {
    return allPhones;
  }
  public UserData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
 public UserData withId(int id) {
    this.id = id;
    return this;
  }
  public UserData withFName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public UserData withMName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public UserData withGroup(String group) {
    this.group = group;
    return this;
  }

  public UserData withLName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public UserData withNick(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public UserData withTitle(String title) {
    this.title = title;
    return this;
  }

  public UserData withCompany(String company) {
    this.company = company;
    return this;
  }

  public UserData withAddress(String address) {
    this.address = address;
    return this;
  }

  public UserData withHomeNum(String hoPhoneNum) {
    this.hoPhoneNum = hoPhoneNum;
    return this;
  }

  public UserData withMobileNum(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  public UserData withWorkNum(String workNumber) {
    this.workNumber = workNumber;
    return this;
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

}
