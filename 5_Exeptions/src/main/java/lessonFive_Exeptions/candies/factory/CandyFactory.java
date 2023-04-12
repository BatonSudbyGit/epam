package lessonFive_Exeptions.candies.factory;

import lessonFive_Exeptions.candies.createCandies.*;
import lessonFive_Exeptions.primaryPackage.AllFunctions;

import java.util.ArrayList;

import static lessonFive_Exeptions.primaryPackage.AllFunctions.listOfCandies;

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
                AllFunctions.buyNewCandies(listOfCandies);
        }
        for (int i = 0; i < amount; i++) {
            list.add(typeOfCandy.buyNewCandy());
        }
        return list;
    }
}
