package json.xml.project.LessonTwo_Java_OOP.candies.factory;

import json.xml.project.LessonTwo_Java_OOP.candies.createCandies.Candy;
import json.xml.project.LessonTwo_Java_OOP.candies.present.NewYearPresent;

import java.util.ArrayList;

//Create the Switch-case for changing needs New Year Present.
public class NewPresentFactory extends NewYearPresent {
    public static ArrayList<Candy> getNewPresent(ArrayList<Candy> list, int present ){
        switch (present) {
            case 1:
                System.out.println("The small New Year Present!");
                return NewYearPresent.smallPresent(list);
            case 2:
                System.out.println("The medium New Year Present!");
                return NewYearPresent.mediumPresent(list);
            case 3:
                System.out.println("The big New Year Present!");
                return NewYearPresent.bigPresent(list);
            default:
                System.out.println("You entered an incorrect number!\nPlease change between 1 and 3.");
        }
       return null;
    }
}