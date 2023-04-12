package lessonThree_mainPakage.primaryPakage;

import lessonThree_mainPakage.tasks.TaskOne;
import lessonThree_mainPakage.tasks.TaskThree;
import lessonThree_mainPakage.tasks.TaskTwo;

import java.util.ArrayList;
import java.util.Scanner;

public class AllFunctions {
    public static ArrayList<String> stringOfList = new ArrayList();

    public static String scannerString(){
        Scanner scanner = new Scanner(System.in);
        String inputSymbol = scanner.nextLine();
        return inputSymbol;
    }

    public static int scannerInt(){
        String inputInt = scannerString();
        int result;
        if (inputInt.matches("\\d+")){
            result = Integer.parseInt(inputInt);
        }
        else {
            System.out.println("You entered an incorrect character! \nYou need to enter a number. Please try again.");
            result = scannerInt();
        }
        return result;
    }

    public static void mainMenu(){
        System.out.println("This is a main menu of the program.Choose the module you interested in :" +
                "\n1.String processing.\n2.Regulation expressions.\n3.Working with date and time." +
                "\n0.If you want to quit");
        switch (scannerInt()){
            case 1:
                taskOneMainMenu();
                break;
            case 2:
                taskTwoMainMenu();
                break;
            case 3:
                taskThreeMainMenu();
                break;
            case 0:
                System.out.println("It's full, thank you.");
                break;
            default:
                System.out.println("You entered an incorrect number!Change between 1 and 3.");
                mainMenu();
        }
    }

    public static void taskOneMainMenu(){
        System.out.println("This is a main menu of the 'String processing' module." +
                "\nYou need to choose one of the tasks :\n1.Convert a positive number to binary." +
                "\n2.Convert the color of the format '#FB12F2' to 'rgb(251, 18, 242)'." +
                "\n3.Change the case of all letters to the opposite." +
                "\n4.Print an array of numbers.");
        switch (scannerInt()){
            case 1:
                TaskOne.createBinary();
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            case 2:
                TaskOne.color(scannerString());
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            case 3:
                TaskOne.changeLetterCase();
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            case 4:
                TaskOne.inputArray();
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            default:
                System.out.println("You entered an incorrect number!Change between 1 and 4." +
                        "\nTry again!");
                taskOneMainMenu();
        }
    }

    public static void taskTwoMainMenu(){
        System.out.println("This is a main menu of the 'Regular Expressions' module." +
                "You need to choose one of the tasks :\n1.Determinate the match of the first letters." +
                "\n2.Reverse the words.\n3.Convert the string 'lowerCaseName' to 'LOWER_CASE_NAME'." +
                "\n4.Convert the string 'UPPER_CASE_NAME' to 'upperCaseName'." +
                "\n5.Find name");
        switch (scannerInt()){
            case 1:
                TaskTwo.matchFirstLetters();
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            case 2:
                System.out.println("In this task you need to turn all the words backwards in " +
                        "a line consisting of words separated by spaces.\nEnter the string :");
                TaskTwo.reverseString(scannerString());
                System.out.println(" ");
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            case 3:
                TaskTwo.convertToUpper("lowerCaseName");
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            case 4:
                TaskTwo.convertToLower("UPPER_CASE_NAME");
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            case 5:
                TaskTwo.findName(stringOfList);
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            default:
                System.out.println("You entered an incorrect number!Change between 1 and 5." +
                        "\nTry again!");
                taskTwoMainMenu();
        }
    }

    public static void taskThreeMainMenu() {
        System.out.println("This is a main menu of the 'Working with dates and times' module." +
                "You need to choose one of the tasks :\n1.Return the name of the month." +
                "\n2.Return all the Friday 13 in a year.\n3.Find the last day of the month." +
                "\n4.Find the most distant date from today's date.\n5.Calculate how many hours are left from " +
                "transmitted time to midnight.");
        switch (scannerInt()) {
            case 1:
                TaskThree.numberOfMonths();
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            case 2:
                TaskThree.fridayOfYear(scannerInt());
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            case 3:
                TaskThree.findLastDayOfMonth(scannerInt(),scannerInt(),scannerInt());
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
            case 4:
                TaskThree.mostRemoteDate();
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            case 5:
                TaskThree.timeUntilMidnight(scannerInt(),scannerInt());
                System.out.println(" " + "\nYou can do something else.");
                mainMenu();
                break;
            default:
                System.out.println("You entered an incorrect number!Change between 1 and 5.\nTry again!");
                taskThreeMainMenu();
        }
    }
}