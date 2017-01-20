import org.testng.annotations.Test;

/**
 * Created by asus-1 on 20.01.2017.
 */
public class TestNGDependencyTest {
  // тестовый класс в котором есть 2 тестовых метода, где один зависит от другого,
  // то есть первый не пройдет успешно пока не отработает второй.

  @Test
  public void initEnvironmentTest() {
    System.out.println("This is initEnvironmentTest");
  }

  @Test(dependsOnMethods={"initEnvironmentTest"})
  public void testmethod() {
    System.out.println("This is testmethod");
  }

//  утанавливем зависимость на группу
  @Test(groups = { "init" })
  public void initEnvironmentTest1() {
    System.out.println("This is initEnvironmentTest1 groups");
  }

  @Test(groups = { "init" })
  public void initEnvironmentTest2() {
    System.out.println("This is initEnvironmentTest2 groups");
  }

  @Test(dependsOnGroups={"init"})
  public void testmethodGroups() {
    System.out.println("This is testmethod groups");
  }
}
