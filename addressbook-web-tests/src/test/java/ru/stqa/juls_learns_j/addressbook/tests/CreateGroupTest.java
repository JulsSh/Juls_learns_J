package ru.stqa.juls_learns_j.addressbook.tests;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.*;

import ru.stqa.juls_learns_j.addressbook.model.GroupData;
import ru.stqa.juls_learns_j.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateGroupTest extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {

    BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/groups.json")));
    String json="";
    String line =reader.readLine();
while (line !=null){
  json += line;
  line=reader.readLine();
}
    Gson gson=new Gson();
    List<GroupData> groups=gson.fromJson(json,new TypeToken<List<GroupData>>(){}.getType()); //List<GroupData>.class
  return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {

    BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml="";
    String line =reader.readLine();
    while (line !=null){
      xml += line;
      line=reader.readLine();
    }
    XStream xstream= new XStream();
    xstream.processAnnotations(GroupData.class);
    xstream.addPermission(AnyTypePermission.ANY);
    List<GroupData> groups=(List<GroupData>) xstream.fromXML(xml);
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider="validGroupsFromJson")

  public void testCreateGroup(GroupData group) throws Exception {
String[] names =new String[] {"test", "test1","test2"};

          app.goTo().groupPage();
          Groups before=app.group().all();
          app.group().create(group);
          app.goTo().groupPage();
          Groups after=app.group().all();
          assertThat(after.size(), equalTo(before.size()+1));

          assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


    }
  @Test(enabled = false)
  public void testBadCreateGroup() throws Exception {

    app.goTo().groupPage();
    Groups before=app.group().all();
    GroupData group =new GroupData().withGroupName("test2'");
    app.group().create(group);
    app.goTo().groupPage();
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after=app.group().all();
    assertThat(after, equalTo(before));
  }

}
