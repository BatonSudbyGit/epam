package lessonFive_Exeptions.candies.factory;

import lessonFive_Exeptions.candies.createCandies.Candy;
import lessonFive_Exeptions.candies.present.NewYearPresent;
import lessonFive_Exeptions.exeptions.ExeptionOne;
import lessonFive_Exeptions.primaryPackage.AllFunctions;

import java.util.ArrayList;

import static lessonFive_Exeptions.primaryPackage.AllFunctions.listOfCandies;

public class NewPresentFactory extends NewYearPresent {
    public static ArrayList<Candy> getNewPresent(ArrayList<Candy> list, int present ) {
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
                    AllFunctions.buyNewPresent(listOfCandies);
            }
            return null;
    }
}
