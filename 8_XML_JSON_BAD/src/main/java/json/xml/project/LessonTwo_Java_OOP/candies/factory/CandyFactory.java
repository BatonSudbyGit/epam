package json.xml.project.LessonTwo_Java_OOP.candies.factory;
import json.xml.project.LessonTwo_Java_OOP.candies.createCandies.*;

import java.util.ArrayList;

//Create the array list of candies.
public class CandyFactory {
    public static ArrayList<Candy> getNewCandies(int amount, ArrayList<Candy> list, int candy){
        Candy typeOfCandy = null;
        switch (candy){
            case 1:
                typeOfCandy = new CandyWithTopping();
                break;
            case 2:
                typeOfCandy = new Chocolate();
                break;
            case 3:
                typeOfCandy = new Caramel();
                break;
            case 4:
                typeOfCandy = new Lollipop();
                break;
            default:
                System.out.println("You enter incorrect number!\nChange between 1 and 4.");
        }
        for (int i = 0; i < amount; i++) {
            list.add((Candy) typeOfCandy.generateData());
        }
        return list;
    }
}