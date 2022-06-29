package ru.stqa.juls_learns_j.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.juls_learns_j.addressbook.model.UserData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class UsersDataGenerator {
  @Parameter(names = "-c", description = "user count")
  public int count;
  @Parameter(names = "-f", description = "target file")
  public String file;
  @Parameter(names = "-d", description = "data format")
  public String format;

  public static void main(String[] args) throws IOException {
    UsersDataGenerator generator = new UsersDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();

  }

  private void run() throws IOException {

    List<UserData> users = generateUsers(count);
    if (format.equals("scv")) {
      saveAsCsv(users, new File(file));

    } else if (format.equals("xml")) {
      saveAsXML(users, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(users, new File(file));
    }else  {
      System.out.println("unrecognized format " + format);
    }

  }

  private void saveAsJson(List<UserData> users, File file) throws IOException {
    Gson gson=new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json=gson.toJson(users);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveAsXML(List<UserData> users, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(UserData.class);
    String xml = xstream.toXML(users);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCsv(List<UserData> users, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (UserData user : users) {
      writer.write(String.format("%s;%s;%s\n", user.getFirstName(), user.getLastName(), user.getAddress()));
    }
    writer.close();
  }

  private List<UserData> generateUsers(int count) {
    List<UserData> users = new ArrayList<UserData>();
    for (int i = 0; i < count; i++) {
      users.add(new UserData().withFName(String.format("firstname %s", i))
              .withLName(String.format("lastname\n%s", i))
              .withAddress(String.format("adress\n%s", i)));
    }
    return users;
  }

}
