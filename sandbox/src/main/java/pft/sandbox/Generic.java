package pft.sandbox;

import java.util.List;

/**
 * Created by asus-1 on 18.01.2017.
 */
public class Generic <T extends Number> {
  private T item;

  public void setItem(T item) {
    this.item = item;
  }

  public T getItem() {
    return item;
  }

  public static void main(String[] args) {
    Generic<Integer> i = new Generic<Integer>();
    i.setItem(4);
    System.out.println(i.getItem());

    Generic<Number> g = new Generic<Number>();
    g.setItem(5);

    Generic<Number> c = new Generic<>();
    c.setItem(5);

  //  sum(i, i);
   // sum(g, g);
    //sum1(i, i);
    //Generic<String> g = new Generic<String>(); // так как стринг от намбера не наследуюется
    // g.setItem("c");
  }

  /*public static Number sum(Generic<? extends Number> i, Generic<? extends Number> g) {
    return i.getItem() + g.getItem();
  }// ? - любое

  public static Number sum1(Generic<? super Number> i, Generic<? super Number> g) {
    return i.getItem() + g.getItem();
  }// ? - любое


  public class WildcardErrorBad {

    void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
      Number temp = l1.get(0);
      l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
      // got a CAP#2 extends Number;
      // same bound, but different types
      l2.set(0, temp);      // expected a CAP#1 extends Number,
      // got a Number
    }
  }*/
}

