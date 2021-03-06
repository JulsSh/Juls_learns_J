package ru.stqa.juls_learns_j.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.juls_learns_j.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {
  @Parameter(names = "-c", description = "group count")
  public int count;
  @Parameter(names = "-f", description = "target file")
  public String file;
  @Parameter(names = "-d", description = "data format")
  public String format;

  public static void main(String[] args) throws IOException {
    GroupDataGenerator generator = new GroupDataGenerator();
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

    List<GroupData> groups = generateGroups(count);
    if (format.equals("scv")) {
      saveAsCsv(groups, new File(file));

    } else if (format.equals("xml")) {
      saveAsXML(groups, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(groups, new File(file));
    }else  {
    System.out.println("unrecognized format " + format);
  }

}

  private void saveAsJson(List<GroupData> groups, File file) throws IOException {
    Gson gson=new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json=gson.toJson(groups);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveAsXML(List<GroupData> groups, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    String xml = xstream.toXML(groups);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCsv(List<GroupData> groups, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (GroupData group : groups) {
      writer.write(String.format("%s;%s;%s\n", group.getGroupName(), group.getGroupHeader(), group.getGroupFooter()));
    }
    writer.close();
  }

  private List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<GroupData>();
    for (int i = 0; i < count; i++) {
      groups.add(new GroupData().withGroupName(String.format("test %s", i))
              .withGroupHeader(String.format("header\n%s", i))
              .withGroupFooter(String.format("footer\n%s", i)));
    }
    return groups;
  }

}
