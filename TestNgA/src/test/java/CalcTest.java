import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by asus-1 on 20.01.2017.
 */
public class CalcTest {

  private Calc calc = new Calc();

  @Test
  public void testSum() throws Exception {
    Assert.assertEquals(5, calc.sum(2,3));
  }
}
