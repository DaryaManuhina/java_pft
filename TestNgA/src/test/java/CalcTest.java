import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

/**
 * Created by asus-1 on 20.01.2017.
 */
public class CalcTest {

  private Calc calc = new Calc();



  @BeforeMethod
  public void setUp() throws Exception {
    System.out.println("@BeforeMethod");
  }

  @AfterMethod
  public void tearDown() throws Exception {
    System.out.println("@AfterMethod");
  }

  @BeforeGroups
  public void beforeGroups() throws Exception {
    System.out.println("BeforeGroups");
  }

  @AfterGroups
  public void afterGroups() throws Exception {
    System.out.println("@AfterGroups");
  }

  @BeforeClass
  public void beforeClass() throws Exception {
    System.out.println("@BeforeClass");
  }

  @BeforeTest
  public void beforeTest() throws Exception {
    System.out.println("@BeforeTest");
  }

  @AfterTest
  public void afterTest() throws Exception {
    System.out.println("@AfterTest");
  }

  @AfterClass
  public void afterClass() throws Exception {
    System.out.println("@AfterClass");
  }

  @BeforeSuite
  public void beforeSuite() throws Exception {
    System.out.println("@BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() throws Exception {
    System.out.println("@AfterSuite");
  }

  @Test
  public void testSum() throws Exception {
    System.out.println("@Test");
    Assert.assertEquals(5, calc.sum(2,3));
  }

// тест успешно пройдет так как мы ожидаем указанную ошибку
    @Test(expectedExceptions = NullPointerException.class)
    public void testNullPointerException() {
      List list = null;
      int size = list.size();
    }
// отключили тест
  @Test(enabled = false)
  public void testsetProperty() {
    System.out.println("Этот метод будет проигнорирован в момент проведения тестирования!");
  }
// тест свалится так как он ограничен по времени
  @Test(timeOut = 1000)
  public void waitLongTime() throws Exception {
    Thread.sleep(1001);
  }
}
