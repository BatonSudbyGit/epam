package primary_package;

import tasks.TaskOne;
import tasks.TaskThree;

import java.util.Scanner;

public class AllFunctions {

    public static String scannerString(){
        Scanner inputString = new Scanner(System.in);
        return  inputString.nextLine();
    }

    public static int scannerInt(){
        String inputInt = scannerString();
        int result;
        if (inputInt.matches("\\d+") || inputInt.matches("[-]\\d+")){
            result = Integer.parseInt(inputInt);
        }
        else {
            System.out.println("You entered incorrect character.\nYou only need to enter numbers!Try again : ");
            result = scannerInt();
        }
        return result;
    }

    public static void mainMenu(){
        System.out.println("This is a main menu of the program.Chose the task you interested in :" +
                "\n1.Task one. List and Map." +
                "\nIn this task,it is necessary to perform certain transformations with data, using the correct " +
                "\ncollections and algorithms from the Java Collection Framework.\n2.Task Two 'Dynamic Array'." +
                "\nCreate a DynamicArray class that is a native implementation of a dynamic container." +
                "\n3.Task three Stream API." +
                "\nIt's necessary to implement methods that meet the task and provide examples of their invocation." +
                "\nThis task should be performed using only the Stream API.");
        switch (scannerInt()){
            case 1:
                firstTaskMenu();
                break;
            case 2:
                dynamicArrayMainMenu();
                break;
            case 3:
                thirdTaskMainMenu();
                break;
            default:
                System.out.println("You entered an incorrect number!Try again." +
                        "\n__________________________________");
                mainMenu();
        }
    }

    public static void firstTaskMenu(){
        System.out.println("This is the main menu of of the first task." +
                "\nYou need to one of the tasks listed below :\n1.Generate a list of integers from one to X inclusive." +
                "\n2.Remove duplicates from the collection.\n3.Create a new list using only items in odd" +
                "positions of the original list.\n4.In the list of strings,count the strings consisting only of unique"+
                " characters,ignoring empty strings.\n5.Sort the list of rows by length in descending order." +
                "\n6.Check that there are no negative values in the list of numbers.\n7.In a string consisting of " +
                "characters  '(, ), [, ], {, }' ,check the correct placement of brackets,return true or false." +
                "The symbols must go in pairs,pairs can be nested into each other,but must not overlap.Example " +
                "of a correct expression: ({}[]([]){{}[]}).\n8.Generate a Map<Month,Integer> in which the keys will " +
                "be the elements of the java.time enumeration.Month, and the values are the length of the name " +
                "of this month.That is, the result should be like this:{MAY=3,SEPTEMBER=9,JUNE=4,APRIL=5 etс." +
                "\n9.Create a new Map from the original one so that the keys and values are swapped.If there are " +
                "identical values in the original Map, it is necessary to throw an IllegalArgumentException " +
                "with a description of the problem and a duplicate key.\n10.Transform List<Map<String,String>> " +
                "into a list of all values that are used in these Maps, sort by length,than alphabetically." +
                "\nEnter the number from 1 to 10 :");
        switch (scannerInt()){
            case 1:
                TaskOne.getIntArray();
                break;
            case 2:
                TaskOne.deleteDuplicates();
                break;
            case 3:
                TaskOne.getOddPositionsArray();
                break;
            case 4:
                TaskOne.countUniqueCharacters();
                break;
            case 5:
                TaskOne.sortStringToLength();
                break;
            case 6:
                TaskOne.negativeNumberValue();
                break;
            case 7:
                System.out.println(TaskOne.checkingPlacementBrackets(AllFunctions.scannerString()));
                break;
            case 8:
                TaskOne.monthsLength();
                break;
            case 9:
                TaskOne.replacementKayAndValue();
                break;
            case 10:
                TaskOne.transformListMap();
                break;
            default:
                System.out.println("You entered an incorrect number!Try again." +
                        "\n___________________________________");
                firstTaskMenu();
        }
    }

    public static void dynamicArrayMainMenu(){
        System.out.println("This is a main menu of the second Task.");
    }

    public static void thirdTaskMainMenu(){
        System.out.println("Third task main menu: " +
                "\nYou need to one of the tasks listed below :" +
                "\n1.Generate a list of integers from one to X inclusive" +
                "\n2.Create a new list using only the items in odd positions of the original list." +
                "\n3.In the list of strings, count the strings consisting only og unique characters," +
                " ignoring empty strings." +
                "\n4.Sort the list of rows by length in descending order." +
                "\n5.Check that there are no negative values in the list of numbers." +
                "\n6.Generate a Map <Month,Integer>,in witch the keys will be the elements of the java.time.Month" +
                " enumeration, and the values are the length of the name of this month.That is the result should be" +
                " like this : {MAY=3, SEPTEMBER=9, JUNE=4, APRIL=5, AUGUST=6, ..." +
                "\n7.Find the most frequent character in the string(excluding spaces)."+
                "\n8.Transform List<Map<String, String>> into a list of all values that are used in these Maps," +
                "sort by length,then alphabetically.\nEnter the number from 1 to 10 :");
        switch (scannerInt()){
            case 1:
                TaskThree.getIntArrayStream();
                break;
            case 2:
                TaskThree.getOddPositionsArrayStream();
            case 3:
                TaskThree.countUniqueCharactersStream();
                break;
            case 4:
                TaskThree.sortStringToLengthStream();
                break;
            case 5:
                TaskThree.negativeNumberValueStream();
                break;
            case 6:
                TaskThree.monthsLengthStream();
                break;
            case 7:
                TaskThree.findMostFrequentCharacterStream();
                break;
            case 8:
                TaskThree.transformListMapStream();
                break;
            default:
                System.out.println("You entered an incorrect number!Try again." +
                        "\n___________________________________");
                thirdTaskMainMenu();
        }
    }
}