package ru.stqa.juls_learns_j.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.File;
import java.util.Objects;
@XStreamAlias("user")
public class UserData {
  private  int id=Integer.MAX_VALUE;
  @Expose
  private  String firstName;
  private  String middleName;
  private String group;
  @Expose
  private  String lastName;
  private String nickname;
  private  String title;
  private  String company;
  @Expose
  private String address;
  private  String hoPhoneNum;
  private  String mobileNumber;
  private String workNumber;
  private String allPhones;
  private String email;
  private String email2;
  private String email3;
  private String allEmails;

  public UserData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public File getPhoto() {
    return photo;
  }

  private File photo;

  public UserData withEmail(String email) {
    this.email = email;
    return this;
  }

  public UserData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public UserData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public UserData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
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
    return id == userData.id && Objects.equals(firstName, userData.firstName) && Objects.equals(lastName, userData.lastName) && Objects.equals(address, userData.address) && Objects.equals(hoPhoneNum, userData.hoPhoneNum) && Objects.equals(mobileNumber, userData.mobileNumber) && Objects.equals(workNumber, userData.workNumber) && Objects.equals(allPhones, userData.allPhones) && Objects.equals(email, userData.email) && Objects.equals(email2, userData.email2) && Objects.equals(email3, userData.email3) && Objects.equals(allEmails, userData.allEmails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, address, hoPhoneNum, mobileNumber, workNumber, allPhones, email, email2, email3, allEmails);
  }

  @Override
  public String toString() {
    return "UserData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", hoPhoneNum='" + hoPhoneNum + '\'' +
            ", mobileNumber='" + mobileNumber + '\'' +
            ", workNumber='" + workNumber + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", allEmails='" + allEmails + '\'' +
            '}';
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
  public String getAllPhones() {    return allPhones;  }
  public String getEmail() { return email;  }
  public String getEmail2() {    return email2;  }
  public String getEmail3() {    return email3;  }
  public String getAllEmails() {    return allEmails;  }

}
