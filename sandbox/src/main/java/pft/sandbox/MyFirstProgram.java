package pft.sandbox;

import java.math.RoundingMode;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("darling");
    hello("user");


    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 5);
      System.out.println("Площадь прямоугольника со сторонами " + r.a + " и "+ r.b + " = " + r.area());

      Point p1 = new Point (1, 3);
     Point p2 = new Point (2, 4);

    System.out.println("Расстояние между двумя точками с координатами" + p1.x + "," + p1.y + " и " + p2.x + "," + p2.y + " = " + distance(p1, p2));

    System.out.println(p2.newDistance(p1));
  }

  public static void hello(String somebody) {
     System.out.println("Hello, " + somebody + "!");
  }

  public static double distance(Point p1, Point p2)
  {
    return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
  }
}