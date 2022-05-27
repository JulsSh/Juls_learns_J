package ru.stqa.juls_learns_j.addressbook.model;

public class UserData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String hoPhoneNum;
  private final String mobileNumber;
  private final String workNumber;

  public UserData(String firstName, String middleName, String lastName, String nickname, String title, String company, String address, String hoPhoneNum, String mobileNumber, String workNumber) {
    this.firstName = firstName;
    this.middleName = middleName;
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
}
