package pft.sandbox;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by asus-1 on 17.01.2017.
 */
public class PrimeTest {

  @Test (enabled = false)
  public void testPrimes(){
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testnotPrimes(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }
}
