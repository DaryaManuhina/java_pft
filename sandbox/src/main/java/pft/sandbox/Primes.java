package pft.sandbox;

/**
 * Created by asus-1 on 17.01.2017.
 */
public class Primes {

  public static boolean isPrime(int n) {
    int m = (int) Math.sqrt(n);
    for (int i = 2; 1 < m; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < n && n % i == 0) {
      i++;
    }
    return i == n;
  }
}
