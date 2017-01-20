package pft.sandbox;

/**
 * Created by asus-1 on 18.01.2017.
 */
public class Generic <T> {
  private T item;

  public void setItem(T item) {
    this.item = item;
  }

  public T getItem() {
    return item;
  }

  public static void main(String[] args) {
    Generic<Integer> i = new  Generic<Integer>();
    i.setItem(4);
    System.out.println(i.getItem());

    Generic<Number> g = new Generic<Number>();
    g.setItem(5);

  }
  }

