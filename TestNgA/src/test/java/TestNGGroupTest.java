import org.testng.annotations.Test;

/**
 * Created by asus-1 on 20.01.2017.
 */
public class TestNGGroupTest {
  @Test(groups={"unit1","integration"})
  public void testingMethod1() {
    System.out.println("testingMethod1");
  }

  @Test(groups={"unit2","integration"})
  public void testingMethod2() {
    System.out.println("testingMethod2");
  }

  @Test(groups={"unit1"})
  public void testingMethod3() {
    System.out.println("testingMethod3");
  }

  @Test(groups={"unit1", "unit2"})
  public void testingMethod4() {
    System.out.println("testingMethod4");
  }
}
