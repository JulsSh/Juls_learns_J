package ru.stqa.juls_learns_j.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  public void testDistance(){
    Point p1 = new Point(6, 0);

    Point p2 = new Point(30, 40);
    Assert.assertEquals(p1.distance(p2), 46.647615158762406 );
  }

  @Test
  public void testDistance2(){
    Point p1 = new Point(-6, 0);

    Point p2 = new Point(-9, -67);
    Assert.assertEquals(p1.distance(p2), 67.06713054842886);

  }
}
