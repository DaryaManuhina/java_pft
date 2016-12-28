package pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.DefaultEditorKit;

/**
 * Created by asus-1 on 27.12.2016.
 */
public class SquareTests {
  @Test

  public void testArea(){
   Square s = new Square(5);
 // assert s.area() == 25;
    Assert.assertEquals(s.area(), 25.0);

  }
}
