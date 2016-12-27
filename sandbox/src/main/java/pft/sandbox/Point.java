package pft.sandbox;

/**
 * Created by asus-1 on 27.12.2016.
 */
public class Point {
  double x;
  double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double newDistance(Point a)
  {
       return Math.sqrt( Math.pow(this.x-a.x, 2) + Math.pow(this.y-a.y, 2) );
  }

}


