package pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by asus-1 on 29.12.2016.
 */
public class EqTest {
  @Test
  public void test0(){
    Equation e = new Equation(1,1,1);
    Assert.assertEquals(e.rootNumber(), 0);
  }
  @Test
  public void test1(){
    Equation e = new Equation(1,2,1);
    Assert.assertEquals(e.rootNumber(), 1);
  }
  @Test
  public void test2(){
    Equation e = new Equation(1,5,6);
    Assert.assertEquals(e.rootNumber(), 2);
  }

  public void test3(){
    Equation e = new Equation(0,1,1);
    Assert.assertEquals(e.rootNumber(), 1);}

    public void test4(){
      Equation e = new Equation(0,0,1);
      Assert.assertEquals(e.rootNumber(), 0);
    }

  public void test5(){
    Equation e = new Equation(0,0,0);
    Assert.assertEquals(e.rootNumber(), -1);}
  }


