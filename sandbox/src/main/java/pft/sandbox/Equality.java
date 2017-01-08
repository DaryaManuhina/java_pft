package pft.sandbox;

/**
 * Created by asus-1 on 08.01.2017.
 */
public class Equality {

  public  static void main ( String [] args){
    String s1 = "test 2.0";
    String s2 = "te" + "st " + Math.sqrt(4.0);
    System.out.println(s1 == s2); // сравнение ссылок
    System.out.println(s1.equals(s2)); // логическое сравнение: сравнение содержимого объектов

  }
}
