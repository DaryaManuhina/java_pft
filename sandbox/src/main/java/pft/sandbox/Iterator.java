package pft.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by asus-1 on 22.01.2017.
 */
public class Iterator {

    public static void main(String args[]) {
// create an array list
      List<String> al = new ArrayList<>();
// add elements to the array list
      al.add("C");
      al.add("A");
      al.add("E");
      al.add("B");
      al.add("D");
      al.add("F");
// use iterator to display contents of al
      System.out.print("Original contents of al: ");
     java.util.Iterator iterator = al.iterator();
            while(iterator.hasNext()) {

        Object element = iterator.next();
        System.out.print(element + " ");

      }
      System.out.println();

// modify objects being iterated
     ListIterator litr = al.listIterator();
      while(litr.hasNext()) {

        Object element = litr.next();
        litr.set(element + "+");

      }
      System.out.print("Modified contents of al: ");
      iterator = al.iterator();
      while(iterator.hasNext()) {

        Object element = iterator.next();
        System.out.print(element + " ");

      }
      System.out.println();
// now, display the list backwards
      System.out.print("Modified list backwards: ");
      while(litr.hasPrevious()) {

        Object element = litr.previous();
        System.out.print(element + " ");

      }
      System.out.println();
    }
  }




