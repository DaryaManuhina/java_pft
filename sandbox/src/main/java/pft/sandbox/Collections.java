package pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by asus-1 on 18.01.2017.
 */
public class Collections {
  public static void main(String[] args) {
    String [] langs = new String [4];
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Phyton";
    langs[1] = "PHP";

    String [] langsNew = {"Java", "C#", "Phyton", "PHP" };

    for (int i = 0; i < langsNew.length; i++){
      System.out.println("I Need in " + langsNew[i]);
    }
    for (String l: langsNew){
      System.out.println("I Need in " + l);
    }

    List<String> langList = new ArrayList<String>();
    langList.add("Java");
    langList.add("C#");
    langList.add("PHP");

    for (String l: langList){
      System.out.println("I Need in " + l);
    }
    List<String> langListNew = Arrays.asList("Java", "C#", "Phyton", "PHP" );
    for (int i = 0; i < langListNew.size(); i++) {
      System.out.println("I Need in " + langListNew.get(i));
    }

  }
  }
